package C21Recaptcha_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class AgentWebSiteC21 extends BaseTest {

	private String Page = "AgentWebsite";

	@Parameters({ "brand" })
	@BeforeMethod
	public void launchsite(@Optional String brandName) {

		String brand = prop.getProperty("brand");
		if (brandName != null) {
			brand = brandName;
		}
		launchingUrl(brand, Page);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void contactAgentC21() {
		
		awp.clickContactAgent();
		reg.doRegistrationListViewc21();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			contactAgentC21();
		}
	}

}
