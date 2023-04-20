package grpc.services.client;

import grpc.services.schedule.Schedule;
import grpc.services.service3.*;
import grpc.services.service3.StaffAvailabilityGrpc.StaffAvailabilityStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private JPanel checkAvailabilityPanel;
	private JPanel updateSchedulePanel;
	private JFrame checkAvailabilityFrame;
	private JFrame updateScheduleFrame;
	private ManagedChannel channel;

	public Service3ClientGUI() {
		// Set up the gRPC channel
		channel = ManagedChannelBuilder.forAddress("localhost", 3032).usePlaintext().build(); // Update host and port
																								// according to your
																								// server configuration

		// Set up the GUI for checkAvailability
		checkAvailabilityFrame = new JFrame();
		checkAvailabilityFrame.setTitle("Availability Checker");
		checkAvailabilityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create input fields for checkAvailability
		nameTextField = new JTextField();
		positionTextField = new JTextField();
		startDateTextField = new JTextField();
		endDateTextField = new JTextField();

		// Create button for checkAvailability
		JButton checkAvailabilityButton = new JButton("Check Availability");

		// Create result text area for checkAvailability
		resultTextArea = new JTextArea();
		resultTextArea.setEditable(false);

		// Create layout manager for checkAvailability
		checkAvailabilityPanel = new JPanel();
		checkAvailabilityPanel.setLayout(new GridLayout(5, 2));
		checkAvailabilityPanel.add(new JLabel("Name: "));
		checkAvailabilityPanel.add(nameTextField);
		checkAvailabilityPanel.add(new JLabel("Position: "));
		checkAvailabilityPanel.add(positionTextField);
		checkAvailabilityPanel.add(new JLabel("Start Date(yyyy-mm-dd): "));
		checkAvailabilityPanel.add(startDateTextField);
		checkAvailabilityPanel.add(new JLabel("End Date(yyyy-mm-dd): "));
		checkAvailabilityPanel.add(endDateTextField);
		checkAvailabilityPanel.add(checkAvailabilityButton);
		checkAvailabilityPanel.add(resultTextArea);

		// Add checkAvailability panel to the frame
		checkAvailabilityFrame.add(checkAvailabilityPanel);

		// Set the size of the checkAvailabilityFrame
		checkAvailabilityFrame.setSize(700, 600); // Set the size to 400x300 pixels

		checkAvailabilityFrame.setVisible(true);

		// Register action listener for checkAvailability button
		checkAvailabilityButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkAvailability();
			}
		});

		// Set up the GUI for updateSchedule
		updateScheduleFrame = new JFrame();
		updateScheduleFrame.setTitle("Update Schedule");
		updateScheduleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create input fields for updateSchedule
		dateTextField = new JTextField();
		startTimeTextField = new JTextField();
		endTimeTextField = new JTextField();

		// Create button for updateSchedule
		JButton updateScheduleButton = new JButton("Update Schedule");

		// Create layout manager for updateSchedule
		updateSchedulePanel = new JPanel();
		updateSchedulePanel.setLayout(new GridLayout(4, 2));
		updateSchedulePanel.add(new JLabel("Date: "));
		updateSchedulePanel.add(dateTextField);
		updateSchedulePanel.add(new JLabel("Start Time(HH:MM): "));
		updateSchedulePanel.add(startTimeTextField);
		updateSchedulePanel.add(new JLabel("End Time(HH:MM): "));
		updateSchedulePanel.add(endTimeTextField);
		updateSchedulePanel.add(updateScheduleButton);

		// Add updateSchedule panel to the frame
		updateScheduleFrame.add(updateSchedulePanel);

		// Set the size of the updateScheduleFrame
		updateScheduleFrame.setSize(400, 300); // Set the size to 400x300 pixels

		// Set the updateSchedule panel to initially not visible
		updateSchedulePanel.setVisible(false);

		updateScheduleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSchedule();
			}
		});

		// Register JmDNS service listener to discover the service
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener("_date._tcp.local.", new ServiceListener() {
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Service removed: " + event.getInfo());
				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Service added: " + event.getInfo());
				}

				@Override
				public void serviceResolved(ServiceEvent event) {
					String host = event.getInfo().getHostAddresses()[0];
					int port = event.getInfo().getPort();
					channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
					availabilityStub = StaffAvailabilityGrpc.newStub(channel);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkAvailability() {
		// Initialize the availabilityStub variable
		availabilityStub = StaffAvailabilityGrpc.newStub(getChannel());

		String name = nameTextField.getText();
		String position = positionTextField.getText();
		String startDate = startDateTextField.getText();
		String endDate = endDateTextField.getText();

		// Check if startDate and endDate are valid dates
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start, end;
		try {
			start = sdf.parse(startDate);
			end = sdf.parse(endDate);
		} catch (ParseException e) {
			resultTextArea.setText("Error:\nInvalid date format. Please use yyyy-MM-dd.");
			return;
		}

		// Check if the period between startDate and endDate is 7 days
		long diff = end.getTime() - start.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		if (diffDays != 6) { // 6 days because the difference between two dates is inclusive of the start
								// date itself
			resultTextArea.setText("Error: The period from startDate to endDate should be 7 days.");
			return;
		}

		AvailabilityRequest request = AvailabilityRequest.newBuilder().setName(name).setPosition(position)
				.setStartDate(startDate).setEndDate(endDate).build();

		StreamObserver<AvailabilityResponse> responseObserver = new StreamObserver<AvailabilityResponse>() {
			@Override
			public void onNext(AvailabilityResponse response) {
				String result = "This staff is available considering working hours " + response.getWorkingHours() + "? "
						+ response.getIsAvailable();
				resultTextArea.setText(result);

				// Check if staff is available based on server-side logic
				boolean isAvailable = response.getIsAvailable(); // Get isAvailable status from the response

				// Show the updateSchedule panel if staff is available and working hours is less
				// than 40
				if (isAvailable && response.getWorkingHours() < 40) {
					updateSchedulePanel.setVisible(true);
					updateScheduleFrame.setVisible(true);
				} else {
					updateSchedulePanel.setVisible(false);
					updateScheduleFrame.setVisible(false); // Add this line to hide updateScheduleFrame
				}
			}

			@Override
			public void onError(Throwable t) {
				resultTextArea.setText("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				// Do nothing
			}
		};

		StreamObserver<AvailabilityRequest> requestObserver = availabilityStub.checkAvailability(responseObserver);
		requestObserver.onNext(request);
		requestObserver.onCompleted();
	}

	private void updateSchedule() {
		String name = nameTextField.getText();
		String position = positionTextField.getText();
		String date = dateTextField.getText();
		String startTime = startTimeTextField.getText();
		String endTime = endTimeTextField.getText();

		// Perform validation on input fields
		if (name.isEmpty() || position.isEmpty() || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
			JOptionPane.showMessageDialog(Service3ClientGUI.this, "Please fill in all fields", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Validate date format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			sdf.parse(date);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(Service3ClientGUI.this, "Invalid date format. Please use yyyy-MM-dd", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Create a Schedule object
		Schedule staffSchedule = Schedule.newBuilder().setName(name).setPosition(position).setDate(date)
				.setStartTime(startTime).setEndTime(endTime).build();

		// Create an UpdateRequest object
		UpdateRequest request = UpdateRequest.newBuilder().setStaffSchedule(staffSchedule).build();

		// Call the updateSchedule method with a StreamObserver
		availabilityStub.updateSchedule(new StreamObserver<UpdateResponse>() {
			@Override
			public void onNext(UpdateResponse response) {
				if (response.getIsUpdated()) {
					String result = "Update Schedule Result: " + response.getStaffSchedule();
					resultTextArea.setText(result);
					// Display success message
					JOptionPane.showMessageDialog(Service3ClientGUI.this, "Schedule updated successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					resultTextArea.setText("Error: Cannot update schedule on the same day as an existing schedule");
				}
			}

			@Override
			public void onError(Throwable t) {
				resultTextArea.setText("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				// This method will not be called in this case
			}
		}).onNext(request); // Pass the request to the onNext() method to initiate the RPC call
	}

	public void setAvailabilityStub(StaffAvailabilityStub availabilityStub) {
		this.availabilityStub = availabilityStub;
	}

	// Method to get the gRPC channel
	public ManagedChannel getChannel() {
		return channel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Service3ClientGUI clientGUI = new Service3ClientGUI();
			clientGUI.setVisible(true);
		});
	}
}