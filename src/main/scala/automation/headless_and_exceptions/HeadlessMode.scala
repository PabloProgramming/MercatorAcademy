package automation.headless_and_exceptions

import automation.handling_web_elements.HandlingAlerts.driver
import org.openqa.selenium.{Alert, By, WebDriver, WebElement}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

object HeadlessMode extends App {

  // HEADLESS MODE
  val options: ChromeOptions = new ChromeOptions
  options.addArguments("--headless")

  // Pass the options (it runs, but it does not open a browser window)
  val driver: WebDriver = new ChromeDriver(options)

  driver.get("https://the-internet.herokuapp.com/javascript_alerts")

  // Simple alerts (Only click OK)
  val simpleAlertButton: WebElement = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"))
  if (simpleAlertButton.isDisplayed && simpleAlertButton.isEnabled) {
    println(s"Button ${simpleAlertButton.getText} clicked")
    simpleAlertButton.click()
  }
  Thread.sleep(1000)
  val simpleAlert: Alert = driver.switchTo().alert()
  println(s"Alert text: ${simpleAlert.getText}")

  simpleAlert.accept()
  println(s"Simple alert accepted")


  // Confirmation Alert (OK or Cancel)
  val confirmationAlertButton: WebElement = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"))
  if (confirmationAlertButton.isDisplayed && confirmationAlertButton.isEnabled) {
    println(s"Button ${confirmationAlertButton.getText} clicked")
    confirmationAlertButton.click()
  }
  Thread.sleep(1000)
  val confirmationAlert: Alert = driver.switchTo().alert()
  println(s"Alert text: ${confirmationAlert.getText}")

  simpleAlert.dismiss()
  println(s"Confirmation alert dismissed")

  // Prompt Alert (Type and then OK or Cancel)
  val promptAlertButton: WebElement = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"))
  if (promptAlertButton.isDisplayed && promptAlertButton.isEnabled) {
    println(s"Button ${promptAlertButton.getText} clicked")
    promptAlertButton.click()
  }
  Thread.sleep(1000)
  val promptAlert: Alert = driver.switchTo().alert()
  println(s"Alert text: ${promptAlert.getText}")

  promptAlert.sendKeys("ok, thanks for the info")
  promptAlert.accept()
  println(s"Prompt alert completed")

}
