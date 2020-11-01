import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class UniverseTest extends AnyFunSpec with Matchers {
  describe("Universe"){
    it("should support Empty Universe"){
      new Universe(Set.empty).tick shouldBe Universe.empty
    }
    it("should support Single Cell Universe"){
      new Universe(Set(Point(0,0))).tick shouldBe new Universe(Set.empty)
    }
    it("should support BlockPattern"){
      val liveCells = Set(
        Point(0, 0),Point(0, 1),
        Point(1, 0),Point(1, 1),
      )
      new Universe(liveCells).tick shouldBe new Universe(liveCells)
    }

    it("should support Blinker Pattern"){
      val liveCells = Set(
                    Point(0, 1),
                    Point(1, 1),
                    Point(2, 1)
      )

      val nextGenLiveCells = Set(

                    Point(1, 0),Point(1, 1),Point(1, 2)
      )

      new Universe(liveCells).tick shouldBe new Universe(nextGenLiveCells)
    }

    it("should support Glider Pattern"){
      val liveCells = Set(
                    Point(0, 1),
                                Point(1, 2),
        Point(2, 0),Point(2, 1),Point(2, 2)
      )

      val nextGenLiveCells = Set(

        Point(1, 0)           ,Point(1, 2),
                   Point(2, 1),Point(2, 2),
                   Point(3, 1)
      )

      val nextToNextGenLiveCells = Set(


                             Point(1, 2),
                   Point(2, 0),Point(2, 2),
                   Point(3, 1),Point(3, 2)
      )

      new Universe(liveCells).tick shouldBe new Universe(nextGenLiveCells)
      new Universe(liveCells).tick.tick shouldBe new Universe(nextToNextGenLiveCells)
    }
  }
}
