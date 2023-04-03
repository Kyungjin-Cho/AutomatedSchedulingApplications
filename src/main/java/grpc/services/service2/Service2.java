package grpc.services.service2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import grpc.services.schedule.Schedule;
import grpc.services.service2.ScheduleServiceGrpc.ScheduleServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2 extends ScheduleServiceImplBase {

	private List<Schedule> schedules = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 service2 = new Service2();

		int port = 50052;

		Server server = ServerBuilder.forPort(port).addService(service2).build().start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}

	@Override
	public void listSchedule(ScheduleListRequest request, StreamObserver<ScheduleListResponse> responseObserver) {
		String name = request.getName();
		String position = request.getPosition();
		String date = request.getDate();

		List<Schedule> result = new ArrayList<>();
		for (Schedule s : schedules) {
			if (s.getName().equals(name) && s.getPosition().equals(position) && s.getDate().equals(date)) {
				result.add(s);
			}
		}

		ScheduleListResponse response = ScheduleListResponse.newBuilder().addAllSchedule(result).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	public void changeSchedule(ScheduleChangeRequest request, StreamObserver<ScheduleChangeResponse> responseObserver) {
		String name = request.getName();
		String position = request.getPosition();
		String date = request.getDate();
		String startTime = request.getStartTime();
		String endTime = request.getEndTime();

		Schedule newSchedule = Schedule.newBuilder().setName(name).setPosition(position).setDate(date)
				.setStartTime(startTime).setEndTime(endTime).build();

		boolean success = false;
		String message = "";

		for (int i = 0; i < schedules.size(); i++) {
			Schedule s = schedules.get(i);
			if (s.getName().equals(name) && s.getPosition().equals(position) && s.getDate().equals(date)) {
				schedules.set(i, newSchedule);
				success = true;
				message = "Schedule updated successfully";
				break;
			}
		}

		ScheduleChangeResponse response = ScheduleChangeResponse.newBuilder().setSuccess(success).setMessage(message)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}