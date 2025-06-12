package automation.locators.tasks

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object LocatorsTask4 extends App {

  // MVP TASK
  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // BY ID
  val textInput: WebElement = driver.findElement(By.id("my-text-id": String))
  textInput.sendKeys("Pablo": String)

  println(s"name entered: $textInput - Pass")

  // BY NAME
  val password: WebElement= driver.findElement(By.name("my-password": String))
  password.sendKeys("Password123": String)

  println(s"password entered: $password - Pass")


  // BY CLASS NAME
  val formInputs = driver.findElements(By.className("form-control": String))
  val textArea: WebElement = formInputs.get(2)
  textArea.sendKeys("This is a test comment": String)

  println(s"comment entered: $textArea - Pass")


  // BY TAG NAME (COUNT ELEMENTS)
  val inputElements = driver.findElements(By.tagName("input": String))
  println("Number of inputs: " + inputElements.size() + " - Pass")


  // BY LINK TEXT
  val linkText: WebElement = driver.findElement(By.linkText("Return to index": String))
  linkText.click()

  println(s"link $linkText clicked - Pass")

  driver.navigate().back()

  // BY PARTIAL LINK TEXT
  val partialLinkText: WebElement = driver.findElement(By.partialLinkText("Return": String))
  partialLinkText.click()

  println(s"link $partialLinkText clicked - Pass")

  driver.navigate().back()


  // EXTENSION 1
  driver.get("https://www.w3schools.com/html/html_examples.asp")

  // A) BUTTONS
  val buttons = driver.findElements(By.className("ws-btn": String))
  println("Number of buttons: " + buttons.size())


  // B) IMAGES
  val images = driver.findElements(By.tagName("img": String))
  println("Number of images: " + images.size())


  // C) HOW MANY ELEMENTS?
  val title = driver.findElements(By.tagName("h1": String))
  println("Number of <h1>: " + title.size())

  // D) HOW MANY OF EACH TAG?
  val tags = List("p", "h2", "h3", "button")

  tags.foreach { tag =>
    val elements = driver.findElements(By.tagName(tag))
    println(s"Number of <$tag> elements: ${elements.size()}")
  }

  // D) HOW MANY HYPERLINKS?
  val hyperLinks = driver.findElements(By.tagName("a": String))
  println("Number of hyperLinks: " + hyperLinks.size())


  // EXTENSION 2
  driver.get("https://demoqa.com")

  // A)
  val topCard: WebElement = driver.findElement(By.className("top-card"))
  topCard.click()

  val textBox: WebElement = driver.findElement(By.id("item-0"))
  textBox.click()

  // I have used the class, because there is unique in this case
  val fullNameInput: WebElement = driver.findElement(By.className("form-control"))
  fullNameInput.sendKeys("Pablo Montalvo")

  // B) EXTRA-SPACES

  // Why is this a problem?
    // By.LINK_TEXT expects exact match of the visible text.
    // XPath text() = 'Text Box' also expects exact text content.
    // Extra spaces or newlines mean the match fails.

  // This works because allows matching text ignoring extra whitespace.
  val checkBox: WebElement = driver.findElement(By.xpath("//*[normalize-space(text())='Check Box']"))
  checkBox.click()

  // C) HIDDEN-ELEMENTS

  val label = driver.findElement(By.xpath("//label[@for='tree-node-home']"))
  label.click()

  val secretSuccessMsgs = driver.findElements(By.className("text-success"))
  println("This is the secret message:")
  for (msg <- secretSuccessMsgs.asScala) {
    print(s"${msg.getText}, ")
  }



}
