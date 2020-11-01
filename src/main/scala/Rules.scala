class Rules(liveNeighborsForSurvival: Set[Int], liveNeighborsForBirth:Set[Int]) {
  def born(liveNeighbours: Int) = liveNeighborsForBirth.contains(liveNeighbours)
  def survives(liveNeighbours: Int) = liveNeighborsForSurvival.contains(liveNeighbours)
}

object Rules {
  val default = new Rules(Set(2, 3),Set(3))
}
