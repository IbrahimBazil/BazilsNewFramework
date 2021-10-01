package C21Recaptcha_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class ListViewC21 extends BaseTest {

	private String Page = "listviewurl";

	@Parameters({"brand"})
	@BeforeMethod
	public void launchsite(@Optional String brandName) {
		
		String brand=prop.getProperty("brand");
		if(brandName != null) {
			brand=brandName;
		}
		launchingUrl(brand,Page);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void saveSearchListViewC21() {
		lvp.clickSaveSearch();
		reg.doRegistrationListViewc21();
		if(reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			saveSearchListViewC21();
		}
	}
	
	@Test(priority=2)
	public void HeartIconinListViewC21() {
		lvp.clickHeartIconInListView();
		reg.doRegistrationListViewc21();
		if(reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			HeartIconinListViewC21();
		}
	}
	

}
