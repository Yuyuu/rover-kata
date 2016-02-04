package model;

public class InstructionParser {

  public InstructionParser(Rover rover) {
    this.rover = rover;
  }

  public void apply(char[] instructions) {
    for (char instruction : instructions) {
      switch (instruction) {
        case 'M':
          rover.move();
          break;
        case 'L':
          rover.rotateLeft();
          break;
        case 'R':
          rover.rotateRight();
          break;
      }
    }
  }

  private final Rover rover;
}
