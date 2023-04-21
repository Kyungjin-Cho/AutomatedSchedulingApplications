package grpc.services.service1;

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
 * Service Definition for the 'ScheduleService'
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "service1.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.service1.ScheduleRequest,
      grpc.services.service1.ScheduleResponse> getRegisterScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerSchedule",
      requestType = grpc.services.service1.ScheduleRequest.class,
      responseType = grpc.services.service1.ScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.service1.ScheduleRequest,
      grpc.services.service1.ScheduleResponse> getRegisterScheduleMethod() {
    io.grpc.MethodDescriptor<grpc.services.service1.ScheduleRequest, grpc.services.service1.ScheduleResponse> getRegisterScheduleMethod;
    if ((getRegisterScheduleMethod = ScheduleServiceGrpc.getRegisterScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getRegisterScheduleMethod = ScheduleServiceGrpc.getRegisterScheduleMethod) == null) {
          ScheduleServiceGrpc.getRegisterScheduleMethod = getRegisterScheduleMethod = 
              io.grpc.MethodDescriptor.<grpc.services.service1.ScheduleRequest, grpc.services.service1.ScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.ScheduleService", "registerSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service1.ScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service1.ScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("registerSchedule"))
                  .build();
          }
        }
     }
     return getRegisterScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.service1.LoginRequest,
      grpc.services.service1.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = grpc.services.service1.LoginRequest.class,
      responseType = grpc.services.service1.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.service1.LoginRequest,
      grpc.services.service1.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<grpc.services.service1.LoginRequest, grpc.services.service1.LoginResponse> getLoginMethod;
    if ((getLoginMethod = ScheduleServiceGrpc.getLoginMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getLoginMethod = ScheduleServiceGrpc.getLoginMethod) == null) {
          ScheduleServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<grpc.services.service1.LoginRequest, grpc.services.service1.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.ScheduleService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service1.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service1.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
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
   * Service Definition for the 'ScheduleService'
   * </pre>
   */
  public static abstract class ScheduleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerSchedule(grpc.services.service1.ScheduleRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service1.ScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterScheduleMethod(), responseObserver);
    }

    /**
     */
    public void login(grpc.services.service1.LoginRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service1.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterScheduleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.service1.ScheduleRequest,
                grpc.services.service1.ScheduleResponse>(
                  this, METHODID_REGISTER_SCHEDULE)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.service1.LoginRequest,
                grpc.services.service1.LoginResponse>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition for the 'ScheduleService'
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
    public void registerSchedule(grpc.services.service1.ScheduleRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service1.ScheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(grpc.services.service1.LoginRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service1.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition for the 'ScheduleService'
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

    /**
     */
    public grpc.services.service1.ScheduleResponse registerSchedule(grpc.services.service1.ScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterScheduleMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.services.service1.LoginResponse login(grpc.services.service1.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition for the 'ScheduleService'
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.service1.ScheduleResponse> registerSchedule(
        grpc.services.service1.ScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterScheduleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.service1.LoginResponse> login(
        grpc.services.service1.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_SCHEDULE = 0;
  private static final int METHODID_LOGIN = 1;

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
        case METHODID_REGISTER_SCHEDULE:
          serviceImpl.registerSchedule((grpc.services.service1.ScheduleRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.service1.ScheduleResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((grpc.services.service1.LoginRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.service1.LoginResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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
      return grpc.services.service1.Service1Impl.getDescriptor();
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
              .addMethod(getRegisterScheduleMethod())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
