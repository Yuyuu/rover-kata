package model;

import com.google.common.base.Objects;

public class Position {

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position forward(Direction direction) {
    int gridSize = Grid.GRID_SIZE;
    switch (direction) {
      case SOUTH:
        return new Position(x, (y + gridSize) % (gridSize + 1));
      case WEST:
        return new Position((x + gridSize) % (gridSize + 1), y);
      case EAST:
        return new Position((x + 1) % (gridSize + 1), y);
      default:
        return new Position(x, (y + 1) % (gridSize + 1));
    }
  }

  public String toString() {
    return x + "," + y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return x == position.x &&
        y == position.y;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(x, y);
  }

  private final int x;
  private final int y;
}
