import grpc.services.schedule.Schedule;
import grpc.services.service3.*;
import grpc.services.service3.StaffAvailabilityGrpc.StaffAvailabilityStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Service3ClientGUI extends JFrame {
	// Add the serialVersionUID field
	private static final long serialVersionUID = 1L;

	private StaffAvailabilityStub availabilityStub;
	private JTextField nameTextField;
	private JTextField positionTextField;
	private JTextField startDateTextField;
	private JTextField endDateTextField;
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField endTimeTextField;
	private JTextArea resultTextArea;

	public Service3ClientGUI() {
		// Set up the GUI
		setTitle("Availability Checker");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create input fields
		nameTextField = new JTextField();
		positionTextField = new JTextField();
		startDateTextField = new JTextField();
		endDateTextField = new JTextField();
		dateTextField = new JTextField();
		startTimeTextField = new JTextField();
		endTimeTextField = new JTextField();

		// Create buttons
		JButton checkAvailabilityButton = new JButton("Check Availability");
		JButton updateScheduleButton = new JButton("Update Schedule");

		// Create result text area
		resultTextArea = new JTextArea();
		resultTextArea.setEditable(false);

		// Create layout manager
		setLayout(new BorderLayout());

		// Create panels for input fields and buttons
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(7, 2));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		// Add components to the input panel
		inputPanel.add(new JLabel("Name: "));
		inputPanel.add(nameTextField);
		inputPanel.add(new JLabel("Position: "));
		inputPanel.add(positionTextField);
		inputPanel.add(new JLabel("Start Date: "));
		inputPanel.add(startDateTextField);
		inputPanel.add(new JLabel("End Date: "));
		inputPanel.add(endDateTextField);
		inputPanel.add(new JLabel("Date: "));
		inputPanel.add(dateTextField);
		inputPanel.add(new JLabel("Start Time: "));
		inputPanel.add(startTimeTextField);
		inputPanel.add(new JLabel("End Time: "));
		inputPanel.add(endTimeTextField);

		// Add components to the button panel
		buttonPanel.add(checkAvailabilityButton);
		buttonPanel.add(updateScheduleButton);

		// Add input panel, button panel, and result text area to the frame
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(new JScrollPane(resultTextArea), BorderLayout.NORTH);

		// Register action listeners for buttons
		checkAvailabilityButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAvailability();
			}
		});

		updateScheduleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSchedule();
			}
		});
	}

	private void checkAvailability() {
		String name = nameTextField.getText();
		String position = positionTextField.getText();
		String startDate = startDateTextField.getText();
		String endDate = endDateTextField.getText();

		AvailabilityRequest request = AvailabilityRequest.newBuilder().setName(name).setPosition(position)
				.setStartDate(startDate).setEndDate(endDate).build();

		availabilityStub.checkAvailability(request, new StreamObserver<AvailabilityResponse>() {
			@Override
			public void onNext(AvailabilityResponse response) {
				String result = "Is " + response.getName() + " available for " + response.getPosition() + " from "
						+ response.getStartDate() + " to " + response.getEndDate() + "? " + response.getAvailable();
				resultTextArea.setText(result);
			}

			@Override
			public void onError(Throwable t) {
				resultTextArea.setText("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				// Do nothing
			}
		});
	}

	private void updateSchedule() {
		String name = nameTextField.getText();
		String date = dateTextField.getText();
		String startTime = startTimeTextField.getText();
		String endTime = endTimeTextField.getText();

		Schedule schedule = Schedule.newBuilder().setName(name).setDate(date).setStartTime(startTime)
				.setEndTime(endTime).build();

		availabilityStub.updateSchedule(schedule, new StreamObserver<UpdateScheduleResponse>() {
			@Override
			public void onNext(UpdateScheduleResponse response) {
				resultTextArea.setText(response.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				resultTextArea.setText("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				// Do nothing
			}
		});
	}

	public void setAvailabilityStub(StaffAvailabilityStub availabilityStub) {
		this.availabilityStub = availabilityStub;
	}

	public static void main(String[] args) {
		// Create a new Service3ClientGUI instance
		Service3ClientGUI clientGUI = new Service3ClientGUI();

		// Create a gRPC channel to connect to the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 3032).usePlaintext().build();

		// Create a stub for the StaffAvailability service
		StaffAvailabilityStub availabilityStub = StaffAvailabilityGrpc.newStub(channel);

		// Set the availabilityStub in the clientGUI instance
		clientGUI.setAvailabilityStub(availabilityStub);

		// Show the GUI
		clientGUI.setVisible(true);
	}
}

