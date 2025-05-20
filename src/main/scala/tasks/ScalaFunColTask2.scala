package tasks

import java.security.Principal
import scala.:+

object ScalaFunColTask2 extends App {

  // MVP 1
  val taxpayers: Seq[String] = Seq(
    "Smith",
    "Johnson",
    "Williams",
    "Smith",
    "Brown",
    "Taylor",
    "Brown",
    "Anderson",
    "Thomas",
    "Johnson",
    "Jackson",
    "White",
    "Harris",
    "Smith",
    "Martin",
    "Lee",
    "Clark",
    "Williams",
    "Miller",
    "Thomas")

  // MVP 2
  println(s" List of submissions: $taxpayers")

  // MVP 3
  def countSubmissions(inputSeq: Seq[String], taxpayer: String): Int = {
    inputSeq.count(_ == taxpayer)
  }

  // MVP 4
  val taxpayer = "Smith"
  val submissionCount = countSubmissions(taxpayers, taxpayer)

  println(s"$taxpayer submitted their tax returns $submissionCount times.")

  // MVP 5
  val uniqueSurnames: Set[String] = taxpayers.toSet

  // MVP 6
  println(s" This is the list of unique taxpayer who submitted: $uniqueSurnames.")

  // MVP 7
  def countSubmissions(inputIterable: Iterable[String], taxpayer: String): Int = {
    inputIterable.count(_ == taxpayer)
  }

  // MVP 8
  val countInSeq = countSubmissions(taxpayers, taxpayer)
  val countInSet = countSubmissions(uniqueSurnames, taxpayer)

  println(s"$taxpayer submitted their tax returns $countInSeq times in the Seq (with duplicates).")
  println(s"$taxpayer submitted their tax returns $countInSet times in the Set (duplicates removed).")

  // MVP 9

  // a)
  val failedAttempts: Map[String, Int] = Map(
    "user1" -> 5,
    "user2" -> 3,
    "user3" -> 2,
    "user4" -> 4,
    "user5" -> 1,
    "user6" -> 0
  )
  // b)
  val seqFailAttempts: Seq[(String, Int)] = failedAttempts.toSeq
  println(seqFailAttempts.head._2)

  // c)
  val updatedFailedAttempts = seqFailAttempts ++ Seq("user7" -> 3)
  println("Updated list of users" + updatedFailedAttempts)

  // d)
  val updatedHead = (updatedFailedAttempts.head._1, updatedFailedAttempts.head._2 + 1)
  val updatedSeqFailAttempts = updatedHead +: updatedFailedAttempts.tail
  println(s"Updated sequence: $updatedSeqFailAttempts")

  // e) - Remove the user at index 5 using filterNot
  val removedUserSeq = updatedFailedAttempts.indices.filterNot(_ == 5).map(updatedFailedAttempts)
  println(s"Updated sequence after removing user at index 5: $removedUserSeq")


  // EXTENSION

  val day1Submissions: Set[String] = Set("Smith", "Johnson", "Williams", "Brown")
  val day2Submissions: Set[String] = Set("Williams", "Davis", "Miller")

  // a) Who submitted on both days (Intersection)
  val commonSubmissions = day1Submissions.intersect(day2Submissions)
  println(s"Who submitted on both days: $commonSubmissions")

  // b) Who submitted only on the first day (Difference)
  val onlyDay1Submissions = day1Submissions.diff(day2Submissions)
  println(s"Who submitted only on the first day: $onlyDay1Submissions")

  // c) A combined list of all unique submitters (Union)
  val allUniqueSubmitters = day1Submissions.union(day2Submissions)
  println(s"A combined list of all unique submitters: $allUniqueSubmitters")

  // RESEARCH

  // SEQ VS SET (TESTING)
    // Seq: Ordered, potentially duplicated data.
    // Set: Not Ordered, unique data (no duplicates).

    // When testing: if you expect a list to retain order (e.g., for pagination), Seq would be appropriate.
    // You can test if the correct sequence of data is returned.
    // In tests for uniqueness, where duplicates are not allowed (e.g., user IDs),
    // Set is more appropriate. You can validate that no duplicate elements are returned.

  // BUILD IN METHODS:
    // Map.get(key) -> Returns an Option (either Some(value) if the key exists in the map, or None if the key does not exist).
    // Useful when you want to safely handle the presence or absence of a key without throwing an exception.

  val attempt1 = failedAttempts.get("user1")  // Returns Some(5)
  val attempt2 = failedAttempts.get("user9")  // Returns None

  println(attempt1)  // Some(5)
  println(attempt2)  // None

    // Map(key) -> Returns the value of the given key. If the key does not exist, it will throw a NoSuchElementException.
    // Useful when you're confident the key exists in the map. If there's a chance the key might be missing, this can lead to runtime errors.

  val attempt3 = failedAttempts("user1")  // Returns 5
 // val attempt4 = failedAttempts("user7")  // Throws NoSuchElementException

  println(attempt3)  // 5

    // Map.getOrElse(key, defaultValue) -> Returns the value for the given key if it exists, otherwise returns a default value you specify.
    // Useful when you want to provide a fallback value in case the key doesn't exist, avoiding exceptions.

  val attempt5 = failedAttempts.getOrElse("user1", 0)  // Returns 5
  val attempt6 = failedAttempts.getOrElse("user7", 0)  // Returns 0 (default value)

  println(attempt5)  // 5
  println(attempt6)  // 0

// DANGEROUS TESTING - Map(key)

  // It is dangerous to use Map(key) directly in testing when you are not sure whether the key exists in the Map.
  // If the key doesn't exist, Map(key) will throw a NoSuchElementException, which can cause your program to crash or fail the test unexpectedly.
  // In this case, Map.get or Map.getOrElse are much safer because they provide a way to handle the absence of the key gracefully.
}
