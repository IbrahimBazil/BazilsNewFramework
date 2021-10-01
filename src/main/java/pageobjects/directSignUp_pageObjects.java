package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class directSignUp_pageObjects {

	public WebDriver driver;
	public JavaScriptExe js;
	public ElementUtils elu;
	public Long timeAppender = System.currentTimeMillis();
	public Logger log = Logger.getLogger(BasePage.class);

	public directSignUp_pageObjects(WebDriver driver) {
		this.driver = driver;
		elu = new ElementUtils(this.driver);
		js = new JavaScriptExe(this.driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='first_name']")
	WebElement firstname_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='last_name']")
	WebElement lastname_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='email_address']")
	WebElement email_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='confirm_email_address']")
	WebElement cnfirmemail_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement password_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='confirm_password']")
	WebElement confirmpassword_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='home_telephone_number']")
	WebElement phone_txt;

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement submit_btn;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement c21_chckbx;

	public void registerDirectSignup() {
		String first_name = "qa_" + timeAppender;
		String last_name = "qa_" + timeAppender;
		String email = "qa_" + timeAppender + "@gmail.com";
		String password = "password";
		String phonenumber = "9941765628";
		elu.doSendKeys(firstname_txt, first_name);
		elu.doSendKeys(lastname_txt, last_name);
		elu.doSendKeys(email_txt, email);
		elu.doSendKeys(cnfirmemail_txt, email);
		elu.doSendKeys(password_txt, password);
		elu.doSendKeys(confirmpassword_txt, password);
		elu.doSendKeys(phone_txt, phonenumber);
		js.clickElementByJS(submit_btn);
	}

	public void registerDirectSignupC21() {
		String first_name = "qa_" + timeAppender;
		String last_name = "qa_" + timeAppender;
		String email = "qa_" + timeAppender + "@gmail.com";
		String password = "password";
		String phonenumber = "9941765628";
		elu.doSendKeys(firstname_txt, first_name);
		elu.doSendKeys(lastname_txt, last_name);
		elu.doSendKeys(email_txt, email);
		elu.doSendKeys(cnfirmemail_txt, email);
		elu.doSendKeys(password_txt, password);
		elu.doSendKeys(confirmpassword_txt, password);
		elu.doSendKeys(phone_txt, phonenumber);
		js.clickElementByJS(c21_chckbx);
		js.clickElementByJS(submit_btn);
	}
}
