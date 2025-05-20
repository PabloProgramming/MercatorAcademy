import javax.swing.InputMap

object ScalaFunCollections extends App {

  val firstSet: Set[Int] = Set(1, 2, 3, 4, 5) // Not ordered, does not allow repeat values
  println(s" First set $firstSet")

  val firstSequence: Seq[Int] = Seq(1, 2, 3, 4, 5) // Ordered, allow repeat values
  println(s" First seq $firstSequence")

  // Not ordered. Maps take two parameters [Key, Value]. We call this key value pairs. Key must be unique
  val firstMap: Map[String, Int] = Map(
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "five" -> 5 // Will remove when compiled, does not throw an error
  )
  println(s" First map $firstMap")

  //ACCESSING DATA

  //Sequences

  val getSeqHead: Int = firstSequence.head // Index position 0 (first element)
  println(s" Seq Head $getSeqHead")

  val getSeqTail: Seq[Int] = firstSequence.tail // Everything BUT the head
  println(s" Seq Tail $getSeqTail")

  val getSeqIndex: Int = firstSequence(3) // only works with ordered collections
  println(s" Seq Index 3 = $getSeqIndex")

  //Sets

  val getSetIndex = firstSequence(3) // check if the value is contained in the Set (can also use .contains(3)) -> return boolean
  // Often filter for information
  val filterSet: Set[Int] = firstSet.filter(_ < 3) //get all values less than 3
  println(s" Filter Set $filterSet")
  val filterNotSet: Set[Int] = firstSet.filterNot(_ < 3) //get all values that are not less than 0
  println(s" NotFilter Set $filterNotSet")
  val evenSet: Set[Int] = firstSet.filter(_ % 2 == 0)
  println(s" Even Set $evenSet")

  // Maps

  val getMapValue: Int = firstMap("one")
  println(s" Get Map Value $getMapValue")

  val getMapKey: String = firstMap.find(_._2 == 1).get._1 // find the value that is equal to 1 and get the key of that value.
  println(s" Get Map Key $getMapKey")


  // TASKS

  val namesSeq: Seq[String] = Seq("Tommy", "Maria", "John", "Andrew")

  val coloursMap: Map[Int, String] = Map(
    1 -> "red",
    2 -> "yellow",
    3 -> "blue",
    4 -> "green"
  )

  val filterMap: Map[Int, String] = coloursMap.filter(_._2 == "yellow") // With filter, you get BOTH (Key -> Value)
  println(filterMap)

  val setOfNumbers: Set[Int] = Set(1, 2, 5, 6, 7, 9)

  val filterSetOfNumbersHigherThanTwo: Set[Int] = setOfNumbers.filter(_ > 2)
  println(s" Numbers greater than 2 = $filterSetOfNumbersHigherThanTwo")


  // map (method - lowercase). Use map to iterate through a collection

  // Set + map
  val salariesSet: Set[Double] = Set(2000.80, 2200.75, 1900.23, 2135.67 )
  def addHundredPoundBonus(inputSet: Set[Double]): Set[Double] = inputSet.map {
    _ + 100
    // num => num = 100 (get to a number and I add 100 to that number)
  }
  println(s"Bonuses" + addHundredPoundBonus(salariesSet))

  // Map + map

  def tripleMap(inputMap: Map[String, Int]): Map[String, Int] = inputMap.map {
    case (key, value) => (key, value * 3)
  }
  println(tripleMap(firstMap))

// Other useful methods

  // .exists = get collection of values)
  // .contains = boolean


  // TASKS2 (map)

  def addOne(inputset: Set[Int]): Set[Int] = inputset.map {
    _ + 1
  }

  println(addOne(firstSet))

  def checkIfContainsLetterR(inputSeq: Seq[String]): Seq[Boolean] = namesSeq.map {
  _.contains('r')
}

  def checkIfContainsLetterRQuick(inputSeq: Seq[String]): Boolean = namesSeq.exists(word => word.contains('r'))

  val oddNumbersOnly = firstSet.filter(
    _ % 2 != 0
  )

  val flatMapNames: Seq[Char] = namesSeq.flatMap(_.toUpperCase)
  println(s"FlatMap $flatMapNames")

  // Append - add to the end

  val newNames: Seq[String] = Seq("Pablo", "Alba")

  val appendedListWithWholeList = namesSeq :+ newNames
  println(s"List with list added $appendedListWithWholeList")

  val appendedListWithNewValues = namesSeq ++ newNames
  println(s"New List with new values added $appendedListWithNewValues")


  // Prepend - add to the start

  val prependedListWithWholeList = newNames +: namesSeq
  println(s"List with list added at the start $prependedListWithWholeList")

  val prependedListWithNewValues = newNames ++ namesSeq
  println(s"New List with new values added $prependedListWithNewValues")

}
