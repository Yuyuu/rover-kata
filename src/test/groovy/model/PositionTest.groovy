package model

import spock.lang.Specification

class PositionTest extends Specification {

  def "can get the position as a string"() {
    given:
    def position = new Position(2, 3)

    expect:
    position.toString() == "2,3"
  }

  def "calculates a new position according to a forward move"() {
    given:
    def position = new Position(preX, preY)

    when:
    def nextPosition = position.forward(direction)

    then:
    nextPosition.x() == postX
    nextPosition.y() == postY

    where:
    preX | preY | direction       || postX | postY
    0    | 0    | Direction.NORTH || 0     | 1
    0    | 0    | Direction.EAST  || 1     | 0
    1    | 1    | Direction.SOUTH || 1     | 0
    1    | 1    | Direction.WEST  || 0     | 1
  }

  def "wraps around when reaching the edge of the grid"() {
    given:
    def position = new Position(preX, preY)

    when:
    def nextPosition = position.forward(direction)

    then:
    nextPosition.x() == postX
    nextPosition.y() == postY

    where:
    preX | preY | direction       || postX | postY
    5    | 0    | Direction.SOUTH || 5     | 10
    10   | 2    | Direction.EAST  || 0     | 2
    3    | 10   | Direction.NORTH || 3     | 0
    0    | 10   | Direction.WEST  || 10    | 10
  }
}
