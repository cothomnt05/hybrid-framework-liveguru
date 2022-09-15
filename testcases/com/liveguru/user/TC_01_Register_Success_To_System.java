package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.MyAccountPageObject;
import pageObjects.user.RegisterPageObject;

public class TC_01_Register_Success_To_System extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private String firstName, lastName, email, password;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePageObject(driver);
		firstName = "Automation";
		lastName = "FC";
		email = "automationfc" + generateFakeNumber() + "@gmail.com";
		password = "123123";
	}

	@Test
	public void User_01_Register_Success_To_System() {
		homePage.clickToAccountMenu();

		registerPage = homePage.openRegisterPage();

		Assert.assertTrue(registerPage.isRegisterPageDisplayed());

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		myAccountPage = registerPage.clickToRegisterButton();

		Assert.assertTrue(myAccountPage.isRegisterSuccessDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
