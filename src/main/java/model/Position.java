package model;

public class Position {

  public void forward() {
    switch (direction) {
      case NORTH:
        y += 1;
        return;
      case SOUTH:
        y -=1;
        return;
      case WEST:
        x -= 1;
        return;
      case EAST:
        x += 1;
    }
  }

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

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  private int x = 0;
  private int y = 0;
  private Direction direction = Direction.NORTH;
}
