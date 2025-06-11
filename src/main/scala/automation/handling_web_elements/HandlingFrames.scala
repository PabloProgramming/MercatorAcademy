package automation.handling_web_elements

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingFrames extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://the-internet.herokuapp.com/nested_frames")

  // Switch to top frame
  driver.switchTo().frame("frame-top")
  println("Switched to: frame top")

  // Switch to middle frame of top frame
  driver.switchTo().frame("frame-middle")
  println("Switched to: frame middle")

  // Find elements within the middle frame
  val contentMiddleFrame: WebElement = driver.findElement(By.id("content"))
  println(s"Text of middle frame: ${contentMiddleFrame.getText}")

  // Going back to page (no frames)
  driver.switchTo().defaultContent()
  println("Back to page HTML")

  // Switch to bottom frame by Index
  driver.switchTo().frame(1)
  println("Switched to: frame bottom")

  // Find elements within the bottom frame
  val contentBottomFrame: WebElement = driver.findElement(By.tagName("body"))
  println(s"Text of bottom frame: ${contentBottomFrame.getText}")

  // Going back to page (no frames)
  driver.switchTo().defaultContent()
  println("Back to page HTML")

  // Switch to top frame locating it as a WebElement
  val frameTop: WebElement = driver.findElement(By.name("frame-top"))
  driver.switchTo().frame(frameTop)
  println("Switched to: frame top")


}
