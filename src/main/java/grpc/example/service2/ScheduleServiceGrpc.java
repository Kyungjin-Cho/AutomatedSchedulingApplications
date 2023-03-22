package grpc.example.service2;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service2.proto")
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "service2.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.example.service2.ScheduleRequest,
      grpc.example.service2.ScheduleResponse> getChangeScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeSchedule",
      requestType = grpc.example.service2.ScheduleRequest.class,
      responseType = grpc.example.service2.ScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.service2.ScheduleRequest,
      grpc.example.service2.ScheduleResponse> getChangeScheduleMethod() {
    io.grpc.MethodDescriptor<grpc.example.service2.ScheduleRequest, grpc.example.service2.ScheduleResponse> getChangeScheduleMethod;
    if ((getChangeScheduleMethod = ScheduleServiceGrpc.getChangeScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getChangeScheduleMethod = ScheduleServiceGrpc.getChangeScheduleMethod) == null) {
          ScheduleServiceGrpc.getChangeScheduleMethod = getChangeScheduleMethod = 
              io.grpc.MethodDescriptor.<grpc.example.service2.ScheduleRequest, grpc.example.service2.ScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.ScheduleService", "ChangeSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.service2.ScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.service2.ScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("ChangeSchedule"))
                  .build();
          }
        }
     }
     return getChangeScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScheduleServiceStub newStub(io.grpc.Channel channel) {
    return new ScheduleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScheduleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ScheduleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScheduleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ScheduleServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class ScheduleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.service2.ScheduleRequest> changeSchedule(
        io.grpc.stub.StreamObserver<grpc.example.service2.ScheduleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChangeScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getChangeScheduleMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.example.service2.ScheduleRequest,
                grpc.example.service2.ScheduleResponse>(
                  this, METHODID_CHANGE_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class ScheduleServiceStub extends io.grpc.stub.AbstractStub<ScheduleServiceStub> {
    private ScheduleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScheduleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScheduleServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.service2.ScheduleRequest> changeSchedule(
        io.grpc.stub.StreamObserver<grpc.example.service2.ScheduleResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChangeScheduleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class ScheduleServiceBlockingStub extends io.grpc.stub.AbstractStub<ScheduleServiceBlockingStub> {
    private ScheduleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScheduleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScheduleServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class ScheduleServiceFutureStub extends io.grpc.stub.AbstractStub<ScheduleServiceFutureStub> {
    private ScheduleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScheduleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScheduleServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHANGE_SCHEDULE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScheduleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScheduleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHANGE_SCHEDULE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.changeSchedule(
              (io.grpc.stub.StreamObserver<grpc.example.service2.ScheduleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScheduleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.example.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScheduleService");
    }
  }

  private static final class ScheduleServiceFileDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier {
    ScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class ScheduleServiceMethodDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScheduleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScheduleServiceFileDescriptorSupplier())
              .addMethod(getChangeScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
