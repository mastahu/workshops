package jug.lodz.workshops.fp1.exercises

import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, PropSpec}

/**
  * Created by pawel on 20.02.16.
  */
class ScalaFP1ExercisesFunctionImplementationCheck extends PropSpec with Matchers with PropertyChecks{

  import ScalaFP1ExercisesFunctionImplementation._

  property("Full Function of function f(x)=x+1 should return the same result as standard implementation"){
    forAll{(x:Int) =>
      addOntToXFull(x) shouldBe(addOneToX(x))
    }
  }

  property("Short Form of Function f(x)=x+1 should return the same result as standard implementation"){
    forAll{(x:Int) =>
      addOntToXShort(x) shouldBe(addOneToX(x))
    }
  }

  property("Full Function of function f(x)=x*2 should return the same result as standard implementation"){
    forAll{(x:Int) =>
      multiplyByTwoFull(x) shouldBe(multiplyXByTwo(x))
    }
  }

  property("Short Form of Function f(x)=x*2 should return the same result as standard implementation"){
    forAll{(x:Int) =>
      multiplyByTwoShort(x) shouldBe(multiplyXByTwo(x))
    }
  }

}
