package automation.handling_web_elements

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import java.io.File

object HandlingUploadFIles extends App {

  val filePathPhoto: String = "/Users/pablo.montalvo/Downloads/pablo-photo.jpg"


  val driver: WebDriver = new ChromeDriver()
  driver.get("https://demoqa.com/automation-practice-form")

  val chooseFileQA: WebElement = driver.findElement(By.id("uploadPicture"))

  def uploadFIle(filePath: String, chooseFile: WebElement): Boolean = {
    val fileToUpload: File = new File(filePath)
    require(fileToUpload.exists(), s"❌ File not found: $filePath")

    chooseFile.sendKeys(filePath)

    val fileName: String = fileToUpload.getName
    val valueFromInput = chooseFile.getAttribute("value")
    valueFromInput.contains(fileName)
  }

  val success: Boolean = uploadFIle(filePathPhoto, chooseFileQA)
  println(if (success) "✅ File uploaded and verified!" else "❌ Upload verification failed.")





}
