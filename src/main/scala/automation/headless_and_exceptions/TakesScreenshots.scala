package automation.headless_and_exceptions

import org.openqa.selenium.{By, OutputType, TakesScreenshot, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.io.FileHandler

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

object TakesScreenshots extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // Create a file capturing FULL SCREEN
  val srcFull: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcFull, new File("/Users/pablo.montalvo/Documents/Screenshots/TestResults.png"))

  // Add time stamp
  val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
  val srcTimestamp: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
  FileHandler.copy(srcTimestamp, new File(s"/Users/pablo.montalvo/Documents/Screenshots/TestResult_$timeStamp.png"))


  // Select a specific area of the screen based on the element
  val disabledInput: WebElement = driver.findElement(By.name("my-disabled")) // Locate the element by its name (update if needed)
  val srcElement: File = disabledInput.getScreenshotAs(OutputType.FILE) // Capture only that element// Save the screenshot of the element
  FileHandler.copy(srcElement, new File("/Users/pablo.montalvo/Documents/Screenshots/TestResult_Specific.png"))

}
