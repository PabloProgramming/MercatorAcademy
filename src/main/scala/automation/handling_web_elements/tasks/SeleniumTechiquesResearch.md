# Handling Uploading & Downloading

## 1. Upload file
- Locate the file input element
- Use `SendKeys("absolute path of the file")` to upload the file

## 2. Download

### Basic approach
- Locate the download button
- Click it and **wait** until the download completes to confirm success

### Best practice: Configure Browser Download Preferences
- **Create a HashMap for Chrome preferences:**
    - Set `"profile.default_content_settings.popups"` to `0` (disable popups)
    - Set `"download.default_directory"` to your desired download folder path
- **Initialize Browser with Preferences:**
    - Create a `ChromeOptions` instance
    - Apply preferences with `setExperimentalOption("prefs", chromePrefs)`
    - Initialize `ChromeDriver` with the configured options

# Handling Scrolling in Selenium

## 1. Scroll Using JavaScript Executor
- Selenium WebDriver does not provide a direct scroll method.
- Use JavaScript to scroll the page.

### Examples:
- Scroll down by pixels:  
  Use `executeScript("window.scrollBy(0, 500)")` to scroll down 500 pixels.
- Scroll to the bottom of the page:  
  Use `executeScript("window.scrollTo(0, document.body.scrollHeight)")`.
- Scroll to a specific element:  
  Use `executeScript("arguments[0].scrollIntoView(true);", element)` where `element` is the WebElement you want to scroll to.

## 2. Scroll Using Actions Class
- Use the Actions class to send keyboard keys like PAGE_DOWN or ARROW_DOWN.

### Example:
Create an Actions object and send keys:  
`actions.sendKeys(Keys.PAGE_DOWN).perform()`

# What is a Dynamic Dropdown?

## Definition
- A **dynamic dropdown** is a dropdown menu that changes its options based on what the user does.
- It updates automatically instead of having fixed choices.

## How It Works
- Options can change when you select something else or type in a box.
- Often uses JavaScript or data from a server to update options.

## Examples
- Choosing a country updates the list of states.
- Typing shows suggestions in the dropdown.
- Options load after you start interacting.

## Handling in Selenium
- Wait for new options to appear before selecting.
- Find the updated options and click the one you want.


# What is a Shadow DOM?

## Definition
- Shadow DOM is a hidden part of a webpage inside a special container.
- It keeps some elements separate from the main page.
- This helps make web components work without affecting the rest of the page.

## How It Works
- Elements inside Shadow DOM are isolated.
- Normal methods can’t see or access them directly.
- Browsers create a “shadow root” to hold this hidden part.

## Examples
- Custom buttons or widgets on a page may use Shadow DOM.
- Elements like video player controls use Shadow DOM to keep things neat.

## Handling in Selenium
- You must first get the shadow root before you can find elements inside it.
- Normal element searches won’t work inside Shadow DOM.

---

## Notes
- Shadow DOM helps build clean, reusable parts for websites.
- It can be tricky to test without special steps.
