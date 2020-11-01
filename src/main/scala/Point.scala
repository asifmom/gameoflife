
case class Point(x: Int, y: Int) {

  def neighbors = Point.neighborsOfOrigin.map{it=>it+this}

  def to(o: Point) = {
    (x to o.x).map { x => (y to o.y).map { y => Point(x, y) } }.flatten.toSet
  }

  def +(other: Point) = Point(x + other.x, y + other.y)
}

object Point {
   val neighborsOfOrigin = {
    (Point(-1, -1) to Point(1, 1)).filter(p=>p!=Point(0,0))
  }

}
