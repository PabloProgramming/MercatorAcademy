package automation.handling_web_elements

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import scala.jdk.CollectionConverters.CollectionHasAsScala

object HandlingWindows extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://the-internet.herokuapp.com/windows")

  driver.manage().window().maximize()

  val parentWindow: String = driver.getWindowHandle // ID of the window
  println(s"ID of parent window: $parentWindow")

  val linkToChildWindow: WebElement = driver.findElement(By.linkText("Click Here"))
  linkToChildWindow.click()

  val allWindows: List[String] =  driver.getWindowHandles.asScala.toList
  val allWindowsIterable: Iterator[String] = allWindows.iterator

  while (allWindowsIterable.hasNext) {
    val handle = allWindowsIterable.next()
    println(s"Handle: $handle")

    if(handle != parentWindow) {
      driver.switchTo().window(handle)
      println("Page Title: " + driver.getTitle)
    }
  }

  // EASIER WAY TO SWITCH
  // val windows: List[String] = driver.getWindowHandles.asScala.toList
  // driver.switchTo().window(windows(1))

}
