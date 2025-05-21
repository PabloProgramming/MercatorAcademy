package tasks

object ScalaFunConditionals extends App {

  // IF/ELSE
  val weather: String = "cloudy"

  if (weather == "cloudy") {
    println("Take a coat")
  } else if (weather == "sunny") {
    println("Wear suncream")
  } else if (weather == "cold") {
    println("Wear a warm coat")
  } else {
    println("Check local recommendations")
  }

  // As testers Test 4 PATHS (options).

  val season: String = "spring"

  if (weather == "cold" || season == "winter") {
    println("Take a coat")
  } else {
    println("A light jacket is fine!")
  }

  // PATTERN MATCHING (Switch) -

  weather match {
    case "cloudy" => println("Take a coat")
    case "sunny" => println("Wear suncream")
    case "cold" => println("Wear a warm coat")
    case _ => println("Check local recommendations")
  }

  // Don't use if you have && or ||
  (weather, season) match {
    case (weather, season) if weather == "cold" || season == "winter"
      => println("Take a coat")
    case _ => println("A light jacket is fine!")
  }

  // INT - slightly more careful
  val age: Int = 0

  if (age < 0) println("Invalid age")
  else if (age >= 18) println(s"You are an adult because you are $age")
  else println(s"You are a child because you are $age")

  age match {
    case age if age < 0 => println("Invalid age")
    case age if age >= 18 => println(s"You are an adult because you are $age")
    case _ => println(s"You are a child because you are $age")
  }

  // TASK

  val givenAge: Int = 8

  givenAge match {
    case age if age < 0 => println("Invalid age")
    case age if age >= 18 => println("18")
    case age if age >= 15 => println("15")
    case age if age >= 12 => println("12A")
    case age if age >= 8 => println("PG")
    case age if age >= 4 => println("U")
  }


  // OPTIONS (getOrElse)

  val email: Option[String] = Some("pablo.montalvo@gmail.com")
  val emptyEmail: Option[String] = None
  println(email)
  println(emptyEmail)

  //getOrElse is used to return a default value if None id returned
  //It will also take the SOME away, leaving only the option.
  def getEmail(inputEmail: Option[String]): String = inputEmail.getOrElse("Email not input")
  println(getEmail(email))
  println(getEmail(emptyEmail))


  // ERROR CATCHING - TRY/CATCH

  try {
    val num = "one".toInt // I want to change the input to an Int from a String
    println(s"The number is $num")
  } catch {
    case e: NumberFormatException => println(s"$e was invalid input")
  }



}


