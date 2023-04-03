// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3.proto

package grpc.services.service3;

/**
 * Protobuf type {@code service3.UpdateRequest}
 */
public  final class UpdateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:service3.UpdateRequest)
    UpdateRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateRequest.newBuilder() to construct.
  private UpdateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            grpc.services.service3.StaffSchedule.Builder subBuilder = null;
            if (staffSchedule_ != null) {
              subBuilder = staffSchedule_.toBuilder();
            }
            staffSchedule_ = input.readMessage(grpc.services.service3.StaffSchedule.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(staffSchedule_);
              staffSchedule_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.services.service3.Service3Impl.internal_static_service3_UpdateRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.services.service3.Service3Impl.internal_static_service3_UpdateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.services.service3.UpdateRequest.class, grpc.services.service3.UpdateRequest.Builder.class);
  }

  public static final int STAFF_SCHEDULE_FIELD_NUMBER = 1;
  private grpc.services.service3.StaffSchedule staffSchedule_;
  /**
   * <code>.service3.StaffSchedule staff_schedule = 1;</code>
   */
  public boolean hasStaffSchedule() {
    return staffSchedule_ != null;
  }
  /**
   * <code>.service3.StaffSchedule staff_schedule = 1;</code>
   */
  public grpc.services.service3.StaffSchedule getStaffSchedule() {
    return staffSchedule_ == null ? grpc.services.service3.StaffSchedule.getDefaultInstance() : staffSchedule_;
  }
  /**
   * <code>.service3.StaffSchedule staff_schedule = 1;</code>
   */
  public grpc.services.service3.StaffScheduleOrBuilder getStaffScheduleOrBuilder() {
    return getStaffSchedule();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (staffSchedule_ != null) {
      output.writeMessage(1, getStaffSchedule());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (staffSchedule_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getStaffSchedule());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.services.service3.UpdateRequest)) {
      return super.equals(obj);
    }
    grpc.services.service3.UpdateRequest other = (grpc.services.service3.UpdateRequest) obj;

    boolean result = true;
    result = result && (hasStaffSchedule() == other.hasStaffSchedule());
    if (hasStaffSchedule()) {
      result = result && getStaffSchedule()
          .equals(other.getStaffSchedule());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasStaffSchedule()) {
      hash = (37 * hash) + STAFF_SCHEDULE_FIELD_NUMBER;
      hash = (53 * hash) + getStaffSchedule().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.services.service3.UpdateRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.service3.UpdateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.services.service3.UpdateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.service3.UpdateRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.services.service3.UpdateRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code service3.UpdateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:service3.UpdateRequest)
      grpc.services.service3.UpdateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.services.service3.Service3Impl.internal_static_service3_UpdateRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.services.service3.Service3Impl.internal_static_service3_UpdateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.services.service3.UpdateRequest.class, grpc.services.service3.UpdateRequest.Builder.class);
    }

    // Construct using grpc.services.service3.UpdateRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (staffScheduleBuilder_ == null) {
        staffSchedule_ = null;
      } else {
        staffSchedule_ = null;
        staffScheduleBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.services.service3.Service3Impl.internal_static_service3_UpdateRequest_descriptor;
    }

    @java.lang.Override
    public grpc.services.service3.UpdateRequest getDefaultInstanceForType() {
      return grpc.services.service3.UpdateRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.services.service3.UpdateRequest build() {
      grpc.services.service3.UpdateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.services.service3.UpdateRequest buildPartial() {
      grpc.services.service3.UpdateRequest result = new grpc.services.service3.UpdateRequest(this);
      if (staffScheduleBuilder_ == null) {
        result.staffSchedule_ = staffSchedule_;
      } else {
        result.staffSchedule_ = staffScheduleBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.services.service3.UpdateRequest) {
        return mergeFrom((grpc.services.service3.UpdateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.services.service3.UpdateRequest other) {
      if (other == grpc.services.service3.UpdateRequest.getDefaultInstance()) return this;
      if (other.hasStaffSchedule()) {
        mergeStaffSchedule(other.getStaffSchedule());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.services.service3.UpdateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.services.service3.UpdateRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private grpc.services.service3.StaffSchedule staffSchedule_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        grpc.services.service3.StaffSchedule, grpc.services.service3.StaffSchedule.Builder, grpc.services.service3.StaffScheduleOrBuilder> staffScheduleBuilder_;
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public boolean hasStaffSchedule() {
      return staffScheduleBuilder_ != null || staffSchedule_ != null;
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public grpc.services.service3.StaffSchedule getStaffSchedule() {
      if (staffScheduleBuilder_ == null) {
        return staffSchedule_ == null ? grpc.services.service3.StaffSchedule.getDefaultInstance() : staffSchedule_;
      } else {
        return staffScheduleBuilder_.getMessage();
      }
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public Builder setStaffSchedule(grpc.services.service3.StaffSchedule value) {
      if (staffScheduleBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        staffSchedule_ = value;
        onChanged();
      } else {
        staffScheduleBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public Builder setStaffSchedule(
        grpc.services.service3.StaffSchedule.Builder builderForValue) {
      if (staffScheduleBuilder_ == null) {
        staffSchedule_ = builderForValue.build();
        onChanged();
      } else {
        staffScheduleBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public Builder mergeStaffSchedule(grpc.services.service3.StaffSchedule value) {
      if (staffScheduleBuilder_ == null) {
        if (staffSchedule_ != null) {
          staffSchedule_ =
            grpc.services.service3.StaffSchedule.newBuilder(staffSchedule_).mergeFrom(value).buildPartial();
        } else {
          staffSchedule_ = value;
        }
        onChanged();
      } else {
        staffScheduleBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public Builder clearStaffSchedule() {
      if (staffScheduleBuilder_ == null) {
        staffSchedule_ = null;
        onChanged();
      } else {
        staffSchedule_ = null;
        staffScheduleBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public grpc.services.service3.StaffSchedule.Builder getStaffScheduleBuilder() {
      
      onChanged();
      return getStaffScheduleFieldBuilder().getBuilder();
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    public grpc.services.service3.StaffScheduleOrBuilder getStaffScheduleOrBuilder() {
      if (staffScheduleBuilder_ != null) {
        return staffScheduleBuilder_.getMessageOrBuilder();
      } else {
        return staffSchedule_ == null ?
            grpc.services.service3.StaffSchedule.getDefaultInstance() : staffSchedule_;
      }
    }
    /**
     * <code>.service3.StaffSchedule staff_schedule = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        grpc.services.service3.StaffSchedule, grpc.services.service3.StaffSchedule.Builder, grpc.services.service3.StaffScheduleOrBuilder> 
        getStaffScheduleFieldBuilder() {
      if (staffScheduleBuilder_ == null) {
        staffScheduleBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            grpc.services.service3.StaffSchedule, grpc.services.service3.StaffSchedule.Builder, grpc.services.service3.StaffScheduleOrBuilder>(
                getStaffSchedule(),
                getParentForChildren(),
                isClean());
        staffSchedule_ = null;
      }
      return staffScheduleBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:service3.UpdateRequest)
  }

  // @@protoc_insertion_point(class_scope:service3.UpdateRequest)
  private static final grpc.services.service3.UpdateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.services.service3.UpdateRequest();
  }

  public static grpc.services.service3.UpdateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateRequest>() {
    @java.lang.Override
    public UpdateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.services.service3.UpdateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

