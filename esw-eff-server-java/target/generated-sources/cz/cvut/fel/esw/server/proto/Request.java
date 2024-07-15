// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema.proto

package cz.cvut.fel.esw.server.proto;

/**
 * Protobuf type {@code Request}
 */
public  final class Request extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Request)
    RequestOrBuilder {
  // Use Request.newBuilder() to construct.
  private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Request() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Request(
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
            cz.cvut.fel.esw.server.proto.Walk.Builder subBuilder = null;
            if (msgCase_ == 1) {
              subBuilder = ((cz.cvut.fel.esw.server.proto.Walk) msg_).toBuilder();
            }
            msg_ =
                input.readMessage(cz.cvut.fel.esw.server.proto.Walk.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((cz.cvut.fel.esw.server.proto.Walk) msg_);
              msg_ = subBuilder.buildPartial();
            }
            msgCase_ = 1;
            break;
          }
          case 18: {
            cz.cvut.fel.esw.server.proto.OneToOne.Builder subBuilder = null;
            if (msgCase_ == 2) {
              subBuilder = ((cz.cvut.fel.esw.server.proto.OneToOne) msg_).toBuilder();
            }
            msg_ =
                input.readMessage(cz.cvut.fel.esw.server.proto.OneToOne.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((cz.cvut.fel.esw.server.proto.OneToOne) msg_);
              msg_ = subBuilder.buildPartial();
            }
            msgCase_ = 2;
            break;
          }
          case 26: {
            cz.cvut.fel.esw.server.proto.OneToAll.Builder subBuilder = null;
            if (msgCase_ == 3) {
              subBuilder = ((cz.cvut.fel.esw.server.proto.OneToAll) msg_).toBuilder();
            }
            msg_ =
                input.readMessage(cz.cvut.fel.esw.server.proto.OneToAll.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((cz.cvut.fel.esw.server.proto.OneToAll) msg_);
              msg_ = subBuilder.buildPartial();
            }
            msgCase_ = 3;
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
    return cz.cvut.fel.esw.server.proto.Schema.internal_static_Request_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cz.cvut.fel.esw.server.proto.Schema.internal_static_Request_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cz.cvut.fel.esw.server.proto.Request.class, cz.cvut.fel.esw.server.proto.Request.Builder.class);
  }

  private int msgCase_ = 0;
  private java.lang.Object msg_;
  public enum MsgCase
      implements com.google.protobuf.Internal.EnumLite {
    WALK(1),
    ONETOONE(2),
    ONETOALL(3),
    MSG_NOT_SET(0);
    private final int value;
    private MsgCase(int value) {
      this.value = value;
    }
    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static MsgCase valueOf(int value) {
      return forNumber(value);
    }

    public static MsgCase forNumber(int value) {
      switch (value) {
        case 1: return WALK;
        case 2: return ONETOONE;
        case 3: return ONETOALL;
        case 0: return MSG_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public MsgCase
  getMsgCase() {
    return MsgCase.forNumber(
        msgCase_);
  }

  public static final int WALK_FIELD_NUMBER = 1;
  /**
   * <code>optional .Walk walk = 1;</code>
   */
  public cz.cvut.fel.esw.server.proto.Walk getWalk() {
    if (msgCase_ == 1) {
       return (cz.cvut.fel.esw.server.proto.Walk) msg_;
    }
    return cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance();
  }
  /**
   * <code>optional .Walk walk = 1;</code>
   */
  public cz.cvut.fel.esw.server.proto.WalkOrBuilder getWalkOrBuilder() {
    if (msgCase_ == 1) {
       return (cz.cvut.fel.esw.server.proto.Walk) msg_;
    }
    return cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance();
  }

  public static final int ONETOONE_FIELD_NUMBER = 2;
  /**
   * <code>optional .OneToOne oneToOne = 2;</code>
   */
  public cz.cvut.fel.esw.server.proto.OneToOne getOneToOne() {
    if (msgCase_ == 2) {
       return (cz.cvut.fel.esw.server.proto.OneToOne) msg_;
    }
    return cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
  }
  /**
   * <code>optional .OneToOne oneToOne = 2;</code>
   */
  public cz.cvut.fel.esw.server.proto.OneToOneOrBuilder getOneToOneOrBuilder() {
    if (msgCase_ == 2) {
       return (cz.cvut.fel.esw.server.proto.OneToOne) msg_;
    }
    return cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
  }

  public static final int ONETOALL_FIELD_NUMBER = 3;
  /**
   * <code>optional .OneToAll oneToAll = 3;</code>
   */
  public cz.cvut.fel.esw.server.proto.OneToAll getOneToAll() {
    if (msgCase_ == 3) {
       return (cz.cvut.fel.esw.server.proto.OneToAll) msg_;
    }
    return cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance();
  }
  /**
   * <code>optional .OneToAll oneToAll = 3;</code>
   */
  public cz.cvut.fel.esw.server.proto.OneToAllOrBuilder getOneToAllOrBuilder() {
    if (msgCase_ == 3) {
       return (cz.cvut.fel.esw.server.proto.OneToAll) msg_;
    }
    return cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance();
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
    if (msgCase_ == 1) {
      output.writeMessage(1, (cz.cvut.fel.esw.server.proto.Walk) msg_);
    }
    if (msgCase_ == 2) {
      output.writeMessage(2, (cz.cvut.fel.esw.server.proto.OneToOne) msg_);
    }
    if (msgCase_ == 3) {
      output.writeMessage(3, (cz.cvut.fel.esw.server.proto.OneToAll) msg_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (msgCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (cz.cvut.fel.esw.server.proto.Walk) msg_);
    }
    if (msgCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (cz.cvut.fel.esw.server.proto.OneToOne) msg_);
    }
    if (msgCase_ == 3) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, (cz.cvut.fel.esw.server.proto.OneToAll) msg_);
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
    if (!(obj instanceof cz.cvut.fel.esw.server.proto.Request)) {
      return super.equals(obj);
    }
    cz.cvut.fel.esw.server.proto.Request other = (cz.cvut.fel.esw.server.proto.Request) obj;

    boolean result = true;
    result = result && getMsgCase().equals(
        other.getMsgCase());
    if (!result) return false;
    switch (msgCase_) {
      case 1:
        result = result && getWalk()
            .equals(other.getWalk());
        break;
      case 2:
        result = result && getOneToOne()
            .equals(other.getOneToOne());
        break;
      case 3:
        result = result && getOneToAll()
            .equals(other.getOneToAll());
        break;
      case 0:
      default:
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
    switch (msgCase_) {
      case 1:
        hash = (37 * hash) + WALK_FIELD_NUMBER;
        hash = (53 * hash) + getWalk().hashCode();
        break;
      case 2:
        hash = (37 * hash) + ONETOONE_FIELD_NUMBER;
        hash = (53 * hash) + getOneToOne().hashCode();
        break;
      case 3:
        hash = (37 * hash) + ONETOALL_FIELD_NUMBER;
        hash = (53 * hash) + getOneToAll().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cz.cvut.fel.esw.server.proto.Request parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cz.cvut.fel.esw.server.proto.Request parseFrom(
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
  public static Builder newBuilder(cz.cvut.fel.esw.server.proto.Request prototype) {
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
   * Protobuf type {@code Request}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Request)
      cz.cvut.fel.esw.server.proto.RequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cz.cvut.fel.esw.server.proto.Schema.internal_static_Request_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cz.cvut.fel.esw.server.proto.Schema.internal_static_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cz.cvut.fel.esw.server.proto.Request.class, cz.cvut.fel.esw.server.proto.Request.Builder.class);
    }

    // Construct using cz.cvut.fel.esw.server.proto.Request.newBuilder()
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
      msgCase_ = 0;
      msg_ = null;
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cz.cvut.fel.esw.server.proto.Schema.internal_static_Request_descriptor;
    }

    public cz.cvut.fel.esw.server.proto.Request getDefaultInstanceForType() {
      return cz.cvut.fel.esw.server.proto.Request.getDefaultInstance();
    }

    public cz.cvut.fel.esw.server.proto.Request build() {
      cz.cvut.fel.esw.server.proto.Request result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public cz.cvut.fel.esw.server.proto.Request buildPartial() {
      cz.cvut.fel.esw.server.proto.Request result = new cz.cvut.fel.esw.server.proto.Request(this);
      if (msgCase_ == 1) {
        if (walkBuilder_ == null) {
          result.msg_ = msg_;
        } else {
          result.msg_ = walkBuilder_.build();
        }
      }
      if (msgCase_ == 2) {
        if (oneToOneBuilder_ == null) {
          result.msg_ = msg_;
        } else {
          result.msg_ = oneToOneBuilder_.build();
        }
      }
      if (msgCase_ == 3) {
        if (oneToAllBuilder_ == null) {
          result.msg_ = msg_;
        } else {
          result.msg_ = oneToAllBuilder_.build();
        }
      }
      result.msgCase_ = msgCase_;
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
      if (other instanceof cz.cvut.fel.esw.server.proto.Request) {
        return mergeFrom((cz.cvut.fel.esw.server.proto.Request)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cz.cvut.fel.esw.server.proto.Request other) {
      if (other == cz.cvut.fel.esw.server.proto.Request.getDefaultInstance()) return this;
      switch (other.getMsgCase()) {
        case WALK: {
          mergeWalk(other.getWalk());
          break;
        }
        case ONETOONE: {
          mergeOneToOne(other.getOneToOne());
          break;
        }
        case ONETOALL: {
          mergeOneToAll(other.getOneToAll());
          break;
        }
        case MSG_NOT_SET: {
          break;
        }
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
      cz.cvut.fel.esw.server.proto.Request parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cz.cvut.fel.esw.server.proto.Request) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int msgCase_ = 0;
    private java.lang.Object msg_;
    public MsgCase
        getMsgCase() {
      return MsgCase.forNumber(
          msgCase_);
    }

    public Builder clearMsg() {
      msgCase_ = 0;
      msg_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.Walk, cz.cvut.fel.esw.server.proto.Walk.Builder, cz.cvut.fel.esw.server.proto.WalkOrBuilder> walkBuilder_;
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public cz.cvut.fel.esw.server.proto.Walk getWalk() {
      if (walkBuilder_ == null) {
        if (msgCase_ == 1) {
          return (cz.cvut.fel.esw.server.proto.Walk) msg_;
        }
        return cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance();
      } else {
        if (msgCase_ == 1) {
          return walkBuilder_.getMessage();
        }
        return cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance();
      }
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public Builder setWalk(cz.cvut.fel.esw.server.proto.Walk value) {
      if (walkBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        msg_ = value;
        onChanged();
      } else {
        walkBuilder_.setMessage(value);
      }
      msgCase_ = 1;
      return this;
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public Builder setWalk(
        cz.cvut.fel.esw.server.proto.Walk.Builder builderForValue) {
      if (walkBuilder_ == null) {
        msg_ = builderForValue.build();
        onChanged();
      } else {
        walkBuilder_.setMessage(builderForValue.build());
      }
      msgCase_ = 1;
      return this;
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public Builder mergeWalk(cz.cvut.fel.esw.server.proto.Walk value) {
      if (walkBuilder_ == null) {
        if (msgCase_ == 1 &&
            msg_ != cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance()) {
          msg_ = cz.cvut.fel.esw.server.proto.Walk.newBuilder((cz.cvut.fel.esw.server.proto.Walk) msg_)
              .mergeFrom(value).buildPartial();
        } else {
          msg_ = value;
        }
        onChanged();
      } else {
        if (msgCase_ == 1) {
          walkBuilder_.mergeFrom(value);
        }
        walkBuilder_.setMessage(value);
      }
      msgCase_ = 1;
      return this;
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public Builder clearWalk() {
      if (walkBuilder_ == null) {
        if (msgCase_ == 1) {
          msgCase_ = 0;
          msg_ = null;
          onChanged();
        }
      } else {
        if (msgCase_ == 1) {
          msgCase_ = 0;
          msg_ = null;
        }
        walkBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public cz.cvut.fel.esw.server.proto.Walk.Builder getWalkBuilder() {
      return getWalkFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    public cz.cvut.fel.esw.server.proto.WalkOrBuilder getWalkOrBuilder() {
      if ((msgCase_ == 1) && (walkBuilder_ != null)) {
        return walkBuilder_.getMessageOrBuilder();
      } else {
        if (msgCase_ == 1) {
          return (cz.cvut.fel.esw.server.proto.Walk) msg_;
        }
        return cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance();
      }
    }
    /**
     * <code>optional .Walk walk = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.Walk, cz.cvut.fel.esw.server.proto.Walk.Builder, cz.cvut.fel.esw.server.proto.WalkOrBuilder> 
        getWalkFieldBuilder() {
      if (walkBuilder_ == null) {
        if (!(msgCase_ == 1)) {
          msg_ = cz.cvut.fel.esw.server.proto.Walk.getDefaultInstance();
        }
        walkBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cz.cvut.fel.esw.server.proto.Walk, cz.cvut.fel.esw.server.proto.Walk.Builder, cz.cvut.fel.esw.server.proto.WalkOrBuilder>(
                (cz.cvut.fel.esw.server.proto.Walk) msg_,
                getParentForChildren(),
                isClean());
        msg_ = null;
      }
      msgCase_ = 1;
      onChanged();;
      return walkBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.OneToOne, cz.cvut.fel.esw.server.proto.OneToOne.Builder, cz.cvut.fel.esw.server.proto.OneToOneOrBuilder> oneToOneBuilder_;
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public cz.cvut.fel.esw.server.proto.OneToOne getOneToOne() {
      if (oneToOneBuilder_ == null) {
        if (msgCase_ == 2) {
          return (cz.cvut.fel.esw.server.proto.OneToOne) msg_;
        }
        return cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
      } else {
        if (msgCase_ == 2) {
          return oneToOneBuilder_.getMessage();
        }
        return cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
      }
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public Builder setOneToOne(cz.cvut.fel.esw.server.proto.OneToOne value) {
      if (oneToOneBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        msg_ = value;
        onChanged();
      } else {
        oneToOneBuilder_.setMessage(value);
      }
      msgCase_ = 2;
      return this;
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public Builder setOneToOne(
        cz.cvut.fel.esw.server.proto.OneToOne.Builder builderForValue) {
      if (oneToOneBuilder_ == null) {
        msg_ = builderForValue.build();
        onChanged();
      } else {
        oneToOneBuilder_.setMessage(builderForValue.build());
      }
      msgCase_ = 2;
      return this;
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public Builder mergeOneToOne(cz.cvut.fel.esw.server.proto.OneToOne value) {
      if (oneToOneBuilder_ == null) {
        if (msgCase_ == 2 &&
            msg_ != cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance()) {
          msg_ = cz.cvut.fel.esw.server.proto.OneToOne.newBuilder((cz.cvut.fel.esw.server.proto.OneToOne) msg_)
              .mergeFrom(value).buildPartial();
        } else {
          msg_ = value;
        }
        onChanged();
      } else {
        if (msgCase_ == 2) {
          oneToOneBuilder_.mergeFrom(value);
        }
        oneToOneBuilder_.setMessage(value);
      }
      msgCase_ = 2;
      return this;
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public Builder clearOneToOne() {
      if (oneToOneBuilder_ == null) {
        if (msgCase_ == 2) {
          msgCase_ = 0;
          msg_ = null;
          onChanged();
        }
      } else {
        if (msgCase_ == 2) {
          msgCase_ = 0;
          msg_ = null;
        }
        oneToOneBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public cz.cvut.fel.esw.server.proto.OneToOne.Builder getOneToOneBuilder() {
      return getOneToOneFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    public cz.cvut.fel.esw.server.proto.OneToOneOrBuilder getOneToOneOrBuilder() {
      if ((msgCase_ == 2) && (oneToOneBuilder_ != null)) {
        return oneToOneBuilder_.getMessageOrBuilder();
      } else {
        if (msgCase_ == 2) {
          return (cz.cvut.fel.esw.server.proto.OneToOne) msg_;
        }
        return cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
      }
    }
    /**
     * <code>optional .OneToOne oneToOne = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.OneToOne, cz.cvut.fel.esw.server.proto.OneToOne.Builder, cz.cvut.fel.esw.server.proto.OneToOneOrBuilder> 
        getOneToOneFieldBuilder() {
      if (oneToOneBuilder_ == null) {
        if (!(msgCase_ == 2)) {
          msg_ = cz.cvut.fel.esw.server.proto.OneToOne.getDefaultInstance();
        }
        oneToOneBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cz.cvut.fel.esw.server.proto.OneToOne, cz.cvut.fel.esw.server.proto.OneToOne.Builder, cz.cvut.fel.esw.server.proto.OneToOneOrBuilder>(
                (cz.cvut.fel.esw.server.proto.OneToOne) msg_,
                getParentForChildren(),
                isClean());
        msg_ = null;
      }
      msgCase_ = 2;
      onChanged();;
      return oneToOneBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.OneToAll, cz.cvut.fel.esw.server.proto.OneToAll.Builder, cz.cvut.fel.esw.server.proto.OneToAllOrBuilder> oneToAllBuilder_;
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public cz.cvut.fel.esw.server.proto.OneToAll getOneToAll() {
      if (oneToAllBuilder_ == null) {
        if (msgCase_ == 3) {
          return (cz.cvut.fel.esw.server.proto.OneToAll) msg_;
        }
        return cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance();
      } else {
        if (msgCase_ == 3) {
          return oneToAllBuilder_.getMessage();
        }
        return cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance();
      }
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public Builder setOneToAll(cz.cvut.fel.esw.server.proto.OneToAll value) {
      if (oneToAllBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        msg_ = value;
        onChanged();
      } else {
        oneToAllBuilder_.setMessage(value);
      }
      msgCase_ = 3;
      return this;
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public Builder setOneToAll(
        cz.cvut.fel.esw.server.proto.OneToAll.Builder builderForValue) {
      if (oneToAllBuilder_ == null) {
        msg_ = builderForValue.build();
        onChanged();
      } else {
        oneToAllBuilder_.setMessage(builderForValue.build());
      }
      msgCase_ = 3;
      return this;
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public Builder mergeOneToAll(cz.cvut.fel.esw.server.proto.OneToAll value) {
      if (oneToAllBuilder_ == null) {
        if (msgCase_ == 3 &&
            msg_ != cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance()) {
          msg_ = cz.cvut.fel.esw.server.proto.OneToAll.newBuilder((cz.cvut.fel.esw.server.proto.OneToAll) msg_)
              .mergeFrom(value).buildPartial();
        } else {
          msg_ = value;
        }
        onChanged();
      } else {
        if (msgCase_ == 3) {
          oneToAllBuilder_.mergeFrom(value);
        }
        oneToAllBuilder_.setMessage(value);
      }
      msgCase_ = 3;
      return this;
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public Builder clearOneToAll() {
      if (oneToAllBuilder_ == null) {
        if (msgCase_ == 3) {
          msgCase_ = 0;
          msg_ = null;
          onChanged();
        }
      } else {
        if (msgCase_ == 3) {
          msgCase_ = 0;
          msg_ = null;
        }
        oneToAllBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public cz.cvut.fel.esw.server.proto.OneToAll.Builder getOneToAllBuilder() {
      return getOneToAllFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    public cz.cvut.fel.esw.server.proto.OneToAllOrBuilder getOneToAllOrBuilder() {
      if ((msgCase_ == 3) && (oneToAllBuilder_ != null)) {
        return oneToAllBuilder_.getMessageOrBuilder();
      } else {
        if (msgCase_ == 3) {
          return (cz.cvut.fel.esw.server.proto.OneToAll) msg_;
        }
        return cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance();
      }
    }
    /**
     * <code>optional .OneToAll oneToAll = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cz.cvut.fel.esw.server.proto.OneToAll, cz.cvut.fel.esw.server.proto.OneToAll.Builder, cz.cvut.fel.esw.server.proto.OneToAllOrBuilder> 
        getOneToAllFieldBuilder() {
      if (oneToAllBuilder_ == null) {
        if (!(msgCase_ == 3)) {
          msg_ = cz.cvut.fel.esw.server.proto.OneToAll.getDefaultInstance();
        }
        oneToAllBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cz.cvut.fel.esw.server.proto.OneToAll, cz.cvut.fel.esw.server.proto.OneToAll.Builder, cz.cvut.fel.esw.server.proto.OneToAllOrBuilder>(
                (cz.cvut.fel.esw.server.proto.OneToAll) msg_,
                getParentForChildren(),
                isClean());
        msg_ = null;
      }
      msgCase_ = 3;
      onChanged();;
      return oneToAllBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:Request)
  }

  // @@protoc_insertion_point(class_scope:Request)
  private static final cz.cvut.fel.esw.server.proto.Request DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cz.cvut.fel.esw.server.proto.Request();
  }

  public static cz.cvut.fel.esw.server.proto.Request getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Request>
      PARSER = new com.google.protobuf.AbstractParser<Request>() {
    public Request parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Request(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Request> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Request> getParserForType() {
    return PARSER;
  }

  public cz.cvut.fel.esw.server.proto.Request getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
