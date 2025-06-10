package automation.browser_control_methods

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object WebDriverMethodsTask6_1 extends App {

  val driver: WebDriver = new ChromeDriver()

  // Task 1

  driver.get("https://the-internet.herokuapp.com")
  println(s"Title: ${driver.getTitle}")
  println(s"Current URL: ${driver.getCurrentUrl}")

  driver.close()
  driver.quit()

}
