package automation.browser_control_methods

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object BrowserMethods extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // Maximize window
  driver.manage().window().maximize()

  // .get or navigate().to()
  driver.navigate().to("https://the-internet.herokuapp.com")

  driver.navigate().back()

  driver.navigate().forward()

  driver.navigate().refresh()

  driver.close()



}
