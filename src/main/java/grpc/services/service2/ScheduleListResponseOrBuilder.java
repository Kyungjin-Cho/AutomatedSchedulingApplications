// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2.proto

package grpc.services.service2;

public interface ScheduleListResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service2.ScheduleListResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .schedule.Schedule schedule = 1;</code>
   */
  java.util.List<grpc.services.schedule.Schedule> 
      getScheduleList();
  /**
   * <code>repeated .schedule.Schedule schedule = 1;</code>
   */
  grpc.services.schedule.Schedule getSchedule(int index);
  /**
   * <code>repeated .schedule.Schedule schedule = 1;</code>
   */
  int getScheduleCount();
  /**
   * <code>repeated .schedule.Schedule schedule = 1;</code>
   */
  java.util.List<? extends grpc.services.schedule.ScheduleOrBuilder> 
      getScheduleOrBuilderList();
  /**
   * <code>repeated .schedule.Schedule schedule = 1;</code>
   */
  grpc.services.schedule.ScheduleOrBuilder getScheduleOrBuilder(
      int index);
}