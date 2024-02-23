package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver ldriver;

	public LogoutPage(WebDriver rDriver) {
		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id = "user-name")
	WebElement txtUsername;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "login-button")
	WebElement btnLogin;

	@FindBy(id = "react-burger-menu-btn")
	WebElement btnMenu;

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement btnLogout;

	public void enterUsername(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickOnLogin() {
		btnLogin.click();
	}

	public void clickOnMenu() {
		btnMenu.click();
	}

	public void clickOnLogout() {
		btnLogout.click();
	}

}
