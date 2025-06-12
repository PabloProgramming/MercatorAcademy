package automation.handling_web_elements

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

object HandlingTables extends App {

  val driver: WebDriver = new ChromeDriver()

  driver.get("https://www.w3schools.com/html/html_tables.asp")

  driver.manage().window().maximize()

  val tableRows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[position() > 1]"))

  for(i <- 0  until  tableRows.size()) {
    val cols = tableRows.get(i).findElements(By.tagName("td"))
    val rowsText = cols.toArray.map(_.asInstanceOf[WebElement].getText).mkString(" | ")
    println(s"Row ${i + 1}: $rowsText")
  }

}
