package automation.headless_and_exceptions

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object SeleniumExceptions extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // NoSuchElementException
  // val noElement: WebElement = driver.findElement(By.id("invalid-locator"))


  // TimeOutException
  //  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3))
  //  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")))
  // More exception to write

}
