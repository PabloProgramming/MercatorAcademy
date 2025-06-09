package automation.locators

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object ExtraLocators extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // CSS LOCATORS :   driver.findElements(By.cssSelector("[data-role='admin]"))

  // BY ID
  val cssTextInput: WebElement = driver.findElement(By.cssSelector("#my-text-id"))
  cssTextInput.sendKeys("Css selectors rock")

  // BY CLASS
  val cssForms = driver.findElements(By.cssSelector(".form-control"))
  val textArea: WebElement = cssForms.get(2)
  textArea.sendKeys("Css selectors even in classes!")

  // BY ATTRIBUTE
  val cssCheckBox: WebElement = driver.findElement(By.cssSelector("input[type='checkbox']"))
  cssCheckBox.click()
  cssCheckBox.click()

  // BY PARTIAL ATTRIBUTE
  val cssPartialAttribute: WebElement = driver.findElement(By.cssSelector("input[name*='date"))
  cssPartialAttribute.click()
  cssPartialAttribute.sendKeys("03/01/2025")

  // BY PARENT-CHILD
  val cssParentChildPassword: WebElement = driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(1) > label:nth-child(2) > input"))
  cssParentChildPassword.sendKeys("Long but useful")
  //  div:nth-child(1) - (1) because this is the first div tag in the nest
  //  label:nth-child(2) - (2) because this is the 2nd label tag in the nest

  // BY TAG & CLASS
  val cssButton: WebElement = driver.findElement(By.cssSelector("button.btn[type='submit']"))
  // cssButton.click()


  // XPATH LOCATOR (XML PATH LANGUAGE) - FOR DEEPLY NESTED OR DYNAMIC

  // BY ATTRIBUTE
  val xpathAttribute: WebElement = driver.findElement(By.xpath("//input[@id='my-text-id']"))
  xpathAttribute.sendKeys(" / Now is xpath turn!")

  // BY CONTAIN ATTRIBUTE
  val xpathContainsAttribute: WebElement = driver.findElement(By.xpath("//input[contains(@type, 'checkbox')]"))
  xpathContainsAttribute.click()
  xpathContainsAttribute.click()

  val xpathContainsText: WebElement = driver.findElement(By.xpath("//button[text()='Submit']"))
  xpathContainsText.click()


}
