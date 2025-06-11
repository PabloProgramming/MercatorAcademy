package automation.handling_web_elements

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{Alert, By, WebDriver, WebElement}

object HandlingWebElementsTask7_2 extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php")

  // EXTENSION
  // 1. Simple Alert
  val simpleAlertButton: WebElement = driver.findElement(By.xpath("//button[@onclick='showAlert()']"))
  if (simpleAlertButton.isDisplayed && simpleAlertButton.isEnabled) {
    println(s"Button ${simpleAlertButton.getText} clicked - ✅")
    simpleAlertButton.click()
  }

  val simpleAlert: Alert = driver.switchTo().alert()
  println(s"Alert text: ${simpleAlert.getText}")

  simpleAlert.accept()
  println(s"Simple alert accepted and closed - ✅")

  // 2. Confirmation Alert
  val confirmationAlertButton: WebElement = driver.findElement(By.cssSelector("button[onclick='myDesk()']"))
  if (confirmationAlertButton.isDisplayed && confirmationAlertButton.isEnabled) {
    println(s"Button ${simpleAlertButton.getText} clicked - ✅")
    confirmationAlertButton.click()
  }

  val confirmationAlert: Alert = driver.switchTo().alert()
  println(s"Alert text: ${confirmationAlert.getText}")

  confirmationAlert.dismiss()
  println(s"Confirmation alert dismissed and closed - ✅")

  // 3. Prompt Alert
  val promptAlertButton: WebElement = driver.findElement(By.cssSelector("button[onclick='myPromp()']"))
  if (promptAlertButton.isDisplayed && promptAlertButton.isEnabled) {
    println(s"Button ${simpleAlertButton.getText} clicked - ✅")
    promptAlertButton.click()
  }
  val promptAlert: Alert = driver.switchTo().alert()
  println(s"Alert text: ${promptAlert.getText}")

  promptAlert.sendKeys("Pablo")
  promptAlert.accept()
  println(s"Prompt alert completed, accepted and closed - ✅")

}
