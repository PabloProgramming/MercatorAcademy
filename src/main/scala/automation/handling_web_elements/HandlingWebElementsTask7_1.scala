package automation.handling_web_elements

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object HandlingWebElementsTask7_1 extends App {

  // MVP
  val driver: WebDriver = new ChromeDriver()

  // 1. Navigate and maximize
  driver.navigate().to("https://testpages.eviltester.com/styled/index.html")
  driver.manage().window().maximize()
  println("Window maximized - ✅")

  // 2. Handle TextBox
  val formPageLink: WebElement = driver.findElement(By.id("htmlformtest"))
  val linkText: String = formPageLink.getText
  formPageLink.click()
  println(s"Link: $linkText clicked - ✅")

  val usernameInput: WebElement = driver.findElement(By.name("username"))
  usernameInput.sendKeys("pablomt9")
  println(s"Username entered: ${usernameInput.getAttribute("value")}")

  val passwordInput: WebElement = driver.findElement(By.name("password"))
  passwordInput.sendKeys("pass-not-word123")
  println(s"Password entered: ${passwordInput.getAttribute("value")}")

  // 3. Handle CheckBox
  val checkbox: WebElement = driver.findElement(By.xpath("//input[@value='cb2']"))
  if (checkbox.isDisplayed && !checkbox.isSelected) {
    checkbox.click()
    println(s"Checkbox ${checkbox.getAttribute("value")} clicked - ✅")
  } else {
    println("Please try again later")
  }

  // 4. Handle Radio Buttons
  val radioButton: WebElement = driver.findElement(By.cssSelector("input[value='rd1']"))
  if (radioButton.isDisplayed && !radioButton.isSelected) {
    radioButton.click()
    println(s"Radio button ${radioButton.getAttribute("value")} selected - ✅")
  }

  // 5. Handle DropDown Select
  val dropDownSelect: WebElement = driver. findElement(By.name("dropdown"))
  val select: Select = new Select(dropDownSelect)

  select.selectByValue("dd5")
  println(s"Option selected: ${select.getFirstSelectedOption.getText} - ✅")

  // 6. Handle Submit Button

  // Cast driver to JavascriptExecutor to scroll down
  val jsExecutor = driver.asInstanceOf[JavascriptExecutor]
  val submitButton: WebElement = driver.findElement(By.cssSelector("input.styled-click-button[type='submit']"))
  if (submitButton.isDisplayed && submitButton.isEnabled) {
    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", submitButton)
    submitButton.click()
    println(s"Submitted! - ✅")
  } else {
    println("Please try again later")
  }


  // 7. Handle Links
  val linkToReturn: WebElement = driver.findElement(By.id("back_to_form"))
  if (linkToReturn.isDisplayed && linkToReturn.isEnabled) {
    jsExecutor.executeScript("arguments[0].scrollIntoView(true)", linkToReturn)
   val linkText: String = linkToReturn.getText
    linkToReturn.click()
    println(s"$linkText link clicked - ✅")
  }







}
