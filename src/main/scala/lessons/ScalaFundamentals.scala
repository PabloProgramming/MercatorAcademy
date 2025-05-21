package lessons

object ScalaFundamentals extends App {
  //  VAL = BEST PRACTICES
  private val melons = 5 * 50;
  private val apples = 2 * 10;
  private val fizzyDrinks = 6 * (100 * 1.20);
  private val result = melons + apples + fizzyDrinks;
  println(result);

  //  TYPES
  //  NUMBERS
  val wholeNumber: Int = 27;
  val littleNumber: Short = 2; //RARE
  val overTwoMillion: Long = 123412352346345L; // MUST PUT L

  val littleDecimal: Float = 2.4567f // MUST PUT f
  val decimalNumber: Double = 27.9;

  //  TEXT
  val text: String = "Love it"
  //  BOOL
  val isTrue: Boolean = true
  val isFalse: Boolean = false



  //  ARITHMETIC OPERATORS

  val a: Int = 10;
  val b: Int = 5
  val c: Int = 3;
  val add: Int = a + b;
  val subtract: Int = a - c;
  val divide: Double = a / c;
  val multiply: Int = a * b;
  val modulus: Int = a % c;
  println(modulus)
  val even: Int = a % 2 // left 0 a = even

  //  RELATIONAL OPERATORS (true / false)

  val equality: Boolean = a == a;
  val inequality: Boolean = a != b
  val lessThan: Boolean = b < c
  val lessThanEqualTo: Boolean = b <= c
  val greaterThan: Boolean = b <= c
  val greaterThanEqualTo: Boolean = b <= c

  //LOGICAL

  val and: Boolean = true && true //both must be tru to return true
  val or: Boolean = true || false // either side can be true to return true
  val not: Boolean = !false

  //METHODS

  def makeCupOfTea(sugar: Int, milk: Boolean): String = {
    s"You have made a cup of tea with $sugar spoons of sugar. Your milk selection is: $milk "
  }

  println((makeCupOfTea(7, milk = true)))


  val vat: Double = 1.2

  def addVatToItemPrice(itemPrice: Double): Double = {
    val finalPrice: Double = itemPrice * vat;
    finalPrice
  }

  println(addVatToItemPrice(100.0))

  // CLASSES

  private class Dog(val name: String, val age: Int, val likesApples: Boolean) {
    def speak: String = "woof" //declare methods that are the same for every dog
    val hasEars: Boolean = true //Default value
  }
  // WITH VAL YOU MAKE ACCESSIBLE THE ATTRIBUTES

  // OBJECT OF TYPE DOG
  private val tobi: Dog = new Dog("Tobi", 2, likesApples = true);

  //How do I access it?
  println(tobi.speak)


}
