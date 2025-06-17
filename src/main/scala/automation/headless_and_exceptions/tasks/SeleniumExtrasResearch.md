# Selenium Pagination Testing Notes

---

## 1. How to Test Data Consistency Across Paginated Tables

- Use Selenium to **navigate through each page** of the paginated table.
- On each page, **extract all visible items/data** and store them in a collection (e.g., list or set).
- Check for **duplicates** by verifying items don’t appear more than once across pages.
- Check for **missing items** by verifying the total count matches expected data size or no items are skipped.
- Use **unique identifiers** (like IDs or unique text) to track and compare items across pages.

### Sample Scala Code for Data Collection Across Pages

```scala
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import scala.collection.mutable.Set

val allItems = Set[String]()
var hasNextPage = true

while (hasNextPage) {
  // Extract items from current page
  val rows = driver.findElements(By.cssSelector(".table-row-class"))
  rows.forEach(row => {
    val itemText = row.getText
    allItems += itemText
  })

  // Check if 'Next' button is enabled/clickable
  val nextButton = driver.findElement(By.id("nextPageButton"))
  if (nextButton.isEnabled) {
    nextButton.click()
    // Wait for table to load after clicking (explicit wait recommended)
  } else {
    hasNextPage = false
  }
}

// Validate duplicates
assert(allItems.size == allItems.toList.distinct.size, "Duplicate items found across pages")
```

---

## 2. Best Practices for Scalable Pagination Tests

- **Dynamic pagination handling:** Detect total pages dynamically instead of hardcoding.

### Sample Scala Code to Get Total Pages Dynamically

```scala
val totalPagesText = driver.findElement(By.id("totalPages")).getText // e.g. "Page 1 of 10"
val totalPages = totalPagesText.split("of")(1).trim.toInt
```

- **Reusable functions:** Create methods for navigation and data extraction.

### Sample Method for Navigating to a Page

```scala
def goToPage(pageNumber: Int): Unit = {
val pageLink = driver.findElement(By.xpath(s"//a[text()='$pageNumber']"))
pageLink.click()
// Add wait for table to load
}
```
