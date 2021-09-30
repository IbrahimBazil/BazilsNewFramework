package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class RegistrationForm_pageObjects {

	public WebDriver driver;
	public JavaScriptExe js;
	public ElementUtils elu;
	public Long timeAppender = System.currentTimeMillis();

	public RegistrationForm_pageObjects(WebDriver driver) {
		this.driver = driver;
		js = new JavaScriptExe(this.driver);
		elu = new ElementUtils(this.driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//iframe[@class='modalfx-iframe']")
	WebElement frame_ele;
	
	@FindBy(how=How.XPATH, using="//iframe[@title='embedded_visit_iframe']")
	WebElement frame_tour;

	@FindBy(how = How.XPATH, using = "//input[@id='first_name']")
	WebElement firstname_txt;

	@FindBy(how = How.ID, using = "last_name")
	WebElement lastname_txt;

	@FindBy(how = How.ID, using = "email")
	WebElement email_txt;

	@FindBy(how = How.ID, using = "password")
	WebElement password_fld;

	@FindBy(how = How.ID, using = "note")
	WebElement note_txt;

	@FindBy(how = How.NAME, using = "confirm_password")
	WebElement confirmPassword_txt;

	@FindBy(how = How.ID, using = "btnContactSubmit")
	WebElement savesearch_btn;

	@FindBy(how = How.ID, using = "phone")
	WebElement phone_txt;

	@FindBy(how = How.XPATH, using = "//iframe[not(contains(@style,'width: 100%; height: 100%;'))][@title='recaptcha challenge']")
	WebElement captcha;

	public void doRegistrationListView() {
		// elu.switchFrameByClassName(iframe);
		try {
			Thread.sleep(5000);
			elu.switchFrame(frame_ele);
			Thread.sleep(5000);
			// driver.switchTo().frame(frame_ele);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String first_name = "qa_" + timeAppender;
			String last_name = "qa_" + timeAppender;
			String email = "qa_" + timeAppender + "@gmail.com";
			String password = "password";
			elu.doSendKeys(firstname_txt, first_name);
			elu.doSendKeys(lastname_txt, last_name);
			elu.doSendKeys(email_txt, email);
			elu.doSendKeys(password_fld, password);
			elu.sendKeyAction(password_fld);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public boolean captchaDisplayed() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return captcha.isDisplayed();
	}
	
	public void doRegistrationWithPhone() {
		// elu.switchFrameByClassName(iframe);
		try {
			Thread.sleep(5000);
			elu.switchFrame(frame_ele);
			Thread.sleep(5000);
			// driver.switchTo().frame(frame_ele);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String first_name = "qa_" + timeAppender;
			String last_name = "qa_" + timeAppender;
			String email = "qa_" + timeAppender + "@gmail.com";
			String password = "password";
			String phonenumber="9941765628";
			elu.doSendKeys(firstname_txt, first_name);
			elu.doSendKeys(lastname_txt, last_name);
			elu.doSendKeys(email_txt, email);
			elu.doSendKeys(password_fld, password);
			elu.doSendKeys(phone_txt, phonenumber);
			elu.sendKeyAction(password_fld);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	public void doRegistrationinTourThisHomeHD() {
		// elu.switchFrameByClassName(iframe);
		try {
			Thread.sleep(5000);
			elu.switchFrame(frame_tour);
			Thread.sleep(5000);
			// driver.switchTo().frame(frame_ele);
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String first_name = "qa_" + timeAppender;
			String last_name = "qa_" + timeAppender;
			String email = "qa_" + timeAppender + "@gmail.com";
			String password = "password";
			String phonenumber="9941765628";
			elu.doSendKeys(firstname_txt, first_name);
			elu.doSendKeys(lastname_txt, last_name);
			elu.doSendKeys(email_txt, email);
			elu.doSendKeys(password_fld, password);
			elu.doSendKeys(phone_txt, phonenumber);
			elu.sendKeyAction(password_fld);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	

}
