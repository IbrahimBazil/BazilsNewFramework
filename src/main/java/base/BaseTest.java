package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import base.BasePage;
import listeners.Listeners;
import pageobjects.ListView_PageObjects;
import pageobjects.RegistrationForm_pageObjects;
import pageobjects.agentWebsite_pageObjects;
import pageobjects.directSignUp_pageObjects;
import pageobjects.homeDetails_PageObjects;
import pageobjects.homePageObjects;
import utilities.ElementUtils;
import utilities.JavaScriptExe;

public class BaseTest extends BasePage{

	public static WebDriver driver;
	public Properties prop;
	public homePageObjects hmpg;
	public ListView_PageObjects lvp;
	public JavaScriptExe js;
	public ElementUtils elu;
	public RegistrationForm_pageObjects reg;
	public homeDetails_PageObjects hdp;
	public agentWebsite_pageObjects awp;
	public directSignUp_pageObjects dsp;
	public static String path1 = System.getProperty("user.dir");
	public static String OUTPUT_FOLDER = path1 + "//reports//Screenshots//";
	public String FILE_NAME;
	
	@Parameters({ "browser", "version" })
	@BeforeClass(alwaysRun = true)
	public void launchsite(@Optional String browserName, @Optional String browserVersion) {
		System.out.println("Before Test Started");
		prop = loadproperties();
		String browser = prop.getProperty("browser");

		log.info(browserName);
		log.info(browserVersion);

		if (browserName != null) {
			browser = browserName;
		}

		System.out.println(browser);
		driver =initializeDriver(browser, browserVersion);
		//String url = prop.getProperty("baseUrl");
		//driver.get(url);

		hmpg = new homePageObjects(driver);
		elu = new ElementUtils(driver);
		js = new JavaScriptExe(driver);
		lvp=new ListView_PageObjects(driver);
		reg=new RegistrationForm_pageObjects(driver);
		hdp=new homeDetails_PageObjects(driver);
		awp=new agentWebsite_pageObjects(driver);
		dsp= new directSignUp_pageObjects(driver);

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}

	public String getScreenshot(String TestCaseName) throws IOException {
		// driver=this.driver;
		String date = new SimpleDateFormat("ddMMyyyhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FILE_NAME = "Screenshot_" + TestCaseName + "_" + date + ".png";
		String destinationFile = OUTPUT_FOLDER + FILE_NAME;
		File destination = new File(destinationFile);
		FileUtils.copyFile(src, destination);
		return destinationFile;

	}
	
	public void launchingUrl(String brand, String ValidationUrl) {
		String baseURL = null;
		String AgentURL= null;
		//String baseURL=prop.getProperty("baseUrl");
		String CBbaseURL=prop.getProperty("CBbaseUrl");
		String ERAbaseURL=prop.getProperty("ERAbaseUrl");
		String C21baseURL=prop.getProperty("C21baseUrl");
		String BhgrebaseURL=prop.getProperty("BHGREbaseUrl");
		
		//Agents Websites URL
		String EraAgent="/ERA-Cornerstone-Realty-64c/Ben-Burnside-185667a";
		String CBAgent="/Coldwell-Banker-Best-Realty-7501c/William-Lee-325497a";
		String C21Agent="/CENTURY-21-Wright-%26-Assoc.-Inc.-368c/Keith-Wright-187248a";
		String BHGREAgent="/Better-Homes-and-Gardens-Real-Estate-Winans-3894c/Gary-Lewis-229770a";
		
		//String listViewUrl=prop.getProperty("baseUrl")+prop.getProperty("listViewURL");
		//String DetailPageURL=prop.getProperty("baseUrl")+prop.getProperty("DetailPageURL");
		//String logoutUrl= prop.getProperty("baseUrl")+prop.getProperty("logoutURL");
		//String newSignupUrl= prop.getProperty("baseUrl")+prop.getProperty("newSignupURL");
		if(brand.equalsIgnoreCase("era")) {
			baseURL=ERAbaseURL;
		}
		if(brand.equalsIgnoreCase("cb")) {
			baseURL=CBbaseURL;
		}
		if(brand.equalsIgnoreCase("c21")) {
			baseURL=C21baseURL;
		}
		if(brand.equalsIgnoreCase("bhgre")) {
			baseURL=BhgrebaseURL;
		}
		
		if(brand.equalsIgnoreCase("era")) {
			AgentURL=baseURL+EraAgent;
		}
		if(brand.equalsIgnoreCase("cb")) {
			AgentURL=baseURL+CBAgent;
		}
		if(brand.equalsIgnoreCase("c21")) {
			AgentURL=baseURL+C21Agent;
		}
		if(brand.equalsIgnoreCase("bhgre")) {
			AgentURL=baseURL+BHGREAgent;
		}
		
		
		String listViewUrl=baseURL+prop.getProperty("listViewURL");
		String DetailPageURL=baseURL+prop.getProperty("DetailPageURL");
		String newSignupUrl=baseURL+prop.getProperty("newSignupURL");
		//String logoutUrl=baseURL+prop.getProperty("logoutURL");
		
		if (ValidationUrl.equalsIgnoreCase("BaseUrl")) {
			driver.get(baseURL);
			log.info("Opened the Base URL"+ baseURL);
		}
		if (ValidationUrl.equalsIgnoreCase("listviewurl")) {
			driver.get(listViewUrl);
			log.info("Opened the List View"+listViewUrl);
		}
		if (ValidationUrl.equalsIgnoreCase("detailpage")) {
			driver.get(DetailPageURL);
			log.info("Open the Home Details Page"+DetailPageURL);
		} 
		if(ValidationUrl.equalsIgnoreCase("newsignuppage"))
		{
			driver.get(newSignupUrl);
			log.info("Open the SignUp url"+newSignupUrl);
		}
		if(ValidationUrl.equalsIgnoreCase("AgentWebsite")) {
			driver.get(AgentURL);
			log.info("Agent Website opned " +AgentURL);
		}
		
	}
	
	
	public void frames() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement frames=driver.findElement(By.cssSelector("iframe.modalfx-iframe"));
		driver.switchTo().frame(frames);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

}
