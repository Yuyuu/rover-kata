package model

import spock.lang.Specification

class InstructionParserTest extends Specification {

  def "parses list of instructions and executes actions accordingly"() {
    given:
    def rover = Mock(Rover)
    def parser = new InstructionParser(rover)

    when:
    parser.apply(['R', 'M', 'M', 'L', 'M'] as char[])

    then:
    1 * rover.rotateRight()
    then:
    2 * rover.move()
    then:
    1 * rover.rotateLeft()
    then:
    1 * rover.move()
  }
}
