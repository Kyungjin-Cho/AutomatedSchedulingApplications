// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service1.proto

package grpc.services.service1;

public interface ScheduleResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service1.ScheduleResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool registered = 1;</code>
   */
  boolean getRegistered();

  /**
   * <code>.service1.Schedule schedule = 2;</code>
   */
  boolean hasSchedule();
  /**
   * <code>.service1.Schedule schedule = 2;</code>
   */
  grpc.services.service1.Schedule getSchedule();
  /**
   * <code>.service1.Schedule schedule = 2;</code>
   */
  grpc.services.service1.ScheduleOrBuilder getScheduleOrBuilder();
}