package model

import spock.lang.Specification

class RoverTest extends Specification {

  def "starts its path at the beginning position of the grid"() {
    expect:
    new Rover(new Grid([])).stringifiedPosition() == "0,0,N"
  }

  def "can rotate right"() {
    given:
    def rover = new Rover(new Grid([]))

    when:
    rover.rotateRight()
    then:
    rover.stringifiedPosition() == "0,0,E"

    when:
    rover.rotateRight()
    then:
    rover.stringifiedPosition() == "0,0,S"

    when:
    rover.rotateRight()
    then:
    rover.stringifiedPosition() == "0,0,W"

    when:
    rover.rotateRight()
    then:
    rover.stringifiedPosition() == "0,0,N"
  }

  def "can rotate left"() {
    given:
    def rover = new Rover(new Grid([]))

    when:
    rover.rotateLeft()
    then:
    rover.stringifiedPosition() == "0,0,W"

    when:
    rover.rotateLeft()
    then:
    rover.stringifiedPosition() == "0,0,S"

    when:
    rover.rotateLeft()
    then:
    rover.stringifiedPosition() == "0,0,E"

    when:
    rover.rotateLeft()
    then:
    rover.stringifiedPosition() == "0,0,N"
  }

  def "can move forward in the current direction"() {
    given:
    def rover = new Rover(new Grid([]))

    when:
    rover.move()
    then:
    rover.stringifiedPosition() == "0,1,N"

    when:
    rover.rotateRight();
    rover.move()
    then:
    rover.stringifiedPosition() == "1,1,E"

    when:
    rover.rotateRight();
    rover.move()
    then:
    rover.stringifiedPosition() == "1,0,S"

    when:
    rover.rotateRight();
    rover.move()
    then:
    rover.stringifiedPosition() == "0,0,W"
  }

  def "can apply a sequence of instructions"() {
    given:
    def rover = new Rover(new Grid([]))

    expect:
    rover.processInstructions(['R', 'M', 'M', 'L', 'M'] as char[]) == "2,1,N"
  }

  def "only moves if there is no obstacle"() {
    given:
    def grid = new Grid([new Position(0, 1)])
    def rover = new Rover(grid)

    expect:
    !rover.move()
    rover.stringifiedPosition() == "0,0,N"
  }

  def "moves to the last possible position before an obstacle is encountered"() {
    given:
    def grid = new Grid([new Position(2, 1)])
    def rover = new Rover(grid)

    when:
    rover.processInstructions(['R', 'M', 'L', 'M', 'R', 'M', 'R', 'M'] as char[])

    then:
    rover.stringifiedPosition() == "1,1,E"
  }

  def "responds the position of th obstacle if any is faced"() {
    given:
    def grid = new Grid([new Position(2, 1)])
    def rover = new Rover(grid)

    expect:
    rover.processInstructions(['R', 'M', 'L', 'M', 'R', 'M', 'R', 'M'] as char[]) == "O,1,1,E"
  }
}
