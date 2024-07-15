// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema.proto

package cz.cvut.fel.esw.server.proto;

/**
 * Protobuf type {@code OneToOne}
 */
public  final class OneToOne extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:OneToOne)
    OneToOneOrBuilder {
  // Use OneToOne.newBuilder() to construct.
  private OneToOne(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OneToOne() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private OneToOne(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            cz.cvut.fel.esw.server.proto.Location.Builder subBuilder = null;
            if (origin_ != null) {
              subBuilder = origin_.toBuilder();
            }
            origin_ = input.readMessage(cz.cvut.fel.esw.server.proto.Location.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(origin_);
              origin_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            cz.cvut.fel.esw.server.proto.Location.Builder subBuilder = null;
            if (destination_ != null) {
              subBuilder = destination_.toBuilder();
            }
            destination_ = input.readMessage(cz.cvut.fel.esw.server.proto.Location.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(destination_);
              destination_ = subBuilder.buildPartial();
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cz.cvut.fel.esw.server.proto.Schema.internal_static_OneToOne_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cz.cvut.fel.esw.server.proto.Schema.internal_static_OneToOne_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cz.cvut.fel.esw.server.proto.OneToOne.class, cz.cvut.fel.esw.server.proto.OneToOne.Builder.class);
  }

  public static final int ORIGIN_FIELD_NUMBER = 1;
  private cz.cvut.fel.esw.server.proto.Location origin_;
  /**
   * <code>optional .Location origin = 1;</code>
   */
  public boolean hasOrigin() {
    return origin_ != null;
  }
  /**
   * <code>optional .Location origin = 1;</code>
   */
  public cz.cvut.fel.esw.server.proto.Location getOrigin() {
    return origin_ == null ? cz.cvut.fel.esw.server.proto.Location.getDefaultInstance() : origin_;
  }
  /**
   * <code>optional .Location origin = 1;</code>
   */
  public cz.cvut.fel.esw.server.proto.LocationOrBuilder getOriginOrBuilder() {
    return getOrigin();
  }

  public static final int DESTINATION_FIELD_NUMBER = 2;
  private cz.cvut.fel.esw.server.proto.Location destination_;
  /**
   * <code>optional .Location destination = 2;</code>
   */
  public boolean hasDestination() {
    return destination_ != null;
  }
  /**
   * <code>optional .Location destination = 2;</code>
   */
  public cz.cvut.fel.esw.server.proto.Location getDestination() {
    return destination_ == null ? cz.cvut.fel.esw.server.proto.Location.getDefaultInstance() : destination_;
  }
  /**
   * <code>optional .Location destination = 2;</code>
   */
  public cz.cvut.fel.esw.server.proto.LocationOrBuilder getDestinationOrBuilder() {
    return getDestination();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (origin_ != null) {
      output.writeMessage(1, getOrigin());
    }
    if (destination_ != null) {
      output.writeMessage(2, getDestination());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (origin_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getOrigin());
    }
    if (destination_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getDestination());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof cz.cvut.fel.esw.server.proto.OneToOne)) {
      return super.equals(obj);
    }
    cz.cvut.fel.esw.server.proto.OneToOne other = (cz.cvut.fel.esw.server.proto.OneToOne) obj;

    boolean result = true;
    result = result && (hasOrigin() == other.hasOrigin());
    if (hasOrigin()) {
      result = result && getOrigin()
          .equals(other.getOrigin());
    }
    result = result && (hasDestination() == other.hasDestination());
    if (hasDestination()) {
      result = result && getDestination()
          .equals(other.getDestination());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (hasOrigin()) {
      hash = (37 * hash) + ORIGIN_FIELD_NUMBER;
      hash = (53 * hash) + getOrigin().hashCode();
    }
    if (hasDestination()) {
      hash = (37 * hash) + DESTINATION_FIELD_NUMBER;
      hash = (53 * hash) + getDestination().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cz.cvut.fel.esw.server.proto.OneToOne parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(cz.cvut.fel.esw.server.proto.OneToOne prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code OneToOne}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:OneToOne)
      cz.cvut.fel.esw.server.proto.OneToOneOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cz.cvut.fel.esw.server.proto.Schema.internal_static_OneToOne_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cz.cvut.fel.esw.server.proto.Schema.internal_static_OneToOne_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cz.cvut.fel.esw.server.proto.OneToOne.class, cz.cvut.fel.esw.server.proto.OneToOne.Builder.class);
    }

    // Construct using cz.cvut.fel.esw.server.proto.OneToOne.newBuilder()
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
    public Builder clear() {
      super.clear();
      if (originBuilder_ == null) {
        origin_ = null;
      } else {
        origin_ = null;
        originBuilder_ = null;
      }
      if (destinationBuilder_ == null) {
        destination_ = null;
      } else {
        destination_ = null;
        destinationBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cz.cvut.fel.esw.server.proto.Schema.internal_static_OneToOne_descriptor;
    }

    public cz.cvut.fel.esw.server.proto.OneToOne getDefaultInstanceForType() {
      return cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
    }

    public cz.cvut.fel.esw.server.proto.OneToOne build() {
      cz.cvut.fel.esw.server.proto.OneToOne result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cz.cvut.fel.esw.server.proto.OneToOne buildPartial() {
      cz.cvut.fel.esw.server.proto.OneToOne result = new cz.cvut.fel.esw.server.proto.OneToOne(this);
      if (originBuilder_ == null) {
        result.origin_ = origin_;
      } else {
        result.origin_ = originBuilder_.build();
      }
      if (destinationBuilder_ == null) {
        result.destination_ = destination_;
      } else {
        result.destination_ = destinationBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof cz.cvut.fel.esw.server.proto.OneToOne) {
        return mergeFrom((cz.cvut.fel.esw.server.proto.OneToOne)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cz.cvut.fel.esw.server.proto.OneToOne other) {
      if (other == cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance()) return this;
      if (other.hasOrigin()) {
        mergeOrigin(other.getOrigin());
      }
      if (other.hasDestination()) {
        mergeDestination(other.getDestination());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      cz.cvut.fel.esw.server.proto.OneToOne parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cz.cvut.fel.esw.server.proto.OneToOne) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private cz.cvut.fel.esw.server.proto.Location origin_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.Location, cz.cvut.fel.esw.server.proto.Location.Builder, cz.cvut.fel.esw.server.proto.LocationOrBuilder> originBuilder_;
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public boolean hasOrigin() {
      return originBuilder_ != null || origin_ != null;
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public cz.cvut.fel.esw.server.proto.Location getOrigin() {
      if (originBuilder_ == null) {
        return origin_ == null ? cz.cvut.fel.esw.server.proto.Location.getDefaultInstance() : origin_;
      } else {
        return originBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public Builder setOrigin(cz.cvut.fel.esw.server.proto.Location value) {
      if (originBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        origin_ = value;
        onChanged();
      } else {
        originBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public Builder setOrigin(
        cz.cvut.fel.esw.server.proto.Location.Builder builderForValue) {
      if (originBuilder_ == null) {
        origin_ = builderForValue.build();
        onChanged();
      } else {
        originBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public Builder mergeOrigin(cz.cvut.fel.esw.server.proto.Location value) {
      if (originBuilder_ == null) {
        if (origin_ != null) {
          origin_ =
            cz.cvut.fel.esw.server.proto.Location.newBuilder(origin_).mergeFrom(value).buildPartial();
        } else {
          origin_ = value;
        }
        onChanged();
      } else {
        originBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public Builder clearOrigin() {
      if (originBuilder_ == null) {
        origin_ = null;
        onChanged();
      } else {
        origin_ = null;
        originBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public cz.cvut.fel.esw.server.proto.Location.Builder getOriginBuilder() {
      
      onChanged();
      return getOriginFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    public cz.cvut.fel.esw.server.proto.LocationOrBuilder getOriginOrBuilder() {
      if (originBuilder_ != null) {
        return originBuilder_.getMessageOrBuilder();
      } else {
        return origin_ == null ?
            cz.cvut.fel.esw.server.proto.Location.getDefaultInstance() : origin_;
      }
    }
    /**
     * <code>optional .Location origin = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.Location, cz.cvut.fel.esw.server.proto.Location.Builder, cz.cvut.fel.esw.server.proto.LocationOrBuilder> 
        getOriginFieldBuilder() {
      if (originBuilder_ == null) {
        originBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cz.cvut.fel.esw.server.proto.Location, cz.cvut.fel.esw.server.proto.Location.Builder, cz.cvut.fel.esw.server.proto.LocationOrBuilder>(
                getOrigin(),
                getParentForChildren(),
                isClean());
        origin_ = null;
      }
      return originBuilder_;
    }

    private cz.cvut.fel.esw.server.proto.Location destination_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.Location, cz.cvut.fel.esw.server.proto.Location.Builder, cz.cvut.fel.esw.server.proto.LocationOrBuilder> destinationBuilder_;
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public boolean hasDestination() {
      return destinationBuilder_ != null || destination_ != null;
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public cz.cvut.fel.esw.server.proto.Location getDestination() {
      if (destinationBuilder_ == null) {
        return destination_ == null ? cz.cvut.fel.esw.server.proto.Location.getDefaultInstance() : destination_;
      } else {
        return destinationBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public Builder setDestination(cz.cvut.fel.esw.server.proto.Location value) {
      if (destinationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        destination_ = value;
        onChanged();
      } else {
        destinationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public Builder setDestination(
        cz.cvut.fel.esw.server.proto.Location.Builder builderForValue) {
      if (destinationBuilder_ == null) {
        destination_ = builderForValue.build();
        onChanged();
      } else {
        destinationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public Builder mergeDestination(cz.cvut.fel.esw.server.proto.Location value) {
      if (destinationBuilder_ == null) {
        if (destination_ != null) {
          destination_ =
            cz.cvut.fel.esw.server.proto.Location.newBuilder(destination_).mergeFrom(value).buildPartial();
        } else {
          destination_ = value;
        }
        onChanged();
      } else {
        destinationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public Builder clearDestination() {
      if (destinationBuilder_ == null) {
        destination_ = null;
        onChanged();
      } else {
        destination_ = null;
        destinationBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public cz.cvut.fel.esw.server.proto.Location.Builder getDestinationBuilder() {
      
      onChanged();
      return getDestinationFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    public cz.cvut.fel.esw.server.proto.LocationOrBuilder getDestinationOrBuilder() {
      if (destinationBuilder_ != null) {
        return destinationBuilder_.getMessageOrBuilder();
      } else {
        return destination_ == null ?
            cz.cvut.fel.esw.server.proto.Location.getDefaultInstance() : destination_;
      }
    }
    /**
     * <code>optional .Location destination = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.Location, cz.cvut.fel.esw.server.proto.Location.Builder, cz.cvut.fel.esw.server.proto.LocationOrBuilder> 
        getDestinationFieldBuilder() {
      if (destinationBuilder_ == null) {
        destinationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cz.cvut.fel.esw.server.proto.Location, cz.cvut.fel.esw.server.proto.Location.Builder, cz.cvut.fel.esw.server.proto.LocationOrBuilder>(
                getDestination(),
                getParentForChildren(),
                isClean());
        destination_ = null;
      }
      return destinationBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:OneToOne)
  }

  // @@protoc_insertion_point(class_scope:OneToOne)
  private static final cz.cvut.fel.esw.server.proto.OneToOne DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cz.cvut.fel.esw.server.proto.OneToOne();
  }

  public static cz.cvut.fel.esw.server.proto.OneToOne getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OneToOne>
      PARSER = new com.google.protobuf.AbstractParser<OneToOne>() {
    public OneToOne parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new OneToOne(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OneToOne> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OneToOne> getParserForType() {
    return PARSER;
  }

  public cz.cvut.fel.esw.server.proto.OneToOne getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
