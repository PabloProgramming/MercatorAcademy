package automation

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object InvokeChromeBrowser extends App {

  //FIRST WEB DRIVER SCRIPT WHICH WILL INVOKE THE CHROME BROWSER

  val driver: WebDriver = new ChromeDriver()
  println("Invoking Chrome Browser!")

  driver.get("https://www.google.com")
  println("Title of the page: " + driver.getTitle)
  driver.quit()
}
