package C21Recaptcha_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomeDetailsPageC21 extends BaseTest {

	private String Page = "detailpage";

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

	@Test(priority = 2)
	public void SaveHomeInDetailsPageC21() {
		hdp.ClickSaveBtn();
		reg.doRegistrationListViewc21();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			SaveHomeInDetailsPageC21();
		}
	}

	@Test(priority = 1)
	public void RequestShowingC21() {
		hdp.ClickRequestShowingbtn();
		reg.doRegistrationListViewc21();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Request Showing");
		} else {
			RequestShowingC21();
		}
	}

	@Test(priority = 3)
	public void RequestMoreInfoC21() {
		hdp.ClickRequestMoreInfobtn();
		reg.doRegistrationListViewc21();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Request More Info");
		} else {
			RequestMoreInfoC21();
		}
	}

	@Test(priority = 4)
	public void GoSeeThisHomeC21() {
		hdp.Clickgoseethishomebtn();
		reg.doRegistrationListViewc21();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Go See This Home");
		} else {
			GoSeeThisHomeC21();
		}
	}

	@Test(priority = 5)
	public void TourThisHomeInHDC21() {
		reg.doRegistrationinTourThisHomeHDC21();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Go See This Home");
		} else {
			TourThisHomeInHDC21();
		}
	}
}