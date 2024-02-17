package stepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;
import utilities.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	public LoginPage login;
	public static Logger log;
	public ReadConfig readConfig;

}
