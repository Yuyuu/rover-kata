package model;

public enum Direction {
  NORTH("N") {
    @Override
    public Direction rotate(Rotation rotation) {
      return rotation == Rotation.RIGHT ? Direction.EAST : Direction.WEST;
    }
  },
  SOUTH("S") {
    @Override
    public Direction rotate(Rotation rotation) {
      return rotation == Rotation.RIGHT ? Direction.WEST : Direction.EAST;
    }
  },
  WEST("W") {
    @Override
    public Direction rotate(Rotation rotation) {
      return rotation == Rotation.RIGHT ? Direction.NORTH : Direction.SOUTH;
    }
  },
  EAST("E") {
    @Override
    public Direction rotate(Rotation rotation) {
      return rotation == Rotation.RIGHT ? Direction.SOUTH : Direction.NORTH;
    }
  };

  Direction(String initial) {
    this.initial = initial;
  }

  public abstract Direction rotate(Rotation rotation);

  public String initial() {
    return initial;
  }

  private String initial;
}
