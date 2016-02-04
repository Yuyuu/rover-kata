package model;

public class Rover {

  public Position rotateRight() {
    position.rotate(Rotation.RIGHT);
    return position;
  }

  public Position rotateLeft() {
    position.rotate(Rotation.LEFT);
    return position;
  }

  public String stringifiedPosition() {
    return position.toString();
  }

  private Position position = new Position();
}
