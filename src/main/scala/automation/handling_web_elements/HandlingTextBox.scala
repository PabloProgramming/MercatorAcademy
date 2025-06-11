package automation.handling_web_elements

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTextBox extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  val textInput: WebElement = driver.findElement(By.id("my-text-id"))
  textInput.sendKeys("Handling textBox")
  println("Value entered")
  val typeValue: String = textInput.getAttribute("type")
  println("Type is: " + typeValue)
  textInput.clear()
  println("textBox cleared")

  driver.quit()

}
