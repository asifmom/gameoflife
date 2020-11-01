import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PointTest extends AnyFunSpec with Matchers {
  describe("Point") {
    it("should add point") {
      Point(1, 2) + Point(2, 3) shouldBe Point(3, 5)
    }
    it("should support Range") {
      Point(1, 2) to Point(2, 3) shouldBe Set(Point(1, 2), Point(1, 3), Point(2, 2), Point(2, 3))
    }
    it("should provide neighbours") {
      val expectedNeighBors = List(
        Point(0, 2), Point(1, 2), Point(2, 2),
        Point(0, 1),              Point(2, 1),
        Point(0, 0), Point(1, 0), Point(2, 0)
      ).toSet

      Point(1, 1).neighbors shouldBe expectedNeighBors
    }

    it("should provide neighbours 2") {
      val expectedNeighBors = List(
        Point(4, 49), Point(4, 50), Point(4, 51),
        Point(5, 49),               Point(5, 51), // ktlint-disable no-multi-sPointaces
        Point(6, 49), Point(6, 50), Point(6, 51),
      ).toSet

      Point(5, 50).neighbors shouldBe expectedNeighBors
    }
  }
}
