package automation.browser_control_methods.tasks

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object WebDriverMethodsTask6_2 extends App {

  val driver: WebDriver = new ChromeDriver()

  // Task 2

  driver.get("https://demoqa.com/automation-practice-form")
  println(s"Current URL: ${driver.getCurrentUrl}")
  driver.navigate().to("https://example.com/")
  println(s"Now the current URL is: ${driver.getCurrentUrl}")

  driver.navigate().back()
  println("Going back 🔙")

  driver.navigate().forward()
  println("Going forward 🔜")

  driver.navigate().refresh()
  println("Refresh 🔁")

  driver.manage().window().maximize()
  println("Window maximized 💯")

  val pageSource: Array[String] = driver.getPageSource.split("<body>")
  println(s" Body pageSource: ${pageSource(1)}")

  driver.close()
  driver.quit()

}
