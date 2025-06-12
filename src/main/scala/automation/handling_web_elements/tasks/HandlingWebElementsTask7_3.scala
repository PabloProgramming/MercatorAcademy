package automation.handling_web_elements.tasks

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingWebElementsTask7_3 extends App {

  val driver: WebDriver = new ChromeDriver()

  // EXTENSION
  // 1. Switch to frame and interact with content
  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe")

  val iframe: WebElement = driver.findElement(By.id("iframeResult"))
  driver.switchTo().frame(iframe)
  println("Switched to iframe - ✅")


  val header: WebElement = driver.findElement(By.tagName("h2"))
  val headerText: String = header.getText
  println(s"This is the <h2> of the frame: $headerText")

  // EXTENSION
  // 2. Switch to a nested frame and interact with content
  driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php")

  driver.switchTo().frame("frame1")
  println("Switched to Frame 1 - ✅")

  // frame 2 missing closing tag in website

}
