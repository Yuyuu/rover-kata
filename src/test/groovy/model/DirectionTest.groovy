package model

import spock.lang.Specification

class DirectionTest extends Specification {

  def "a direction is associated to a letter"() {
    expect:
    Direction.NORTH.initial() == "N"
    Direction.SOUTH.initial() == "S"
    Direction.WEST.initial() == "W"
    Direction.EAST.initial() == "E"
  }

  def "can give the next direction for a rotation"(Direction preDirection, Rotation rotation, Direction postDirection) {
    expect:
    preDirection.rotate(rotation) == postDirection

    where:
    preDirection    | rotation       || postDirection
    Direction.NORTH | Rotation.RIGHT || Direction.EAST
    Direction.NORTH | Rotation.LEFT  || Direction.WEST
    Direction.SOUTH | Rotation.RIGHT || Direction.WEST
    Direction.SOUTH | Rotation.LEFT  || Direction.EAST
    Direction.WEST  | Rotation.RIGHT || Direction.NORTH
    Direction.WEST  | Rotation.LEFT  || Direction.SOUTH
    Direction.EAST  | Rotation.RIGHT || Direction.SOUTH
    Direction.EAST  | Rotation.LEFT  || Direction.NORTH
  }
}
