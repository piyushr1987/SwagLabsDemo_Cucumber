package stepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import utilities.ReadConfig;

public class StepDef extends BaseClass {

	@Before()
	public void setUp() throws IOException {

		readConfig = new ReadConfig();

		// Initialize logger
		log = LogManager.getLogger("StepDef");
		System.out.println("Set up method is executed");

		String browser = readConfig.getBrowser();
		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		login = new LoginPage(driver);
	}

	@When("user open the URL {string}")
	public void user_open_the_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		log.info("url is opened");
	}

	@When("user enter the username as {string} and password as {string}")
	public void user_enter_the_username_as_and_password_as(String user, String password) {

		login.enterUsername(user);
		login.enterPassword(password);
		log.info("email and password is entered");

	}

	@When("click on login")
	public void click_on_login() {
		login.clickOnLogin();
		log.info("login button clicked");
	}

	@Then("User should navigate to Swag labs home page and URL should be {string}.")
	public void user_should_navigate_to_swag_labs_home_page_and_url_should_be(String actURL) {

		String expURL = driver.getCurrentUrl();
		if (actURL.equalsIgnoreCase(expURL)) {
			log.warn("Test Passed:home page url is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:home page url is not matched....");
			Assert.assertTrue(false);
		}
	}

	@Then("close the browser")
	public void close_the_browser() {

		driver.close();
		// driver.quit();

		log.info("browser is closed");

	}

}
