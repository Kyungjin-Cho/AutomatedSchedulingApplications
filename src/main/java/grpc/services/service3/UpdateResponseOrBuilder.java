// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3.proto

package grpc.services.service3;

public interface UpdateResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service3.UpdateResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool is_updated = 1;</code>
   */
  boolean getIsUpdated();

  /**
   * <code>.service3.StaffSchedule staff_schedule = 2;</code>
   */
  boolean hasStaffSchedule();
  /**
   * <code>.service3.StaffSchedule staff_schedule = 2;</code>
   */
  grpc.services.service3.StaffSchedule getStaffSchedule();
  /**
   * <code>.service3.StaffSchedule staff_schedule = 2;</code>
   */
  grpc.services.service3.StaffScheduleOrBuilder getStaffScheduleOrBuilder();
}
