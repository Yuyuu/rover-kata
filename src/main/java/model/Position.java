package model;

public class Position {

  public Direction rotate(Rotation rotation) {
    direction = direction.rotate(rotation);
    return direction;
  }

  public String toString() {
    return x + "," + y + "," + direction.initial();
  }

  public Direction direction() {
    return direction;
  }

  private int x = 0;
  private int y = 0;
  private Direction direction = Direction.NORTH;
}
