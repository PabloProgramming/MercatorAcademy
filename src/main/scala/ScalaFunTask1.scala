object ScalaFunTask1 extends App {
// MVP 1
  val result1: Boolean = 3 + (4 * 57) < 100 //false
  val result2: Boolean = 144 / 12 >= 12 //true
  val catIsLessThanDog: Boolean = "cat" < "dog" //true
  val rabbitIsLessThanHamster: Boolean = "Rabbit" < "Hamster" //false
  val isOdd: Boolean = 77 % 2 != 0 //true
  val result3: Boolean = (75 / 9 < 30) && (89 / 6 < 20) //true

  // MVP 3
  def calculateSquare(number: Int): Int = {
    number * number;
  }
  println(calculateSquare(9))

  // MVP 4
  def isOdd(number: Int): Boolean = {
    number % 2 != 0
  }

  println(isOdd(7))


  // MVP 5
  class Book(val title: String, val author: String, val isbn: String, val releaseDate: Int, val genre: String, val numOfPages: Int) {

    var isAvailable: Boolean = true;

    var rating: Double = 0.0;

    def modifyAvailability(): Boolean = {
      isAvailable  = !isAvailable
      isAvailable
    }

    def openBook(): String = s"You have opened $title"

    def readPage(pageNumberToRead: Int): String = {
      if (pageNumberToRead > 0 && pageNumberToRead < numOfPages) {
        s"Reading page $pageNumberToRead"
      } else {
        s"Page $pageNumberToRead not found"
      }
    }

    def readSummary(): String = {
      s"Summary of '$title': This book, written by $author, is a $genre book published in $releaseDate. It has $numOfPages pages."
    }

    def rateBook(newRating: Double): Double = {
      rating =  newRating
      rating
    }

    def checkBookAge(): Int = {
      val currentYear: Int = 2025
      val bookAge: Int = currentYear - releaseDate
      bookAge
    }

  }

  // EXTENSION 1
  val lowercaseString: String = "hola"
  val upperCaseString: String = lowercaseString.toUpperCase

  // EXTENSION 2
  val firstLetterCapitalized: String = lowercaseString.capitalize
  println(firstLetterCapitalized)

  // EXTENSION 3
  val isTheSame: Boolean = "STRING" == "string"
  println(isTheSame) // False because the strings are case-sensitive and have different character values. 'S' has an ASCII value of 83 and 's' of 115 (for example).

// EXTENSION 6
  val number: Int = 27
  val numberToString: String = number.toString
  println(numberToString) // "27"

}
