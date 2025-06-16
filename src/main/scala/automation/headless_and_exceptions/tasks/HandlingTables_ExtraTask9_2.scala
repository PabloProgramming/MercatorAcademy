package automation.headless_and_exceptions.tasks

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, TimeoutException, WebDriver, WebElement}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingTables_ExtraTask9_2 extends App {

  // EXTENSION

  val driver: WebDriver = new ChromeDriver()

  try {
    driver.get("https://the-internet.herokuapp.com/tables")

    // Locate Table 1
    val table1: WebElement = driver.findElement(By.id("table1"))
    val headerRow: WebElement = table1.findElement(By.tagName("tr"))
    val headers: Iterable[WebElement] = headerRow.findElements(By.tagName("th")).asScala

    // Trigger sorting of header cell
    val lastNameHeader: WebElement = headers.head
    lastNameHeader.click()

    // Add wait for cells to update

    val wait = new WebDriverWait(driver, Duration.ofSeconds(5))
    wait.until { _ =>
      val firstRow = table1.findElement(By.cssSelector("tbody tr:first-child"))
      val firstCellText = firstRow.findElement(By.cssSelector("td:first-child")).getText
      firstCellText.nonEmpty
    }

/*    lastNameHeader.click()

    wait.until { _ =>
      val firstRow = table1.findElement(By.cssSelector("tbody tr:first-child"))
      val firstCellText = firstRow.findElement(By.cssSelector("td:first-child")).getText
      firstCellText.nonEmpty
    }*/

    // Print lastNames
    val tableBody: WebElement = table1.findElement(By.tagName("tbody"))
    val bodyRows: Iterable[WebElement] = tableBody.findElements(By.tagName("tr")).asScala

    val lastNames: Iterable[String] = bodyRows.map { row =>
      val cells = row.findElements(By.tagName("td")).asScala
      cells.head.getText
    }
    val lastNamesSeq: Seq[String] = lastNames.toSeq
    for (lastName <- lastNamesSeq) println(lastName)

    //Verify if the order is asc or desc
    var ascending: Boolean = true
    for (i <- 0 until lastNamesSeq.size - 1) {
      val current = lastNamesSeq(i)
      val next = lastNamesSeq(i + 1)
      if (current > next) ascending = false
    }

    if (ascending) println("Names are in ascending order - ⏩️")
    else println("Names are in descending order - ⏪️")

  } catch {
    case e: NoSuchElementException =>
      println(s"Element not found: ${e.getMessage}")
    case e: TimeoutException =>
      println(s"Timeout waiting for element: ${e.getMessage}")
    case e: Exception =>
      println(s"An error occurred: ${e.getMessage}")
  } finally {
    driver.quit()
    println("Driver quit successfully.")
  }
}
