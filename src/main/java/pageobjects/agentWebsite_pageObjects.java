package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class agentWebsite_pageObjects {

	public WebDriver driver;
	public JavaScriptExe js;
	public ElementUtils elu;
	public agentWebsite_pageObjects(WebDriver driver) {
		this.driver=driver;
		elu = new ElementUtils(this.driver);
		js = new JavaScriptExe(this.driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[@data-title='Contact Agent']")
	WebElement contactAgent_btn;
	
	public void clickContactAgent() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.clickElementByJS(contactAgent_btn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}
