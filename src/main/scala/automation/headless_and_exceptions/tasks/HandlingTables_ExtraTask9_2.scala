package automation.headless_and_exceptions.tasks

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, OutputType, TimeoutException, WebDriver, WebElement}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala
import automation.headless_and_exceptions.tasks.Headless_Screenshot_Exceptions_Task9_1.{driver, takeScreenshot}
import org.openqa.selenium.io.FileHandler

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

object HandlingTables_ExtraTask9_2 extends App {

  // EXTENSION

  val driver: WebDriver = new ChromeDriver()

  val pathToFolder: String = "/Users/pablo.montalvo/Documents/Screenshots/ExtensionTaskTables"
  //  val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
  val screenshotsDir = new File(pathToFolder)
  if (!screenshotsDir.exists()) {
    screenshotsDir.mkdirs()
    println("New directory created - ✅")
  }

  //  Set up util to capture an element and not the full screen
  def captureElement(
                      element: WebElement,
                      basePath: String = pathToFolder,
                      prefix: String = ""
                    ): Unit = {
    val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
    val srcElement: File = element.getScreenshotAs(OutputType.FILE) // Capture only that element
    val destination = new File(s"$basePath/${prefix}_$timeStamp.png")
    FileHandler.copy(srcElement, destination)
    println(s"Screenshot saved to: ${destination.getAbsolutePath}")
  }

  try {
    driver.get("https://the-internet.herokuapp.com/tables")

    // Print FULL PAGE
    takeScreenshot(driver, pathToFolder, "FullPage")

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

    // Screenshot lastNames
    val tableBody: WebElement = table1.findElement(By.tagName("tbody"))
    val bodyRows: Iterable[WebElement] = tableBody.findElements(By.tagName("tr")).asScala

    def sanitizeFilename(name: String): String = name.replaceAll("[^a-zA-Z0-9\\-_]", "_")

    val lastNamesSeq: Seq[String] = bodyRows.map { row =>
      val cells = row.findElements(By.tagName("td")).asScala
      val lastNameCell = cells.head
      val lastNameText = lastNameCell.getText

      val safeName = sanitizeFilename(lastNameText)
      captureElement(lastNameCell, pathToFolder, s"LastNameCell_$safeName")

      lastNameText
    }.toSeq


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
