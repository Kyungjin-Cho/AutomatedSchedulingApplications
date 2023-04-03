package grpc.services.service3;

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
    comments = "Source: service3.proto")
public final class StaffAvailabilityGrpc {

  private StaffAvailabilityGrpc() {}

  public static final String SERVICE_NAME = "service3.StaffAvailability";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.service3.AvailabilityRequest,
      grpc.services.service3.AvailabilityResponse> getCheckAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckAvailability",
      requestType = grpc.services.service3.AvailabilityRequest.class,
      responseType = grpc.services.service3.AvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.service3.AvailabilityRequest,
      grpc.services.service3.AvailabilityResponse> getCheckAvailabilityMethod() {
    io.grpc.MethodDescriptor<grpc.services.service3.AvailabilityRequest, grpc.services.service3.AvailabilityResponse> getCheckAvailabilityMethod;
    if ((getCheckAvailabilityMethod = StaffAvailabilityGrpc.getCheckAvailabilityMethod) == null) {
      synchronized (StaffAvailabilityGrpc.class) {
        if ((getCheckAvailabilityMethod = StaffAvailabilityGrpc.getCheckAvailabilityMethod) == null) {
          StaffAvailabilityGrpc.getCheckAvailabilityMethod = getCheckAvailabilityMethod = 
              io.grpc.MethodDescriptor.<grpc.services.service3.AvailabilityRequest, grpc.services.service3.AvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.StaffAvailability", "CheckAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.AvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.AvailabilityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StaffAvailabilityMethodDescriptorSupplier("CheckAvailability"))
                  .build();
          }
        }
     }
     return getCheckAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.service3.UpdateRequest,
      grpc.services.service3.UpdateResponse> getUpdateScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSchedule",
      requestType = grpc.services.service3.UpdateRequest.class,
      responseType = grpc.services.service3.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.service3.UpdateRequest,
      grpc.services.service3.UpdateResponse> getUpdateScheduleMethod() {
    io.grpc.MethodDescriptor<grpc.services.service3.UpdateRequest, grpc.services.service3.UpdateResponse> getUpdateScheduleMethod;
    if ((getUpdateScheduleMethod = StaffAvailabilityGrpc.getUpdateScheduleMethod) == null) {
      synchronized (StaffAvailabilityGrpc.class) {
        if ((getUpdateScheduleMethod = StaffAvailabilityGrpc.getUpdateScheduleMethod) == null) {
          StaffAvailabilityGrpc.getUpdateScheduleMethod = getUpdateScheduleMethod = 
              io.grpc.MethodDescriptor.<grpc.services.service3.UpdateRequest, grpc.services.service3.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.StaffAvailability", "UpdateSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.UpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StaffAvailabilityMethodDescriptorSupplier("UpdateSchedule"))
                  .build();
          }
        }
     }
     return getUpdateScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StaffAvailabilityStub newStub(io.grpc.Channel channel) {
    return new StaffAvailabilityStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StaffAvailabilityBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StaffAvailabilityBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StaffAvailabilityFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StaffAvailabilityFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class StaffAvailabilityImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Bidirectional RPC for checking staff availability and working hours
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.service3.AvailabilityRequest> checkAvailability(
        io.grpc.stub.StreamObserver<grpc.services.service3.AvailabilityResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCheckAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional RPC for updating staff schedule
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.service3.UpdateRequest> updateSchedule(
        io.grpc.stub.StreamObserver<grpc.services.service3.UpdateResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckAvailabilityMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.services.service3.AvailabilityRequest,
                grpc.services.service3.AvailabilityResponse>(
                  this, METHODID_CHECK_AVAILABILITY)))
          .addMethod(
            getUpdateScheduleMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.services.service3.UpdateRequest,
                grpc.services.service3.UpdateResponse>(
                  this, METHODID_UPDATE_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class StaffAvailabilityStub extends io.grpc.stub.AbstractStub<StaffAvailabilityStub> {
    private StaffAvailabilityStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StaffAvailabilityStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffAvailabilityStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StaffAvailabilityStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional RPC for checking staff availability and working hours
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.service3.AvailabilityRequest> checkAvailability(
        io.grpc.stub.StreamObserver<grpc.services.service3.AvailabilityResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCheckAvailabilityMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional RPC for updating staff schedule
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.service3.UpdateRequest> updateSchedule(
        io.grpc.stub.StreamObserver<grpc.services.service3.UpdateResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class StaffAvailabilityBlockingStub extends io.grpc.stub.AbstractStub<StaffAvailabilityBlockingStub> {
    private StaffAvailabilityBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StaffAvailabilityBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffAvailabilityBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StaffAvailabilityBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class StaffAvailabilityFutureStub extends io.grpc.stub.AbstractStub<StaffAvailabilityFutureStub> {
    private StaffAvailabilityFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StaffAvailabilityFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffAvailabilityFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StaffAvailabilityFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECK_AVAILABILITY = 0;
  private static final int METHODID_UPDATE_SCHEDULE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StaffAvailabilityImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StaffAvailabilityImplBase serviceImpl, int methodId) {
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
        case METHODID_CHECK_AVAILABILITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.checkAvailability(
              (io.grpc.stub.StreamObserver<grpc.services.service3.AvailabilityResponse>) responseObserver);
        case METHODID_UPDATE_SCHEDULE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateSchedule(
              (io.grpc.stub.StreamObserver<grpc.services.service3.UpdateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StaffAvailabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StaffAvailabilityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StaffAvailability");
    }
  }

  private static final class StaffAvailabilityFileDescriptorSupplier
      extends StaffAvailabilityBaseDescriptorSupplier {
    StaffAvailabilityFileDescriptorSupplier() {}
  }

  private static final class StaffAvailabilityMethodDescriptorSupplier
      extends StaffAvailabilityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StaffAvailabilityMethodDescriptorSupplier(String methodName) {
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
      synchronized (StaffAvailabilityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StaffAvailabilityFileDescriptorSupplier())
              .addMethod(getCheckAvailabilityMethod())
              .addMethod(getUpdateScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
