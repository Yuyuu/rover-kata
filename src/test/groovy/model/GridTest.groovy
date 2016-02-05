package model

import spock.lang.Specification

class GridTest extends Specification {

  def "knows if there is an obstacle at a given position"() {
    given:
    Grid grid = new Grid([new Position(1, 3)])

    expect:
    grid.hasObstacleAt(new Position(1, 3))
  }
}
