package grpc.services.service3;

import java.io.IOException;

import grpc.services.service1.ScheduleServiceGrpc.ScheduleServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;


public class Service3 extends ScheduleServiceImplBase{



	public static void main(String[] args) throws InterruptedException, IOException {
		Service3 service3 = new Service3();

		int port = 50053;

		Server server = ServerBuilder.forPort(port)
				.addService(service3)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}



}
