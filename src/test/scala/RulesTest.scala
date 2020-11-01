import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class RulesTest extends AnyFunSpec with Matchers {
  val rulesEngine = Rules.default
  describe("Rules"){
    describe("survival"){
      it("should not survive with fewer than 2 live neighbors"){
        rulesEngine.survives(1) shouldBe false
        rulesEngine.survives(0) shouldBe false
      }
      describe("should survive"){
        it("should survive for 2 live neighbours"){
          rulesEngine.survives(2) shouldBe true
          rulesEngine.survives(3) shouldBe true
        }
      }
      describe("overpopulation"){
        rulesEngine.survives(4) shouldBe false
        rulesEngine.survives(6) shouldBe false
      }
    }
    describe("birth"){
      it("should get rebirth for exactly 3 live neigbours"){
        rulesEngine.born(3) shouldBe true
        rulesEngine.born(1) shouldBe false
        rulesEngine.born(4) shouldBe false
      }
    }
  }
}
