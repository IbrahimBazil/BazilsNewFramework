package recaptcha_test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomeDetailsPage extends BaseTest {

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
	public void SaveHomeInDetailsPage() {
		hdp.ClickSaveBtn();
		reg.doRegistrationListView();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed");
		} else {
			SaveHomeInDetailsPage();
		}
	}

	@Test(priority = 1)
	public void RequestShowing() {
		hdp.ClickRequestShowingbtn();
		reg.doRegistrationWithPhone();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Request Showing");
		} else {
			RequestShowing();
		}
	}

	@Test(priority = 3)
	public void RequestMoreInfo() {
		hdp.ClickRequestMoreInfobtn();
		reg.doRegistrationWithPhone();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Request More Info");
		} else {
			RequestMoreInfo();
		}
	}

	@Test(priority = 4)
	public void GoSeeThisHome() {
		hdp.Clickgoseethishomebtn();
		reg.doRegistrationWithPhone();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Go See This Home");
		} else {
			GoSeeThisHome();
		}
	}

	@Test(priority = 5)
	public void TourThisHomeInHD() {
		reg.doRegistrationinTourThisHomeHD();
		if (reg.captchaDisplayed()) {
			log.info("Captcha is Displayed in Go See This Home");
		} else {
			GoSeeThisHome();
		}
	}

}
