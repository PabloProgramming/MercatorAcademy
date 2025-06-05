package automation.locators

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object LocatorById extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

  val emailAddress: WebElement = driver.findElement(By.id("email": String))
  // for typing in an input use sendKeys
  emailAddress.sendKeys("test-email@gmail.com")
  println(s"email address entered: $emailAddress - Pass")

  val password: WebElement = driver.findElement(By.id("password": String))
  // for typing in an input use sendKeys
  password.sendKeys("test-password123")
  println(s"password entered: $password - Pass")

  val login: WebElement = driver.findElement(By.id("login": String))
  // for buttons use click
  login.click()
  println(s"button clicked: $login - Pass")

  driver.quit()




}
