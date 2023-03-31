package grpc.services.service1;

import java.io.IOException;

import grpc.services.service1.ScheduleServiceGrpc.ScheduleServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Service1 extends ScheduleServiceImplBase{



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
	public void registerSchedule(ScheduleRequest request, StreamObserver<ScheduleResponse> responseObserver) {
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
	}




}
