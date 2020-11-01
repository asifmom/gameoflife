case class Universe(liveCells:Set[Point]){
  val rulesEngine=Rules.default
  def tick = new Universe(calculateSurvivingCells union calculateNewBornCells)

  private def calculateSurvivingCells = liveCells.filter(shouldSurvive)

  private def calculateNewBornCells = deadCells.filter(shouldBorn)

  private def shouldSurvive(cell: Point) = rulesEngine.survives(liveNeighBorsCount(cell))

  private def liveNeighBorsCount(cell: Point) = cell.neighbors.intersect(liveCells).size

  private def shouldBorn(cell: Point) = rulesEngine.born(liveNeighBorsCount(cell))

  private def deadCells = liveCells.map(_.neighbors.diff(liveCells)).flatten
}

object Universe {
  val empty=Universe(Set.empty)
}
