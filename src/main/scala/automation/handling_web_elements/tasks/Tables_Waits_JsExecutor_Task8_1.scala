package automation.handling_web_elements.tasks

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, WebDriverWait}

import java.time.Duration
import scala.jdk.CollectionConverters._

object Tables_Waits_JsExecutor_Task8_1 extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://cosmocode.io/automation-practice-webtable/")

  // Set Global Implicit Wait
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

  val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
  val countriesTable: WebElement = driver.findElement(By.id("countries"))

  // Get all rows inside tbody
  val rows: Iterable[WebElement] = countriesTable.findElements(By.cssSelector("tbody > tr")).asScala
  println("List of countries:")
  // Loop through all the rows except the first one
  for (row <- rows.drop(1)) {
    // Highlight row with yellow background as it's read
    jsExecutor.executeScript("arguments[0].style.backgroundColor = 'yellow'", row)
    val cells = row.findElements(By.tagName("td"))
    val countryName: String = cells.get(1).getText
    // val countryNameTag: WebElement = cells(1).findElement(By.tagName("strong"))
    println(s" - $countryName")
  }

  // Explicit Wait to be visible
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  for (row <- rows.drop(1)) {
    val cells = row.findElements(By.tagName("td"))
    val countryName: String = cells.get(1).getText
    if (countryName == "Spain") {
      val spain: WebElement = row
      explicitWait.until(ExpectedConditions.visibilityOf(spain))
      val spainCapital: String = cells.get(2).getText
      val spainCurrency: String = cells.get(3).getText
      println(s"Spanish capital: $spainCapital")
      println(s"Spanish currency: $spainCurrency")
    }
  }

  // EXTENSION

  // 1. Scroll to the Bottom
  jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)")

  // 2. Change bck colour of Country columns header (Cell)
  val firstRow = countriesTable.findElement(By.cssSelector("tbody > tr"))
  val cells = firstRow.findElements(By.tagName("td"))
  val countryHeaderCell: WebElement = cells.get(1)
  jsExecutor.executeScript("arguments[0].style.backgroundColor = 'green'", countryHeaderCell)

  // 3. Print title
  val pageTitle = jsExecutor.executeScript("return document.title")
  println(pageTitle)

  // 4. Wait until a specific row is visible
  val fluentWait = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(15)) // max wait time
    .pollingEvery(Duration.ofMillis(500)) // polling interval
    .ignoring(classOf[org.openqa.selenium.NoSuchElementException]) // ignore if not found immediately

  fluentWait.until((d: WebDriver) => {
    val rows = d.findElement(By.id("countries")).findElements(By.cssSelector("tbody > tr")).asScala
    rows.foreach { row =>
      val cells = row.findElements(By.tagName("td"))
      if (cells.get(1).getText == "India" && row.isDisplayed) {
        println("India row found!")
      }
    }
  })

  // 5. Assertion of row found
  var found = false
  rows.foreach { row =>
    val cells = row.findElements(By.tagName("td")).asScala
    val language: WebElement = cells(4)
    if (language.getText == "Polish") {
      found = true
      jsExecutor.executeScript("arguments[0].style.backgroundColor = 'blue'", row)
    }
  }
  assert(found, "No row with Polish language has been found")
  println(s"Polish found? $found")

}
