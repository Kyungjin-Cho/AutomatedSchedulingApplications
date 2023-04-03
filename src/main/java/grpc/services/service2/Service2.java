package grpc.services.service2;

import java.io.IOException;

import grpc.services.service1.ScheduleServiceGrpc.ScheduleServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;


public class Service2 extends ScheduleServiceImplBase{



	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 service2 = new Service2();

		int port = 50052;

		Server server = ServerBuilder.forPort(port)
				.addService(service2)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}



}
