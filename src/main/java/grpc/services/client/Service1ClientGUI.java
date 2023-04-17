package grpc.services.client;

import java.awt.*;

import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import grpc.services.schedule.Schedule;
import grpc.services.service1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Service1ClientGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel loginPanel;
	private JPanel registerPanel;

	private JTextField usernameField;
	private JTextField userPositionField;
	private JButton loginButton;

	private JTextField nameField;
	private JTextField positionField;
	private JTextField dateField;
	private JTextField startTimeField;
	private JTextField endTimeField;
	private JButton addScheduleButton;

	private static ScheduleServiceGrpc.ScheduleServiceBlockingStub scheduleStub;
	private ManagedChannel channel;

	static String host = "_http._tcp.local.";// = "localhost";
	static int port;// = 3030;
	static String resolvedIP;

	public Service1ClientGUI() {
		setTitle("Schedule App");
		setSize(400, 300);

		// Create login panel
		loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints loginConstraints = new GridBagConstraints();
		loginConstraints.gridx = 0;
		loginConstraints.gridy = 0;
		loginConstraints.anchor = GridBagConstraints.CENTER;

		loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));

		usernameField = new JTextField(10);
		loginPanel.add(new JLabel("Username: "), loginConstraints);
		loginConstraints.gridx = 1;
		loginPanel.add(usernameField, loginConstraints);

		userPositionField = new JTextField(10);
		loginConstraints.gridx = 0;
		loginConstraints.gridy = 1;
		loginPanel.add(new JLabel("Position: "), loginConstraints);
		loginConstraints.gridx = 1;
		loginPanel.add(userPositionField, loginConstraints);

		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginConstraints.gridx = 0;
		loginConstraints.gridy = 2;
		loginConstraints.gridwidth = 2;
		loginPanel.add(loginButton, loginConstraints);

		// Create register panel
		registerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints registerConstraints = new GridBagConstraints();
		registerConstraints.gridx = 0;
		registerConstraints.gridy = 0;
		registerConstraints.anchor = GridBagConstraints.CENTER;
		registerPanel.setBorder(BorderFactory.createTitledBorder("Register Schedule"));
		nameField = new JTextField(10);
		registerPanel.add(new JLabel("Name: "), registerConstraints);
		registerConstraints.gridx = 1;
		registerPanel.add(nameField, registerConstraints);
		positionField = new JTextField(10);
		registerConstraints.gridx = 0;
		registerConstraints.gridy = 1;
		registerPanel.add(new JLabel("Position: "), registerConstraints);
		registerConstraints.gridx = 1;
		registerPanel.add(positionField, registerConstraints);
		dateField = new JTextField(10);
		registerConstraints.gridx = 0;
		registerConstraints.gridy = 2;
		registerPanel.add(new JLabel("Date(yyyy-mm-dd): "), registerConstraints);
		registerConstraints.gridx = 1;
		registerPanel.add(dateField, registerConstraints);
		startTimeField = new JTextField(10);
		registerConstraints.gridx = 0;
		registerConstraints.gridy = 3;
		registerPanel.add(new JLabel("Start Time(HH:MM): "), registerConstraints);
		registerConstraints.gridx = 1;
		registerPanel.add(startTimeField, registerConstraints);
		endTimeField = new JTextField(10);
		registerConstraints.gridx = 0;
		registerConstraints.gridy = 4;
		registerPanel.add(new JLabel("End Time(HH:MM): "), registerConstraints);
		registerConstraints.gridx = 1;
		registerPanel.add(endTimeField, registerConstraints);
		addScheduleButton = new JButton("Add Schedule");
		addScheduleButton.addActionListener(this);
		registerConstraints.gridx = 0;
		registerConstraints.gridy = 5;
		registerConstraints.gridwidth = 2;
		registerPanel.add(addScheduleButton, registerConstraints);

		// Set initial visibility of panels
		loginPanel.setVisible(true);
		registerPanel.setVisible(false);

		// Add panels to JFrame
		setLayout(new BorderLayout());
		add(loginPanel, BorderLayout.CENTER);
		add(registerPanel, BorderLayout.SOUTH);

		// Add window listener to close gRPC channel when window is closed
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				channel.shutdownNow();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			// Get input values from login panel
			String username = usernameField.getText();
			String position = userPositionField.getText();

			// Create LoginRequest
			LoginRequest request = LoginRequest.newBuilder().setName(username).setPosition(position).build();

			// Call gRPC login method
			LoginResponse response = scheduleStub.login(request);

			// Handle login response (e.g., show error message or switch to register panel)
			if (response.getAuthenticated()) {
				System.out.println("Login successful.");
				loginPanel.setVisible(false);
				registerPanel.setVisible(true);
			} else {
				System.out.println("Login failed");
				JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == addScheduleButton) {
			// Get input values from register panel
			String name = nameField.getText();
			String position = positionField.getText();
			String date = dateField.getText();
			String startTime = startTimeField.getText();
			String endTime = endTimeField.getText();

			// Create a Schedule object
			Schedule schedule = Schedule.newBuilder().setName(name).setPosition(position).setDate(date)
					.setStartTime(startTime).setEndTime(endTime).build();

			// Create a ScheduleRequest object
			ScheduleRequest request = ScheduleRequest.newBuilder().setSchedule(schedule).build();

			// Call the registerSchedule method on the ScheduleService client
			ScheduleResponse response = scheduleStub.registerSchedule(request);

			// Handle the response from the server
			if (response.getRegistered()) {
				System.out.println("Schedule registered successfully.");
			} else {
				System.out.println("Failed to register schedule.");
			}
		}
	}

	public static void main(String[] args) {
		testClientJMDNS();

		ManagedChannel channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
		scheduleStub = ScheduleServiceGrpc.newBlockingStub(channel);

		try {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Service1ClientGUI app = new Service1ClientGUI();
					app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					app.setVisible(true);
				}
			});

		} catch (StatusRuntimeException e) {
			e.getStatus();
		} finally {
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static class SampleListener implements ServiceListener {
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());
		}

		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}

		@SuppressWarnings("deprecation")
		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved: " + event.getInfo());

			ServiceInfo info = event.getInfo();
			port = info.getPort();
			resolvedIP = info.getHostAddress();
			System.out.println("IP Resolved - " + resolvedIP + ":" + port);
		}
	}

	public static void testClientJMDNS() {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a service listener
			jmdns.addServiceListener(host, new SampleListener());

			// Wait a bit
			Thread.sleep(20000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
