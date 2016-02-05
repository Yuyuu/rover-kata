package model;

public class Rover {

  public Rover(Grid grid) {
    this.grid = grid;
    instructionParser = new InstructionParser(this);
  }

  public String processInstructions(char[] instructions) {
    return instructionParser.apply(instructions);
  }

  public boolean move() {
    final Position nextPosition = position.forward(direction);
    if (!grid.hasObstacleAt(nextPosition)) {
      position = nextPosition;
      return true;
    }
    return false;
  }

  public void rotateRight() {
    direction = direction.rotate(Rotation.RIGHT);
  }

  public void rotateLeft() {
    direction = direction.rotate(Rotation.LEFT);
  }

  public String stringifiedPosition() {
    return position.toString() + "," + direction.initial();
  }

  private Position position = new Position(0, 0);
  private Direction direction = Direction.NORTH;
  private final InstructionParser instructionParser;
  private final Grid grid;
}
