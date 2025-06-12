package automation.handling_web_elements

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object JavaScriptExecutor extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  // WAITS - BETTER NOT TO USE IMPLICIT AND EXPLICIT IN THE SAME PAGE
  // GLOBAL WAIT - It will only wait if the elements are not found
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))

  // Find elements
  val emailAddress: WebElement = driver.findElement(By.id("email"))
  emailAddress.sendKeys("test@gmail.com")
  println("Email address entered - ✅")
  val password: WebElement = driver.findElement(By.id("password"))
  password.sendKeys("TestPassword")
  println("Password entered - ✅")

  // Not working: element is not found. We need to go down and scroll and click with JsExecutor
  val submitButton: WebElement = driver.findElement(By.id("login"))

  val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
  jsExecutor.executeScript("arguments[0].scrollIntoView(true)", submitButton)
  jsExecutor.executeScript("arguments[0].click()", submitButton)

  println("Login successful - ✅")

  // ASSERT - Ensure you move to the right page
  val header: WebElement =  driver.findElement(By.tagName("h2"))
  assert(header.getText == "Thank You!")
  println("Success page loaded - ✅")

  // WAIT FOR AN ELEMENT - It will only wait until condition is met
  driver.navigate().to("https://www.w3schools.com/howto/howto_css_custom_checkbox.asp")
  // val acceptAllButton: WebElement = driver.findElement(By.id("accept-choices"))
  // acceptAllButton.click()

  val explicitWait =  new WebDriverWait(driver, Duration.ofSeconds(10))
  val checkbox: WebElement = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[2]/label[1]"))
  explicitWait.until(ExpectedConditions.elementToBeClickable(checkbox))
  jsExecutor.executeScript("arguments[0].click();", checkbox) // checkbox must be clicked in javaScript
  println("Checkbox is clicked - ✅")

}
