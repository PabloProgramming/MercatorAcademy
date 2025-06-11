package automation.handling_web_elements

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object HandlingButtonsAndLinks extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  driver.manage().window().maximize()

  val submitButton: WebElement = driver.findElement(By.cssSelector("[type='submit']"))
  if (submitButton.isDisplayed && submitButton.isEnabled) {
    val buttonText: String = submitButton.getText
    submitButton.click()
    println(s"Button with text: $buttonText - Submitted!")
  } else {
    println("Not enabled yet")
  }
  driver.navigate().back()

  val hyperlink: WebElement = driver.findElement(By.cssSelector("[href='./index.html']"))
  val url: String = hyperlink.getAttribute("href")
  println(s"This is the url: $url")
  hyperlink.click()
  println("Link clicked")

  Thread.sleep(1000)
  val clickTest: WebElement = driver.findElement(By.cssSelector("a[href='ClickTest_testClicksASurroundingStrongTag.html']"))
  val clickTestUrl: String = clickTest.getAttribute("href")
  println(s"This is the url: $clickTestUrl")
  clickTest.click()
  println("Link clicked")

  val clickLink: WebElement = driver.findElement(By.cssSelector("a[href='xhtmlTest.html']"))
  val clickUrl: String = clickLink.getAttribute("href")
  println(s"This is the url: $clickUrl")
  clickLink.click()
  println("Link clicked")

  driver.quit()

}
