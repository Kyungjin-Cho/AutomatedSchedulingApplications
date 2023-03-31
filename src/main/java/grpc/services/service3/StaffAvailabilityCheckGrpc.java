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
public final class StaffAvailabilityCheckGrpc {

  private StaffAvailabilityCheckGrpc() {}

  public static final String SERVICE_NAME = "service3.StaffAvailabilityCheck";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.service3.StaffAvailabilityRequest,
      grpc.services.service3.StaffAvailabilityResponse> getGetStaffAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStaffAvailability",
      requestType = grpc.services.service3.StaffAvailabilityRequest.class,
      responseType = grpc.services.service3.StaffAvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.service3.StaffAvailabilityRequest,
      grpc.services.service3.StaffAvailabilityResponse> getGetStaffAvailabilityMethod() {
    io.grpc.MethodDescriptor<grpc.services.service3.StaffAvailabilityRequest, grpc.services.service3.StaffAvailabilityResponse> getGetStaffAvailabilityMethod;
    if ((getGetStaffAvailabilityMethod = StaffAvailabilityCheckGrpc.getGetStaffAvailabilityMethod) == null) {
      synchronized (StaffAvailabilityCheckGrpc.class) {
        if ((getGetStaffAvailabilityMethod = StaffAvailabilityCheckGrpc.getGetStaffAvailabilityMethod) == null) {
          StaffAvailabilityCheckGrpc.getGetStaffAvailabilityMethod = getGetStaffAvailabilityMethod = 
              io.grpc.MethodDescriptor.<grpc.services.service3.StaffAvailabilityRequest, grpc.services.service3.StaffAvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.StaffAvailabilityCheck", "GetStaffAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.StaffAvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.StaffAvailabilityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StaffAvailabilityCheckMethodDescriptorSupplier("GetStaffAvailability"))
                  .build();
          }
        }
     }
     return getGetStaffAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.service3.AvailableStaffRequest,
      grpc.services.service3.AvailableStaffResponse> getGetAvailableStaffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAvailableStaff",
      requestType = grpc.services.service3.AvailableStaffRequest.class,
      responseType = grpc.services.service3.AvailableStaffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.service3.AvailableStaffRequest,
      grpc.services.service3.AvailableStaffResponse> getGetAvailableStaffMethod() {
    io.grpc.MethodDescriptor<grpc.services.service3.AvailableStaffRequest, grpc.services.service3.AvailableStaffResponse> getGetAvailableStaffMethod;
    if ((getGetAvailableStaffMethod = StaffAvailabilityCheckGrpc.getGetAvailableStaffMethod) == null) {
      synchronized (StaffAvailabilityCheckGrpc.class) {
        if ((getGetAvailableStaffMethod = StaffAvailabilityCheckGrpc.getGetAvailableStaffMethod) == null) {
          StaffAvailabilityCheckGrpc.getGetAvailableStaffMethod = getGetAvailableStaffMethod = 
              io.grpc.MethodDescriptor.<grpc.services.service3.AvailableStaffRequest, grpc.services.service3.AvailableStaffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.StaffAvailabilityCheck", "GetAvailableStaff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.AvailableStaffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.service3.AvailableStaffResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StaffAvailabilityCheckMethodDescriptorSupplier("GetAvailableStaff"))
                  .build();
          }
        }
     }
     return getGetAvailableStaffMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StaffAvailabilityCheckStub newStub(io.grpc.Channel channel) {
    return new StaffAvailabilityCheckStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StaffAvailabilityCheckBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StaffAvailabilityCheckBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StaffAvailabilityCheckFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StaffAvailabilityCheckFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class StaffAvailabilityCheckImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC for getting staff availability by name or position on a specific date
     * </pre>
     */
    public void getStaffAvailability(grpc.services.service3.StaffAvailabilityRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service3.StaffAvailabilityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStaffAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server streaming RPC for getting all available staff for a specific position on a specific date
     * </pre>
     */
    public void getAvailableStaff(grpc.services.service3.AvailableStaffRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service3.AvailableStaffResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAvailableStaffMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStaffAvailabilityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.service3.StaffAvailabilityRequest,
                grpc.services.service3.StaffAvailabilityResponse>(
                  this, METHODID_GET_STAFF_AVAILABILITY)))
          .addMethod(
            getGetAvailableStaffMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.services.service3.AvailableStaffRequest,
                grpc.services.service3.AvailableStaffResponse>(
                  this, METHODID_GET_AVAILABLE_STAFF)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class StaffAvailabilityCheckStub extends io.grpc.stub.AbstractStub<StaffAvailabilityCheckStub> {
    private StaffAvailabilityCheckStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StaffAvailabilityCheckStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffAvailabilityCheckStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StaffAvailabilityCheckStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting staff availability by name or position on a specific date
     * </pre>
     */
    public void getStaffAvailability(grpc.services.service3.StaffAvailabilityRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service3.StaffAvailabilityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStaffAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server streaming RPC for getting all available staff for a specific position on a specific date
     * </pre>
     */
    public void getAvailableStaff(grpc.services.service3.AvailableStaffRequest request,
        io.grpc.stub.StreamObserver<grpc.services.service3.AvailableStaffResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAvailableStaffMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class StaffAvailabilityCheckBlockingStub extends io.grpc.stub.AbstractStub<StaffAvailabilityCheckBlockingStub> {
    private StaffAvailabilityCheckBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StaffAvailabilityCheckBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffAvailabilityCheckBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StaffAvailabilityCheckBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting staff availability by name or position on a specific date
     * </pre>
     */
    public grpc.services.service3.StaffAvailabilityResponse getStaffAvailability(grpc.services.service3.StaffAvailabilityRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStaffAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server streaming RPC for getting all available staff for a specific position on a specific date
     * </pre>
     */
    public java.util.Iterator<grpc.services.service3.AvailableStaffResponse> getAvailableStaff(
        grpc.services.service3.AvailableStaffRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAvailableStaffMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class StaffAvailabilityCheckFutureStub extends io.grpc.stub.AbstractStub<StaffAvailabilityCheckFutureStub> {
    private StaffAvailabilityCheckFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StaffAvailabilityCheckFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffAvailabilityCheckFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StaffAvailabilityCheckFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting staff availability by name or position on a specific date
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.service3.StaffAvailabilityResponse> getStaffAvailability(
        grpc.services.service3.StaffAvailabilityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStaffAvailabilityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STAFF_AVAILABILITY = 0;
  private static final int METHODID_GET_AVAILABLE_STAFF = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StaffAvailabilityCheckImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StaffAvailabilityCheckImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STAFF_AVAILABILITY:
          serviceImpl.getStaffAvailability((grpc.services.service3.StaffAvailabilityRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.service3.StaffAvailabilityResponse>) responseObserver);
          break;
        case METHODID_GET_AVAILABLE_STAFF:
          serviceImpl.getAvailableStaff((grpc.services.service3.AvailableStaffRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.service3.AvailableStaffResponse>) responseObserver);
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

  private static abstract class StaffAvailabilityCheckBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StaffAvailabilityCheckBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StaffAvailabilityCheck");
    }
  }

  private static final class StaffAvailabilityCheckFileDescriptorSupplier
      extends StaffAvailabilityCheckBaseDescriptorSupplier {
    StaffAvailabilityCheckFileDescriptorSupplier() {}
  }

  private static final class StaffAvailabilityCheckMethodDescriptorSupplier
      extends StaffAvailabilityCheckBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StaffAvailabilityCheckMethodDescriptorSupplier(String methodName) {
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
      synchronized (StaffAvailabilityCheckGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StaffAvailabilityCheckFileDescriptorSupplier())
              .addMethod(getGetStaffAvailabilityMethod())
              .addMethod(getGetAvailableStaffMethod())
              .build();
        }
      }
    }
    return result;
  }
}
