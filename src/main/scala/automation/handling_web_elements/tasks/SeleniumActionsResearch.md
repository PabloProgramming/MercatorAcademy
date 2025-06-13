# Selenium Actions Class Notes

---

## 1. What is Selenium Actions class, why is it used?

- The **Actions class** in Selenium is used to build and perform complex user interactions with the browser.
- It is designed to simulate **advanced user gestures** that go beyond simple clicks or typing.
- These interactions include mouse movements, keyboard input, drag-and-drop, and more.
- Purpose: To automate real user behaviors which cannot be achieved with simple WebDriver commands.

---

## 2. Commonly Used Methods in the Actions Class

| Method                  | Description                                               | Example Scenario                                        |
|-------------------------|-----------------------------------------------------------|---------------------------------------------------------|
| `.click()`              | Performs a click on an element or at the current mouse location. | Clicking a button or link.                              |
| `.moveToElement(WebElement)` | Moves the mouse pointer over a specific element (hover).  | Hovering over a menu to reveal a dropdown submenu.      |
| `.doubleClick()`        | Performs a double-click on an element.                    | Opening a file in a file explorer UI.                   |
| `.contextClick()`       | Performs a right-click (context click) on an element.     | Opening context menu for custom options.                |
| `.dragAndDrop(source, target)` | Drags an element from source and drops it on target.     | Rearranging items in a list via drag-and-drop.          |
| `.sendKeys(CharSequence...)` | Sends keys to the active element or specific element.         | Typing text in an input box or sending keyboard shortcuts.|

---
## 3. Chaining Multiple Actions Together (Scala Example)

```scala
import org.openqa.selenium.interactions.Actions

val actions = new Actions(driver)
val element = driver.findElement(By.id("someId"))
val target = driver.findElement(By.id("targetId"))

actions
  .moveToElement(element)    // Hover over element
  .click()                  // Click it
  .sendKeys("Hello World")  // Type text
  .dragAndDrop(element, target) // Drag element to target
  .build()                  // Build the chain of actions
  .perform()                // Perform all actions in sequence
```
---
## 4. Difference Between `.click()` and `.moveToElement().click()`

| Method                      | Description                                            | When to Use                                      |
|-----------------------------|--------------------------------------------------------|-------------------------------------------------|
| `.click()`                  | Clicks at the current mouse location or directly on a WebElement. | Use for straightforward clicks where the element is visible and easily clickable. |
| `.moveToElement().click()`  | Moves the mouse pointer to the element first, then performs the click. | Use when the element requires hovering to become visible or clickable (e.g., dropdown menus, hidden buttons). |

**Summary:**  
`.moveToElement().click()` is helpful for interacting with elements that are not immediately clickable because they appear or become enabled only after hovering, while `.click()` works fine for elements that are always visible and clickable.
---
## 5. How to Perform a Drag-and-Drop Operation Using Actions Class

- **Explanation:**  
  To perform drag-and-drop, you first identify the source element you want to drag and the target element where you want to drop it. Using the Actions class, you build a sequence that clicks and holds the source element, moves it to the target element, and then releases it.

- **Sample Code (Scala):**

```scala
val actions = new Actions(driver)
val source = driver.findElement(By.id("sourceElementId"))
val target = driver.findElement(By.id("targetElementId"))

actions
  .dragAndDrop(source, target)
  .build()
  .perform()
```
---
## 6. Handling Elements Not Visible or Covered by Other Elements with Actions Class

- **Issue:**  
  The Actions class requires the element to be visible and interactable. If an element is **not visible** (e.g., `display:none`, off-screen) or **covered by another element**, Selenium will throw exceptions such as:
  - `ElementNotVisibleException`
  - `ElementClickInterceptedException`
  - `MoveTargetOutOfBoundsException`
    <br><br>
- **How to Handle:**
  - **Wait until the element is visible and enabled:** Use explicit waits (`WebDriverWait`) with conditions like `visibilityOf(element)` or `elementToBeClickable(element)`.
  - **Scroll into view:** Use JavaScript to scroll the element into the viewport before performing actions.
  - **Check for overlays or modals:** Sometimes other elements block interaction; wait for them to disappear or close them before proceeding.
  - **Use JavaScript clicks as fallback:** If the standard click or move fails, you can execute JavaScript `element.click()` as a last resort.
  <br><br>
- **Example Handling with Wait and Scroll:**

```scala
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

val pleaseWait = new WebDriverWait(driver, 10)
val element: WebElement = pleaseWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId"))) // is the WebElement but you get it when the waitCondition is achived

val js = driver.asInstanceOf[JavascriptExecutor]
js.executeScript("arguments[0].scrollIntoView(true);", element)

// Now safely perform Actions on the element
val actions = new Actions(driver)
actions.moveToElement(element).click().perform()
```
---
## 7. Can the Actions Class Be Used Effectively in Headless Browser Mode?

