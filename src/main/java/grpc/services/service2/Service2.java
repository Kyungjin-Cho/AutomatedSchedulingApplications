package grpc.services.service2;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.services.schedule.Schedule;
import grpc.services.service2.ScheduleServiceGrpc.ScheduleServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2 extends ScheduleServiceImplBase {
	static int port = 3031;

	private List<Schedule> schedules = new ArrayList<>();

	public Service2() {
		// Add some schedules in advance to the schedules list
		schedules.add(Schedule.newBuilder().setName("john").setPosition("floor-staff").setDate("2023-04-10")
				.setStartTime("09:00").setEndTime("17:00").build());
		schedules.add(Schedule.newBuilder().setName("jane").setPosition("manager").setDate("2023-04-10")
				.setStartTime("10:00").setEndTime("18:00").build());
		schedules.add(Schedule.newBuilder().setName("bob").setPosition("cashier").setDate("2023-04-11")
				.setStartTime("11:00").setEndTime("19:00").build());
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 service2 = new Service2();

		Server server;
		try {
			server = ServerBuilder.forPort(port).addService(service2).build().start();
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

	public static void testJMDNS() {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Register a service
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "grpc", port, "path=index.html");
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
