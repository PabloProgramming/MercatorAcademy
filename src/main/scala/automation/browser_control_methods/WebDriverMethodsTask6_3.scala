package automation.browser_control_methods

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object WebDriverMethodsTask6_3 extends App {

  val driver: WebDriver = new ChromeDriver()

  // Task 3

  driver.get("https://demoqa.com/automation-practice-form")
  println(s"Current URL: ${driver.getCurrentUrl}")

  driver.manage().window().maximize()

  // Locate elements
  val firstNameInput: WebElement = driver.findElement(By.id("firstName"))
  val submitButton: WebElement = driver.findElement(By.id("submit"))
  val hobbiesCheckBox: WebElement = driver.findElement(By.cssSelector("#hobbies-checkbox-1"))

  // Conditionals
  if (firstNameInput.isDisplayed && firstNameInput.isEnabled) {
    firstNameInput.sendKeys("Pablo")
    println("FirstName input displayed and enabled ✅")
  } else {
    println("FirstName input is not ready to type ❌")
  }

  if (!hobbiesCheckBox.isSelected && hobbiesCheckBox.isEnabled && hobbiesCheckBox.isDisplayed) {
    hobbiesCheckBox.click()
    println("Sports checked ✅")
  } else {
    println("Checkbox is not ready (Ad obstructing interaction) ❌")
  }

  if (submitButton.isDisplayed && submitButton.isEnabled) {
    submitButton.click()
    println("Submitted! ✅")
  } else {
    println("Not ready to submit ❌")
  }

  driver.quit()

  // EXTENSION & RESEARCH

  // 1. Difference between .close() and .quit() is when you have multiple windows, .close() just close that window but the browser keeps open.

  // 2.To handle windows, Use .getWindowHandles to return a set of windows which can be used to iterate over and switch among them.
        // val windows = driver.getWindowHandles
        // driver.switchTo().window(windows[1])

  // 3. driver.get() vs driver.navigate().to(): Identical performance and functionality
        // Use driver.get(): For simple navigation (more common)
        // Use driver.navigate().to(): When using other navigation methods or being explicit

  // 4. findElement vs findElements
    // - Use Cases:
        // findElement(): When you expect exactly one element
        // findElements(): For multiple elements, existence checking, or optional elements
    // - Return Types:
        // findElement() → WebElement (single element)
        // findElements() → java.util.List[WebElement] (collection)
    // - When locator doesn't match:
        // findElement() → Throws NoSuchElementException
        // findElements() → Returns empty List (no exception)
    // - Key Differences:
        // findElement(): Stops at first match, faster, requires exception handling
        // findElements(): Searches entire DOM, slower, safe (no exceptions)

  // 5. Selenium Manager
  // What it is: Built-in tool in Selenium 4.6+ that automatically manages browser drivers
  // What it does:
    // Auto-downloads correct driver versions (Chrome, Firefox, Edge)
    // Matches driver versions to installed browsers
    // Eliminates manual driver setup
  // Benefits:
    // Zero configuration - no more System.setProperty() or manual downloads
    // Automatic compatibility - always gets the right driver version
    // Works out of the box - included by default




}
