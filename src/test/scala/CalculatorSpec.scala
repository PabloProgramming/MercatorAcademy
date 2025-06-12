import scalaFundamentals.Calculator
import org.scalatest.flatspec.AnyFlatSpec

class CalculatorSpec extends AnyFlatSpec {

  val calculator: Calculator = new Calculator

  "add" should ("add two numbers") in {
    // val arrange = calculator.add(2, 3)
    // val expectedResult = 5
    //assert(arrange == expectedResult)
    assert(calculator.add(2, 3) == 5)
  }

  "multiply" should ("multiply two numbers") in {
    assert(calculator.multiply(5, 2) == 10)
  }


  "subtract" should ("subtract two numbers, greater number first (a - b") in {
    assert(calculator.subtract(5, 2) == 3)
  }

  "subtract" should ("subtract two numbers, smaller number first  (b - a") in {
    assert(calculator.subtract(2, 5) == -3)
  }

  "divide" should ("divide two numbers, always greater number first (a - b") in {
    assert(calculator.divide(6, 2) == 3)
  }

}
