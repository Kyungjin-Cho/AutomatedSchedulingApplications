package grpc.services.service1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import grpc.services.service1.ScheduleServiceGrpc.ScheduleServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;


public class Service1 extends ScheduleServiceImplBase{

	private boolean loginSuccess = false;

	public static void main(String[] args) throws InterruptedException, IOException {
		Service1 service1 = new Service1();

		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}
	
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
	    // extract client name and position from request
	    String name = request.getName();
	    String position = request.getPosition();

	    // check login credentials and set authenticated and loginSuccess fields accordingly
	    boolean authenticated = checkLoginCredentials(name, position);
	    loginSuccess = authenticated ? true : false;

	    // set the message field based on login success
	    String message = loginSuccess ? "Login successful" : "Invalid username or password";

	    // create a LoginResponse object with the authenticated, loginSuccess, and message fields set
	    LoginResponse response = LoginResponse.newBuilder()
	            .setAuthenticated(authenticated)
	            .setLoginMessage(message)
	            .build();

	    // send the response to the client
	    responseObserver.onNext(response);
	    responseObserver.onCompleted();
	}

	@Override
    public void registerSchedule(ScheduleRequest request, StreamObserver<ScheduleResponse> responseObserver) {
        if (loginSuccess) {
            // extract client name, email, start time, and end time from request
            String name = request.getName();
            String position = request.getPosition();
            String date = request.getDate();
            String startTime = request.getStartTime();
            String endTime = request.getEndTime();

            // create a Schedule object
            Schedule schedule = Schedule.newBuilder()
                    .setName(name)
                    .setPosition(position)
                    .setDate(date)
                    .setStartTime(startTime)
                    .setEndTime(endTime)
                    .build();

            // create a ScheduleResponse object with the Schedule object as its property
            ScheduleResponse response = ScheduleResponse.newBuilder()
                    .setSchedule(schedule)
                    .build();

            // send the response to the client
            responseObserver.onNext(response);
            responseObserver.onCompleted();
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


}
