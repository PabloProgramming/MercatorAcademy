package automation.handling_web_elements

import automation.handling_web_elements.JavaScriptExecutor.explicitWait
import org.openqa.selenium.{By, WebDriver, WebElement, JavascriptExecutor}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object HandlingDynamicDropDowns extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.manage().window().maximize()
  driver.get("https://demoqa.com/automation-practice-form")
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))

  val stateField: WebElement = driver.findElement(By.id("state"))

  val jsExecutor = driver.asInstanceOf[JavascriptExecutor]

  jsExecutor.executeScript("arguments[0].scrollIntoView();", stateField)

  stateField.click()

  // use xpath + method contains and wait for the options to show
  val stateOption: WebElement = explicitWait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'NCR')]")))

  stateOption.click()

  val cityField: WebElement = driver.findElement(By.id("city"))
  cityField.click()


  // use xpath + method contains and wait for the options to show
  val cityOption: WebElement = explicitWait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Gurgaon')]")))
  cityOption.click()

  val chosenState = driver.findElement(By.xpath("//div[@id='state']//div[contains(@class,'-singleValue')]")).getText
  val chosenCity  = driver.findElement(By.xpath("//div[@id='city']//div[contains(@class,'-singleValue')]")).getText
  assert(chosenState == "NCR",  s"State was <$chosenState>")
  assert(chosenCity  == "Gurgaon", s"City  was <$chosenCity>")

}
