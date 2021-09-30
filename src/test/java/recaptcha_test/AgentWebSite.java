package recaptcha_test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class AgentWebSite extends BaseTest {

	public String website = "AgentWebsite";

	@Parameters({ "brand" })
	@BeforeMethod
	public void launchAgentWebsite(@Optional String brandName) {

		String brand = prop.getProperty("brand");
		if (brandName != null) {
			brand = brandName;
		}
		launchingUrl(brand, website);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void contactAgent() {
		awp.clickContactAgent();
		reg.doRegistrationListView();
		if(reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			contactAgent();
		}
	}

}
