package model

import spock.lang.Specification

class InstructionParserTest extends Specification {

  def "parses list of instructions and executes actions accordingly"() {
    given:
    def rover = Mock(Rover)
    rover.stringifiedPosition() >> "2,1,N"
    def parser = new InstructionParser(rover)

    when:
    def finalPosition = parser.apply(['R', 'M', 'M', 'L', 'M'] as char[])

    then:
    1 * rover.rotateRight()
    then:
    2 * rover.move() >> true
    then:
    1 * rover.rotateLeft()
    then:
    1 * rover.move() >> true
    then:
    finalPosition == "2,1,N"
  }

  def "stops the sequence as soon as the rover cannot move"() {
    given:
    def rover = Mock(Rover)
    rover.move() >> false
    def parser = new InstructionParser(rover)

    when:
    parser.apply(['R', 'M', 'M', 'M', 'M', 'M'] as char[])

    then:
    1 * rover.rotateRight()
    1 * rover.move()
  }
}
