package automation.handling_web_elements

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingDropDowns extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select")
  // First switch to a frame to be able to locate the WebElement
  driver.switchTo().frame("iframeResult")

  // Then you can locate it
  val dropDown: WebElement = driver.findElement(By.cssSelector("#cars"))
  val select: Select = new Select(dropDown)
  select.selectByVisibleText("Audi")
  println(s"Option selected: ${select.getFirstSelectedOption.getText}")
  select.selectByValue("volvo")
  println(s"Option selected: ${select.getFirstSelectedOption.getText}")
  select.selectByIndex(1)
  println(s"Option selected: ${select.getFirstSelectedOption.getText}")



}
