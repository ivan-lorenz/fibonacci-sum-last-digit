import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll
import org.scalacheck.Test.Parameters


object FibonacciCheck extends Properties("Fibonacci"){

  val genNonNegativesInts: Gen[Int] = Gen.choose(0, 40)
  val listOfNonNegatives: Gen[Array[Int]] =
    for {
      size <- Gen.choose(2,1000)
      elems <- Gen.containerOfN[Array, Int](size, genNonNegativesInts)
    } yield elems

  property("both solutions should be equivalent") =
    forAll(genNonNegativesInts){n  =>
      val assertion = FibonacciSumLastDigit.getFibonacciSumNaive(n) == FibonacciSumLastDigit.getFibonacciSumFast(n)
      if (!assertion) {
        System.out.println(n.toString)
      }
      assertion
    }

//  override def overrideParameters(p: Parameters): Parameters = p.withMinSuccessfulTests(10000)

}
