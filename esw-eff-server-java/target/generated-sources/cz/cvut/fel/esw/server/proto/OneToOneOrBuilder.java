// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema.proto

package cz.cvut.fel.esw.server.proto;

public interface OneToOneOrBuilder extends
    // @@protoc_insertion_point(interface_extends:OneToOne)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .Location origin = 1;</code>
   */
  boolean hasOrigin();
  /**
   * <code>optional .Location origin = 1;</code>
   */
  cz.cvut.fel.esw.server.proto.Location getOrigin();
  /**
   * <code>optional .Location origin = 1;</code>
   */
  cz.cvut.fel.esw.server.proto.LocationOrBuilder getOriginOrBuilder();

  /**
   * <code>optional .Location destination = 2;</code>
   */
  boolean hasDestination();
  /**
   * <code>optional .Location destination = 2;</code>
   */
  cz.cvut.fel.esw.server.proto.Location getDestination();
  /**
   * <code>optional .Location destination = 2;</code>
   */
  cz.cvut.fel.esw.server.proto.LocationOrBuilder getDestinationOrBuilder();
}