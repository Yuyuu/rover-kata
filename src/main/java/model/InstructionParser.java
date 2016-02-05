package model;

public class InstructionParser {

  public InstructionParser(Rover rover) {
    this.rover = rover;
  }

  public String apply(char[] instructions) {
    for (char instruction : instructions) {
      switch (instruction) {
        case 'M':
          final boolean hasMoved = rover.move();
          if (!hasMoved) {
            return "O," + rover.stringifiedPosition();
          }
          break;
        case 'L':
          rover.rotateLeft();
          break;
        case 'R':
          rover.rotateRight();
          break;
      }
    }
    return rover.stringifiedPosition();
  }

  private final Rover rover;
}
