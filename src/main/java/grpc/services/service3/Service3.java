package grpc.services.service3;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import grpc.services.schedule.Schedule;
import grpc.services.service3.StaffAvailabilityGrpc.StaffAvailabilityImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3 extends StaffAvailabilityImplBase {

	private List<Schedule> schedules = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException, IOException {
		Service3 service3 = new Service3();

		int port = 50053;

		Server server = ServerBuilder.forPort(port).addService(service3).build().start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}

	@Override
	public StreamObserver<AvailabilityRequest> checkAvailability(
			StreamObserver<AvailabilityResponse> responseObserver) {
		return new StreamObserver<AvailabilityRequest>() {
			@Override
			public void onNext(AvailabilityRequest request) {
				String name = request.getName();
				String position = request.getPosition();
				String date = request.getDate();

				int workingHours = 0;
				Schedule staffSchedule = null;

				for (Schedule s : schedules) {
					if (s.getName().equals(name) && s.getPosition().equals(position) && s.getDate().equals(date)) {
						staffSchedule = s;
						workingHours += calculateWorkingHours(s);
					}
				}

				boolean isAvailable = staffSchedule == null;
				AvailabilityResponse response = AvailabilityResponse.newBuilder().setIsAvailable(isAvailable)
						.setWorkingHours(workingHours).setSchedule(staffSchedule).build();

				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				System.err.println("Error in checkAvailability: " + t);
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}

	@Override
	public StreamObserver<UpdateRequest> updateSchedule(StreamObserver<UpdateResponse> responseObserver) {
		return new StreamObserver<UpdateRequest>() {
			@Override
			public void onNext(UpdateRequest request) {
				Schedule staffSchedule = request.getStaffSchedule();

				boolean isUpdated = false;

				for (int i = 0; i < schedules.size(); i++) {
					Schedule s = schedules.get(i);
					if (s.getName().equals(staffSchedule.getName())
							&& s.getPosition().equals(staffSchedule.getPosition())
							&& s.getDate().equals(staffSchedule.getDate())) {
						schedules.set(i, staffSchedule);
						isUpdated = true;
						break;
					}
				}

				UpdateResponse response = UpdateResponse.newBuilder().setIsUpdated(isUpdated)
						.setStaffSchedule(staffSchedule).build();

				responseObserver.onNext(response);
			}

			@Override
			public void onError(Throwable t) {
				System.err.println("Error in updateSchedule: " + t);
			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}

	private int calculateWorkingHours(Schedule schedule) {
		LocalTime startTime = LocalTime.parse(schedule.getStartTime());
		LocalTime endTime = LocalTime.parse(schedule.getEndTime());
		int workingHours = (int) ChronoUnit.HOURS.between(startTime, endTime);
		return workingHours;
	}

}
