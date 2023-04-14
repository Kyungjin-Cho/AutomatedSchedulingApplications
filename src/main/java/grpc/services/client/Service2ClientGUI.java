package grpc.services.client;

import grpc.services.schedule.Schedule;
import grpc.services.service2.ScheduleChangeRequest;
import grpc.services.service2.ScheduleChangeResponse;
import grpc.services.service2.ScheduleListRequest;
import grpc.services.service2.ScheduleListResponse;
import grpc.services.service2.ScheduleServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Service2ClientGUI extends JFrame {
	// Add the serialVersionUID field
	private static final long serialVersionUID = 1L;

	private final JTextField nameTextField;
	private final JTextField positionTextField;
	private final JTextField dateTextField;
	private final JTextField startTimeTextField;
	private final JTextField endTimeTextField;
	private final JTextArea resultTextArea;

	private ScheduleServiceGrpc.ScheduleServiceBlockingStub blockingStub;

	public Service2ClientGUI() {
		setTitle("Service2 Client GUI");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel(new GridLayout(4, 2));

		inputPanel.add(new JLabel("Name:"));
		nameTextField = new JTextField();
		inputPanel.add(nameTextField);

		inputPanel.add(new JLabel("Position:"));
		positionTextField = new JTextField();
		inputPanel.add(positionTextField);

		inputPanel.add(new JLabel("Date(yyyy-mm-dd):"));
		dateTextField = new JTextField();
		inputPanel.add(dateTextField);

		JButton listScheduleButton = new JButton("List Schedule");
		listScheduleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listSchedule();
			}
		});
		inputPanel.add(listScheduleButton);

		add(inputPanel, BorderLayout.NORTH);

		resultTextArea = new JTextArea();
		add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

		JPanel changeSchedulePanel = new JPanel(new GridLayout(3, 2)); // Added panel for changing schedule
		changeSchedulePanel.setBorder(BorderFactory.createTitledBorder("Change Schedule"));

		changeSchedulePanel.add(new JLabel("Start Time(HH:MM):"));
		startTimeTextField = new JTextField();
		changeSchedulePanel.add(startTimeTextField);

		changeSchedulePanel.add(new JLabel("End Time(HH:MM):"));
		endTimeTextField = new JTextField();
		changeSchedulePanel.add(endTimeTextField);

		JButton changeScheduleButton = new JButton("Change Schedule");
		changeScheduleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeSchedule();
			}
		});
		changeSchedulePanel.add(changeScheduleButton);

		add(changeSchedulePanel, BorderLayout.SOUTH); // Add changeSchedulePanel to the bottom of the JFrame

		blockingStub = createBlockingStub("localhost", 3031);
	}

	private ScheduleServiceGrpc.ScheduleServiceBlockingStub createBlockingStub(String host, int port) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		return ScheduleServiceGrpc.newBlockingStub(channel);
	}

	private void listSchedule() {
		String name = nameTextField.getText();
		String position = positionTextField.getText();
		String date = dateTextField.getText();

		ScheduleListRequest request = ScheduleListRequest.newBuilder().setName(name).setPosition(position).setDate(date)
				.build();

		ScheduleListResponse response = blockingStub.listSchedule(request);

		resultTextArea.append("List of Schedules:\n");
		for (Schedule schedule : response.getScheduleList()) {
			resultTextArea.append("Name: " + schedule.getName() + "\n");
			resultTextArea.append("Position: " + schedule.getPosition() + "\n");
			resultTextArea.append("Date: " + schedule.getDate() + "\n");
			resultTextArea.append("Start Time: " + schedule.getStartTime() + "\n");
			resultTextArea.append("End Time: " + schedule.getEndTime() + "\n");
			resultTextArea.append("\n");
		}
	}

	private void changeSchedule() {
		String name = nameTextField.getText();
		String position = positionTextField.getText();
		String date = dateTextField.getText();
		String startTime = startTimeTextField.getText();
		String endTime = endTimeTextField.getText();

		ScheduleChangeRequest request = ScheduleChangeRequest.newBuilder().setName(name).setPosition(position)
				.setDate(date).setStartTime(startTime).setEndTime(endTime).build();

		StreamObserver<ScheduleChangeResponse> responseObserver = new StreamObserver<ScheduleChangeResponse>() {
			@Override
			public void onNext(ScheduleChangeResponse response) {
				boolean success = response.getSuccess();
				String message = response.getMessage();
				// Update UI with response information
				if (success) {
					// Schedule updated successfully
					JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// Failed to update schedule
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			@Override
			public void onError(Throwable throwable) {
				// Handle error from server
				JOptionPane.showMessageDialog(null, "Error: " + throwable.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			@Override
			public void onCompleted() {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(null, "Schedule change completed.", "Completed",
							JOptionPane.INFORMATION_MESSAGE);
					// Additional actions or UI updates
				});
			}
		};

		// Call the gRPC method and pass the responseObserver as an argument
		ScheduleServiceGrpc.ScheduleServiceStub asyncStub = createAsyncStub("localhost", 3031);
		asyncStub.changeSchedule(request, responseObserver);
	}

	private ScheduleServiceGrpc.ScheduleServiceStub createAsyncStub(String host, int port) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		return ScheduleServiceGrpc.newStub(channel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Service2ClientGUI app = new Service2ClientGUI();
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				app.setVisible(true);
			}
		});
	}
}
