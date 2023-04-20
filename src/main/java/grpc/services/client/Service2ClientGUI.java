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

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class Service2ClientGUI extends JFrame {
	// Add the serialVersionUID field
	private static final long serialVersionUID = 1L;

	private JFrame frame;

	private final JTextField nameTextField;
	private final JTextField positionTextField;
	private final JTextField dateTextField;
	private final JTextField startTimeTextField;
	private final JTextField endTimeTextField;
	private final JTextArea resultTextArea;

	private static ScheduleServiceGrpc.ScheduleServiceBlockingStub blockingStub;
	private static ManagedChannel channel;

	private static String host = "_http._tcp.local.";// = "localhost";
	private static int port;// = 3031;
	private static String resolvedIP;

	public Service2ClientGUI() {
		frame = new JFrame("Service2 Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Service2 Client GUI");
		setSize(500, 500);
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

		frame.add(inputPanel, BorderLayout.NORTH);

		resultTextArea = new JTextArea();
		resultTextArea.setRows(10);
		frame.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

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

		frame.add(changeSchedulePanel, BorderLayout.SOUTH); // Add changeSchedulePanel to the bottom of the JFrame

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

	public void createAndShowGUI() {
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Get the service information using JmDNS
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(host, new ServiceListener() {
				@Override
				public void serviceResolved(ServiceEvent event) {
					ServiceInfo info = event.getInfo();
					System.out.println("Service resolved: " + info);
					resolvedIP = info.getHostAddresses()[0];
					port = info.getPort();
					channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
					blockingStub = ScheduleServiceGrpc.newBlockingStub(channel);
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Service removed: " + event.getInfo());
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Service added: " + event.getInfo());
				}
			});
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		// Create the GUI
		Service2ClientGUI client = new Service2ClientGUI();
		client.createAndShowGUI();
	}
}