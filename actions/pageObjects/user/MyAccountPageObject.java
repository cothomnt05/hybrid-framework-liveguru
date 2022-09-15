package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.user.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterSuccessDisplayed() {
		return isElementDisplayed(driver, MyAccountPageUI.REGISTER_SUCCESS_MESSAGE);

	}
}
