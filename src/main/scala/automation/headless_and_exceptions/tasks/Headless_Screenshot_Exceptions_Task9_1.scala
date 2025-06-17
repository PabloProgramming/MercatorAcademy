package automation.headless_and_exceptions.tasks

import org.openqa.selenium.{By, OutputType, TakesScreenshot, TimeoutException, NoSuchElementException, WebDriver, WebElement}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.io.FileHandler
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.io.File
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Date

object Headless_Screenshot_Exceptions_Task9_1 extends App {

  // MVP: Headless Login with Screenshot and Exception handling
  val options = new ChromeOptions
  options.addArguments("--headless")

  val driver = new ChromeDriver(options)

  // Take a screenshot function
  def takeScreenshot(driver: WebDriver, folderPath: String, fileName: String): File = {
    val timeStamp = new SimpleDateFormat("YYYY-MM-DD_HH-MM-SS").format(new Date())
    val srcFile: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    val screenshot = new File(s"$folderPath/${fileName}_$timeStamp.png")
    FileHandler.copy(srcFile, screenshot)
    screenshot
  }

  // TRY CATCH FINALLY BLOCK

  try {
    driver.get("https://the-internet.herokuapp.com/login")

    // Locate web elements and enter input
    val usernameInput: WebElement = driver.findElement(By.id("username"))
    usernameInput.sendKeys("tomsmith")
    val passwordInput: WebElement = driver.findElement(By.id("password"))
    passwordInput.sendKeys("SuperSecretPassword!")

    // Locate and click login button to submit the form
    val login: WebElement = driver.findElement(By.cssSelector("button[type='submit']"))
    login.click()
    println("Form submitted! - ✅")

    // Wait for success or failure msg
    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5))
    val resultMsg: WebElement = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))
    println(s"Result msg with text: ${resultMsg.getText} - ☢️")

    // Using function, taking screenshot of result page (success or failure)
    val successOrFailure = if (resultMsg.getText.contains("logged")) "success" else "failure"
    val resultPageScreenshot: File = takeScreenshot(driver, "/Users/pablo.montalvo/Documents/Screenshots/", s"resultPage-$successOrFailure")
    println(s"Saved screenshot to: ${resultPageScreenshot.getPath} - ✅")


    // Catch exceptions
  } catch {
    case e: NoSuchElementException =>
      println(s"Error: Element not found - ${e.getMessage}")
    case e: TimeoutException =>
      println(s"Error: Timeout waiting for element - ${e.getMessage}")
    case e: Exception =>
      println(s"An unexpected error occurred: ${e.getMessage}")
  } finally {
    driver.quit()
    println("Driver quit, browser closed - ✅")
  }


}
