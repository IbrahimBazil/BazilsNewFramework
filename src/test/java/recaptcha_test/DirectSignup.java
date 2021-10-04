package recaptcha_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class DirectSignup extends BaseTest {

	private String Page = "newsignuppage";

	@Parameters({ "brand" })
	@BeforeMethod
	public void launchsite(@Optional String brandName) {

		String brand = prop.getProperty("brand");
		if (brandName != null) {
			brand = brandName;
		}
		launchingUrl(brand, Page);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void DirectSignupContact() {
		dsp.registerDirectSignup();
		log.info("Testing the Direct Signup");
	}
}
