package automation.headless_and_exceptions

import org.openqa.selenium.{By, NoSuchElementException, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingExceptions extends App {

  val driver: WebDriver = new ChromeDriver()
  // TRY CATCH HANDLING
  try {

    driver.get("https://www.selenium.dev/selenium/web/web-form.html")
    val notFoundElement: WebElement = driver.findElement(By.id("invalid-locator"))
    notFoundElement.click()

  } catch {
    case elementNotFound: NoSuchElementException =>
      // This just prints the exception in WHITE
      println(s"Element not found: ${elementNotFound.getMessage}")
      // This just prints the exception in RED, it does not throw it and so it can continue running
      elementNotFound.printStackTrace()
    // In case there is none NoSuchElementException then triggers this case
    case e: Exception =>
      println(s"Any exception: ${e.getMessage}")
  } finally {
    if (driver != null) {

      driver.quit()
    }
  }

  // THROW EXCEPTION (DON'T USE IN PRODUCTION)
  // throw NoSuchElementException


}
