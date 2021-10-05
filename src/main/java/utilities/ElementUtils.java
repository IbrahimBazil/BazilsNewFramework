package utilities;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.BaseTest;

public class ElementUtils extends BaseTest {

	public WebDriver driver;
	public JavaScriptExe js;
	protected static final Logger log = Logger.getLogger(BasePage.class);

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		js = new JavaScriptExe(this.driver);
	}

	public String waitForTitleToBePresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		String title = driver.getTitle();
		wait.until(ExpectedConditions.titleContains(title));
		log.info("Title of the Page is Displayed as: " + title);
		return title;
	}

	public void highlightElement(WebElement element) {
		if (BasePage.highlight.equalsIgnoreCase("true")) {
			js.flash(element);
		}
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		log.info("Size of the Elements: " + elements.size());
		return elements;
	}

	public void doSendKeys(WebElement element, String Value) {
		element.clear();
		log.info("Cleared the Text Field for : " + element.getText());
		// js.drawBorder(element);
		element.sendKeys(Value);
		log.info("Entering the Value: " + Value);
	}

	public void sendKeyAction(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public void doClick(WebElement element) {
		// WebDriverWait wait = new WebDriverWait(driver, 10000);
		element.click();
		log.info("Entered the Value");
	}

	public String doGetTxt(WebElement element) {
		String textValue = element.getText();
		log.info("Text captured from the WebElement is: " + textValue);
		return textValue;

	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void doActionClick(WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).perform();
		log.info("Clicked on the Element using the Actions Class" + element);
	}

	public void doClickFromList(List<WebElement> element, String Value) {
		String selectedOption = null;
		for (WebElement option : element) {
			log.debug("Elements Available in the List" + option.getText());
			if (option.getText().equalsIgnoreCase(Value)) {
				selectedOption = option.getText();
				js.clickElementByJS(option);
				break;
			}
		}
	}

	public void switchFrame(WebElement element) {
		// driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		// WebElement frame=driver.findElement(By.className(locatorElement));

		try {
			Thread.sleep(5000);
			driver.switchTo().frame(element);
			Thread.sleep(5000);
			log.info("Frame Switched");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

	}
}