- **What is Headless Mode?**  
  Headless mode runs a browser **without a graphical user interface (GUI)**. This means the browser operates in the background without opening a visible window, which is useful for faster automated testing and running tests on servers without display.
  <br><br>
- **Using Actions Class in Headless Mode:**  
  - The Actions class generally works in headless mode, but some interactions like mouse movements, drag-and-drop, or hover effects may behave differently or fail because there is no actual GUI.  
  <br>
- **Considerations:**  
  - Some events triggered by real user input might not fire correctly.  
  - Visual elements that rely on hover or focus might not behave as expected.  
  - It’s often better to run tests in headed mode when testing complex user interactions.  

---

## 8. Touch Actions in Selenium: Relation to Actions Class and Use Cases

- **What are Touch Actions?**  
  Touch Actions simulate finger gestures on touch-enabled devices (mobile/tablets), such as tap, swipe, pinch, and zoom.
- **Relation to Actions Class:**  
  Touch Actions are a specialized subset of the Actions class designed for mobile gestures. They use similar concepts but are focused on touch input rather than mouse/keyboard.
- **When to Use:**
  - Testing mobile web apps or native apps on emulators or real devices.
  - When needing to simulate touch gestures that can’t be done with mouse actions.

### Examples of Touch Actions and Code Snippet

- **Common Touch Actions:**
  - `tap` — single finger tap on an element
  - `longPress` — press and hold on an element
  - `swipe` — drag finger from one point to another
  - `scroll` — scroll through a scrollable area
  - `pinch` / `zoom` — pinch fingers together or spread apart

- **Sample Code Snippet (Java, using TouchAction with Appium):**
```scala
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.offset.ElementOption
import io.appium.java_client.touch.WaitOptions
import java.time.Duration
import io.appium.java_client.MobileElement

val touchAction = new TouchAction(driver)
val element: MobileElement = driver.findElementById("elementId")

// Tap on element
touchAction.tap(ElementOption.element(element)).perform()

// Long press on element for 2 seconds
touchAction.longPress(ElementOption.element(element))
.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
.release()
.perform()

// Swipe from one element to another
val start: MobileElement = driver.findElementById("startId")
val end: MobileElement = driver.findElementById("endId")
touchAction.press(ElementOption.element(start))
.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
.moveTo(ElementOption.element(end))
.release()
.perform()
```
---

## 9. Difference Between `moveToElement()` and `moveByOffset()`

| Method                 | Description                                                   | When to Use                                         |
|------------------------|---------------------------------------------------------------|----------------------------------------------------|
| `moveToElement(WebElement)` | Moves the mouse pointer to the **center** of the specified element. | When you want to hover or interact with a specific element on the page (e.g., hover to reveal dropdown). |
| `moveByOffset(x, y)`   | Moves the mouse pointer by an **offset (x, y)** pixels relative to its current position. | When you need precise control over pointer location, such as clicking at an exact spot or dragging by a certain distance. |

### Examples

- **moveToElement() example:**  
  Hover over a menu to reveal a submenu before clicking an option:
  ```scala
  val menu = driver.findElement(By.id("menu"))
  actions.moveToElement(menu).perform()  // Hover triggers dropdown
  ```
- **moveByOffset() example:**  
  Move mouse 50 pixels right and 20 pixels down from current position to click a canvas area:
  ```scala
  actions.moveByOffset(50, 20).click().perform()
  ```
  
---

## 10. Real-World Examples Where Actions Class Solved Complex UI Interaction Problems

### Example 1: Hover-triggered Menus
**Problem:** A website’s navigation menu reveals submenus only on hover, which regular `.click()` methods can’t trigger.  
**Solution:** Using `moveToElement()` to hover over the menu item caused the submenu to appear, allowing the test to click submenu options reliably.

### Example 2: Drag-and-Drop Interfaces
**Problem:** Testing a kanban board UI where tasks can be dragged between columns. Regular click and sendKeys couldn’t simulate drag-and-drop.  
**Solution:** The Actions class’s `dragAndDrop()` method was used to simulate the drag gesture precisely, enabling automated reordering of tasks.

### Example 3: Complex Multi-step User Input
**Problem:** Filling a form that required clicking, typing, selecting dropdowns, and submitting within a single continuous user action flow.  
**Solution:** Chained actions with `moveToElement()`, `click()`, `sendKeys()`, and `submit()` in one sequence ensured all steps were performed smoothly without losing focus or triggering timing issues.




