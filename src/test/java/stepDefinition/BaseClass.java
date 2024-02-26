package stepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;
import pageObject.LogoutPage;
import pageObject.ProductPage;
import utilities.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	public LoginPage login;
	public LogoutPage logout;
	public ProductPage product;
	public static Logger log;
	public ReadConfig readConfig;

}
