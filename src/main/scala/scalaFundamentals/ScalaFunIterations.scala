package scalaFundamentals

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver

import java.util
import scala.jdk.CollectionConverters.CollectionHasAsScala

object ScalaFunIterations extends App {

  // for comprehension

  /*
  * for (item <- collection) {
  * // DO SOMETHING
  * }
  * */

/*  // SCALA
  val fruits: List[String] = List("Apple", "Banana", "Cherry", "Melon")

  for (fruit <- fruits) {
    println(fruit)
  }

  // TURN INTO SELENIUM (CODE DOES NOT WORK)
  /*
  *  for (fruit <- fruits.asScala) {
  * println(fruit.getText)
  * }
  * */

  val driver: WebDriver = new ChromeDriver()
  driver.get("example.com")

  val items: Iterable[WebElement] = driver.findElements(By.id("i")).asScala
  for (item <- items) {
    println(item.getText)
  }


  // Click all buttons
  val buttons: Iterable[WebElement] = driver.findElements(By.cssSelector(".my-buttons")).asScala

  for (button <- buttons) {
    button.click()
  }

  // If you want to find a specific element in a collection
  val links: Iterable[WebElement] = driver.findElements(By.xpath("//a[@vale='content']")).asScala

  for (link <- links) {
    if (link.getText.contains("Contact".toLowerCase)) {
      link.click()
    } else {
      println("Link not found")
    }
  }

  // TABLES for comprehension

  <table>
    <tr>
      <td>Apple</td>
      <td>Red</td>
    </tr>
    <tr>
      <td>Banana</td>
      <td>Yellow</td>
    </tr>
  </table>

  val rows: Iterable[WebElement] = driver.findElements(By.tagName("tr")).asScala
  // zipWithIndex: (zip the jacket) Pairs each row with its index (starting from 0)
  // Row 0: Apple | Red
  // Row 1: Banana | Yellow
  for ((row, index) <- rows.zipWithIndex) {
    val cells: Iterable[WebElement] = row.findElements(By.tagName("td")).asScala
    val makeString: String = cells.map(_.getText).mkString(" ".trim) // Make nice formating
    println(makeString)
  }

  // Does a value exist?
  val doesBananaExists = rows.exists { row =>
    val cells: Iterable[WebElement] = row.findElements(By.tagName("td")).asScala
    cells.exists(_.getText == "Banana")
  }
  assert(doesBananaExists, "Banana does not exist!")
*/
}



