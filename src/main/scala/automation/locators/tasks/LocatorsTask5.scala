package automation.locators.tasks

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object LocatorsTask5 extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")

  val username: WebElement = driver.findElement(By.name("username": String))
  username.sendKeys("pablodev9": String)
  println(s"Enter username: $username - PASS")

  val password: WebElement = driver.findElement(By.xpath("//input[@type='password']": String))
  password.sendKeys("pass-not-word": String)
  println(s"Enter password: $password - PASS")

  val textArea: WebElement = driver.findElement(By.cssSelector("textarea[name='comments']"))
  textArea.clear()
  textArea.sendKeys("Css selector or xpath, what's your favourite?")
  println(s"Enter text: $textArea - PASS")

  val checkbox: WebElement = driver.findElement(By.xpath("//input[@type='checkbox'][@value='cb1']"))
  checkbox.click()
  println(s"Click checkbox - PASS")

  val submitButton: WebElement = driver.findElement(By.cssSelector("input.styled-click-button[type='submit']"))
  submitButton.click()
  println(s"Click submit - PASS")

  driver.navigate().back()

  val hyperlink: WebElement = driver.findElement(By.partialLinkText("EvilTester"))
  hyperlink.click()
  println(s"Click EvilTester.com - PASS")

  driver.quit()

}
