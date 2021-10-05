package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class ListView_PageObjects {

	public WebDriver driver;
	public JavaScriptExe js;
	public ElementUtils elu;
	public ListView_PageObjects(WebDriver driver) {
		this.driver=driver;
		elu= new ElementUtils(this.driver);
		js = new JavaScriptExe(this.driver);
		PageFactory.initElements(this.driver, this);
		
	}
	
	@FindBy(how=How.ID, using="saveSearchLink")
	WebElement saveSearch;
	
	@FindBy(how=How.ID, using="saveLink0")
	WebElement HeartIconInListView;
	
	
	public void clickSaveSearch() {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//elu.doClick(saveSearch);
		try {
			Thread.sleep(10000);
			js.clickElementByJS(saveSearch);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void clickHeartIconInListView() {
		try {
			Thread.sleep(10000);
			js.clickElementByJS(HeartIconInListView);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
}
