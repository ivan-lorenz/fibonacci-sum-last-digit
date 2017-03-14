import org.scalatest.FlatSpec

class FibonacciTest extends FlatSpec{

  behavior of "FibonacciSumLastDigit"

  it should "sum fibonacci last digit for a case" in {
    assert(FibonacciSumLastDigit.getFibonacciSumFast(3) == 4)
  }

  it should "sum fibonacci last digit for b case" in {
    assert(FibonacciSumLastDigit.getFibonacciSumFast(100) == 5)
  }


}
