package model

import spock.lang.Specification

class RoverTest extends Specification {

  def "starts its path at the beginning position of the grid"() {
    expect:
    new Rover().stringifiedPosition() == "0,0,N"
  }

  def "can rotate right"() {
    given:
    def rover = new Rover()

    when:
    def newPosition = rover.rotateRight()
    then:
    newPosition.toString() == "0,0,E"

    when:
    newPosition = rover.rotateRight()
    then:
    newPosition.toString() == "0,0,S"

    when:
    newPosition = rover.rotateRight()
    then:
    newPosition.toString() == "0,0,W"

    when:
    newPosition = rover.rotateRight()
    then:
    newPosition.toString() == "0,0,N"
  }

  def "can rotate left"() {
    given:
    def rover = new Rover()

    when:
    def newPosition = rover.rotateLeft()
    then:
    newPosition.toString() == "0,0,W"

    when:
    newPosition = rover.rotateLeft()
    then:
    newPosition.toString() == "0,0,S"

    when:
    newPosition = rover.rotateLeft()
    then:
    newPosition.toString() == "0,0,E"

    when:
    newPosition = rover.rotateLeft()
    then:
    newPosition.toString() == "0,0,N"
  }

  def "can move forward in the current direction"() {
    given:
    def rover = new Rover()

    when:
    def newPosition = rover.move()
    then:
    newPosition.toString() == "0,1,N"

    when:
    rover.rotateRight();
    newPosition = rover.move()
    then:
    newPosition.toString() == "1,1,E"

    when:
    rover.rotateRight();
    newPosition = rover.move()
    then:
    newPosition.toString() == "1,0,S"

    when:
    rover.rotateRight();
    newPosition = rover.move()
    then:
    newPosition.toString() == "0,0,W"
  }
}
