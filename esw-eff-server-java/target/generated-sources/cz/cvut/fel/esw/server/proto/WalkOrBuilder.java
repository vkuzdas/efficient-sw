// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema.proto

package cz.cvut.fel.esw.server.proto;

public interface WalkOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Walk)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * repeated n times, determines edge directions
   * </pre>
   *
   * <code>repeated .Location locations = 1;</code>
   */
  java.util.List<cz.cvut.fel.esw.server.proto.Location> 
      getLocationsList();
  /**
   * <pre>
   * repeated n times, determines edge directions
   * </pre>
   *
   * <code>repeated .Location locations = 1;</code>
   */
  cz.cvut.fel.esw.server.proto.Location getLocations(int index);
  /**
   * <pre>
   * repeated n times, determines edge directions
   * </pre>
   *
   * <code>repeated .Location locations = 1;</code>
   */
  int getLocationsCount();
  /**
   * <pre>
   * repeated n times, determines edge directions
   * </pre>
   *
   * <code>repeated .Location locations = 1;</code>
   */
  java.util.List<? extends cz.cvut.fel.esw.server.proto.LocationOrBuilder> 
      getLocationsOrBuilderList();
  /**
   * <pre>
   * repeated n times, determines edge directions
   * </pre>
   *
   * <code>repeated .Location locations = 1;</code>
   */
  cz.cvut.fel.esw.server.proto.LocationOrBuilder getLocationsOrBuilder(
      int index);

  /**
   * <pre>
   * [mm], repeated n-1 times
   * </pre>
   *
   * <code>repeated uint32 lengths = 2;</code>
   */
  java.util.List<java.lang.Integer> getLengthsList();
  /**
   * <pre>
   * [mm], repeated n-1 times
   * </pre>
   *
   * <code>repeated uint32 lengths = 2;</code>
   */
  int getLengthsCount();
  /**
   * <pre>
   * [mm], repeated n-1 times
   * </pre>
   *
   * <code>repeated uint32 lengths = 2;</code>
   */
  int getLengths(int index);
}