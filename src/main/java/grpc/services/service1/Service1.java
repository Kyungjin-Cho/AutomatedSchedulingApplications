package grpc.services.service1;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.services.schedule.Schedule;
import grpc.services.service1.ScheduleServiceGrpc.ScheduleServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class Service1 extends ScheduleServiceImplBase {
	static int port = 3030;
	private boolean loginSuccess = false;

	public static void main(String[] args) throws InterruptedException, IOException {
		Service1 service1 = new Service1();

		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(service1).build().start();
			System.out.println("Server started....");
			testJMDNS();
			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		// extract client name and position from request
		String name = request.getName();
		String position = request.getPosition();

		// check login credentials and set authenticated and loginSuccess fields
		// accordingly
		boolean authenticated = checkLoginCredentials(name, position);
		loginSuccess = authenticated ? true : false;

		// set the message field based on login success
		String message = loginSuccess ? "Login successful" : "Invalid username or password";

		// create a LoginResponse object with the authenticated, loginSuccess, and
		// message fields set
		LoginResponse response = LoginResponse.newBuilder().setAuthenticated(authenticated).setLoginMessage(message)
				.build();

		// send the response to the client
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void registerSchedule(ScheduleRequest request, StreamObserver<ScheduleResponse> responseObserver) {
		if (loginSuccess) {
			// extract schedule from request
			Schedule schedule = request.getSchedule();

			// create a ScheduleResponse object with the registered field set to true and
			// the Schedule object as its property
			ScheduleResponse response = ScheduleResponse.newBuilder().setRegistered(true).setSchedule(schedule).build();

			// send the response to the client
			responseObserver.onNext(response);
			responseObserver.onCompleted();

			// Register 10 schedules in advance for the three registered staffs with
			// different dates, start times, and end times
			String[] staffNames = { "john", "jane", "bob" };
			String[] positions = { "floor-staff", "manager", "cashier" };
			for (int i = 0; i < 10; i++) {
				Schedule newSchedule = Schedule.newBuilder().setName(staffNames[i % 3]).setPosition(positions[i % 3])
						.setDate("2023-04-" + (i + 1)) // Set different dates
						.setStartTime(String.format("%02d:%02d", i + 9, 0)) // Set different start times
						.setEndTime(String.format("%02d:%02d", i + 17, 0)) // Set different end times
						.build();

				// Register the new schedule by calling the same registerSchedule method
				// with the new Schedule object
				ScheduleRequest newRequest = ScheduleRequest.newBuilder().setSchedule(newSchedule).build();
				registerSchedule(newRequest, responseObserver);
			}
		} else {
			// if the login was not successful, send an error response
			responseObserver.onError(Status.PERMISSION_DENIED.withDescription("Login required").asRuntimeException());
		}
	}

	private boolean checkLoginCredentials(String username, String position) {
		// List of registered users
		Map<String, String> registeredUsers = new HashMap<>();
		registeredUsers.put("john", "floor-staff");
		registeredUsers.put("jane", "manager");
		registeredUsers.put("bob", "cashier");

		// Check if the supplied username and position match any of the registered users
		return registeredUsers.containsKey(username) && registeredUsers.get(username).equals(position);
	}

	public static void testJMDNS() {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Register a service
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "example", port, "path=index.html");
			jmdns.registerService(serviceInfo);

			// Wait a bit
			Thread.sleep(20000);

			// Unregister all services
			// jmdns.unregisterAllServices();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}