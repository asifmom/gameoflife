case class Universe(liveCells:Set[Point]){
  val rulesEngine=Rules.default
  def tick = new Universe(calculateLiveCells())

  def shouldSurvive(cell: Point) = {
    val liveNeighborsCount = cell.neighbors.intersect(liveCells).size
    rulesEngine.survives(liveNeighborsCount)
  }

  def calculateLiveCells() = {
    liveCells.filter(shouldSurvive)
  }

}

object Universe {
  val empty=Universe(Set.empty)
}
