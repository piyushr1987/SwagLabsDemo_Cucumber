package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.LogoutPage;
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
		logout = new LogoutPage(driver);
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

	@Then("User should see the correct error message as {string}.")
	public void user_should_see_the_correct_error_message_as(String actErrorMessage) {

		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='login-box']/descendant::h3"));
		String expErrorMessage = errorMessage.getText();
		if (actErrorMessage.equalsIgnoreCase(expErrorMessage)) {
			log.warn("Test Passed:login page error message is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:login page error message is not matched....");
			Assert.assertTrue(false);
		}
	}

	@Then("User should see the correct error message for password field as {string}")
	public void user_should_see_the_correct_error_message_for_password_field_as(String actErrorMessage) {

		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='login-box']/descendant::h3"));
		String expErrorMessage = errorMessage.getText();
		if (actErrorMessage.equalsIgnoreCase(expErrorMessage)) {
			log.warn("Test Passed:login page error message is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:login page error message is not matched....");
			Assert.assertTrue(false);
		}

	}

	@Then("User should see the correct error message while entering wrong username as {string}")
	public void user_should_see_the_correct_error_message_while_entering_wrong_username_as(String actErrorMessage) {
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='login-box']/descendant::h3"));
		String expErrorMessage = errorMessage.getText();
		if (actErrorMessage.equalsIgnoreCase(expErrorMessage)) {
			log.warn("Test Passed:login page error message is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:login page error message is not matched....");
			Assert.assertTrue(false);
		}
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
	////////////////////////// logout functionality///////////////////////////////

	@When("user click on menu")
	public void user_click_on_menu() {
		logout.clickOnMenu();
	}

	@When("click on logout")
	public void click_on_logout() {
		logout.clickOnLogout();
	}

	@Then("User should navigate to Swag labs login page and company name should be {string}")
	public void user_should_navigate_to_swag_labs_login_page_and_company_name_should_be(String actCompanyName) {
		WebElement companyName = driver.findElement(By.xpath("//div[@id='root']//div[@class='login_logo']"));
		String expCompanyName = companyName.getText();
		if (actCompanyName.equalsIgnoreCase(expCompanyName)) {
			log.warn("Test Passed:Company name is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:Company name is not matched....");
			Assert.assertTrue(false);
		}
	}

	@After()
	public void tearDown(Scenario sc) {
		System.out.println("Tear down method is executed");
		if (sc.isFailed() == true) {
			String fileWithPath = "C:\\Users\\piyush ramteke\\Piyush-Workspace\\SwagLabs_Cucumber\\Screenshots\\failedScreenshot.png";
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			// Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		driver.quit();
	}

	@Then("close the browser")
	public void close_the_browser() {

		driver.quit();
		log.info("browser is closed");

	}

}
