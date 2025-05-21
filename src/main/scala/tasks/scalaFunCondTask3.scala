package tasks

object scalaFunCondTask3 extends App {

  // MVP 1
  // a)
  val watermelons: Int = 7

  // b)
  watermelons match {
    case w if w < 0 => println("Invalid number of watermelons")
    case w if w > 5 => println(s"Can't carry $w watermelons, there are too many!")
    case w if w > 3 => println(s"Needs a bag to carry $w melons")
    case w if w >= 0 => println(s"Does not need a bag to carry $w watermelons")
  }

  // d)
   val needsABag: Boolean = watermelons > 3 && watermelons <= 5

  if (watermelons > 5) println(s"Can't carry $watermelons watermelons, there are too many!")
  else if (needsABag) println(s"Needs a bag to carry $watermelons watermelons.")
  else println(s"Does not need a bag to carry $watermelons watermelons.")

  // MVP 2

  def calculateMoneyEarnedByMilesTravelled(inputMiles: String): Unit = {
    try {
      val miles = inputMiles.toInt
      val moneyEarned: Double = miles * 0.45
      println(s"Distance travelled: $miles miles")
      println(f"Amount to be paid: £$moneyEarned%.2f")
    } catch {
      case e: NumberFormatException =>
        println("Invalid input")
    }
  }

  calculateMoneyEarnedByMilesTravelled("20")


  // EXTENSION
    // Order of Precedence:
      //Parentheses () always take the highest precedence.
      //First: Comparison operators (==, !=, <, <=, >, >=)
      //Second: Logical && (AND) operator
      //Third: Logical || (OR) operator

  // Examples
  val example1: Boolean = (true || false && false) // true
  val example2: Boolean = ((true || false) && false) // false
  val example3: Boolean = (1 < 4 && 7 != 10 || 9 + 10 == 21) // true
                            // (true && true || false) = true

  // RESEARCH
  val firstValue: Int = 5
  val secondValue: Int = 15

  val result = if (firstValue > secondValue) "yes" else "no"
  println(result)

}
