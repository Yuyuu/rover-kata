package model;

import java.util.List;

public class Grid {

  public Grid(List<Position> obstaclesPositions) {
    this.obstaclesPositions = obstaclesPositions;
  }

  public boolean hasObstacleAt(final Position position) {
    return obstaclesPositions.stream().anyMatch(it -> it.equals(position));
  }

  private final List<Position> obstaclesPositions;
  public static final int GRID_SIZE = 10;
}
