package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddToCartPage;
import pageObject.FooterPage;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import pageObject.ProductPage;
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
		product = new ProductPage(driver);
		footer = new FooterPage(driver);
		add = new AddToCartPage(driver);
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

	/////////////////////// product feature////////////////////

	@Then("User should able to see product title label as {string}")
	public void user_should_able_to_see_product_title_label_as(String actLabelText) {
		WebElement productLabel = driver.findElement(
				By.xpath("//div[@id='header_container']/child::div[@class='header_secondary_container']/span"));
		String expLabelText = productLabel.getText();
		if (actLabelText.equalsIgnoreCase(expLabelText)) {
			log.warn("Test Passed:product label is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:product label is not matched....");
			Assert.assertTrue(false);
		}
	}

	@Then("User should able to see product sort option")
	public void user_should_able_to_see_product_sort_option() {

		WebElement productSort = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		if (productSort.isDisplayed()) {
			log.warn("Test Passed:product sort option is displayed....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:product sort option is not displayed....");
			Assert.assertTrue(false);

		}
	}

	@Then("User should able to see all inventory items correctly")
	public void user_should_able_to_see_all_inventory_items_correctly() {
		List<WebElement> items = product.InventoryItem();
		String[] itemDetailNames = { "name", "description", "price", "button text" };
		String[] itemDetailsRecieved;
		String[][] itemDetailsCorrect = { { "Sauce Labs Backpack",
				"Carry all the things with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
				"$29.99", "Add to cart" },
				{ "Sauce Labs Bike Light",
						"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
						"$9.99", "Add to cart" },
				{ "Sauce Labs Bolt T-Shirt",
						"Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
						"$15.99", "Add to cart" },
				{ "Sauce Labs Fleece Jacket",
						"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
						"$49.99", "Add to cart" },
				{ "Sauce Labs Onesie",
						"Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
						"$7.99", "Add to cart" },
				{ "Sauce Labs T-Shirt (Red)",
						"This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.",
						"$15.99", "Add to cart" }, };
		System.out.println("Number of product items :" + items.size());

		for (int i = 0; i <= 5; i++) {

			itemDetailsRecieved = items.get(i).getText().split("\\R");

			for (int j = 0; j <= 3; j++) {

				if (itemDetailsCorrect[i][j].equals(itemDetailsRecieved[j])) {

					System.out.println(
							"Product " + (i + 1) + " " + itemDetailNames[j] + " is correct: " + itemDetailsRecieved[j]);
				} else {

					System.out.println("Product " + (i + 1) + " " + itemDetailNames[j] + " is wrong: " + "Received --> "
							+ itemDetailsRecieved[j] + " Expected --> " + itemDetailsCorrect[i][j]);
				}
			}
		}
	}

	@Then("User should see the ZA sorted products")
	public void user_should_see_the_za_sorted_products() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		for (WebElement productNames : allProducts) {
			System.out.println(productNames.getText());
		}

		WebElement drpNames = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

		Select sel = new Select(drpNames);
		sel.selectByValue("za");

		List<WebElement> allProductsAfterSort = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));

		for (WebElement sortProductNames : allProductsAfterSort) {
			System.out.println("After sorting " + sortProductNames.getText());
		}
		if (allProducts.equals(allProductsAfterSort)) {
			log.warn("Test Passed:product is sorted as per the selection....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:product is not sorted as per the selection....");
			Assert.assertTrue(false);

		}

	}

	@Then("User should see the low to high sorted products")
	public void user_should_see_the_low_to_high_sorted_products() {
		List<WebElement> allProductsPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for (WebElement productPrice : allProductsPrice) {
			System.out.println(productPrice.getText());
		}

		WebElement drpNames = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

		Select sel = new Select(drpNames);
		sel.selectByValue("lohi");

		List<WebElement> allProductsPricesAfterSort = driver
				.findElements(By.xpath("//div[@class='inventory_item_name ']"));

		for (WebElement sortProductPrices : allProductsPricesAfterSort) {
			System.out.println("After sorting " + sortProductPrices.getText());
		}
		if (allProductsPrice.equals(allProductsPricesAfterSort)) {
			log.warn("Test Passed:product price is sorted as per the selection....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:product price is not sorted as per the selection....");
			Assert.assertTrue(false);

		}

	}

	@Then("User should see the high to low sorted products")
	public void user_should_see_the_high_to_low_sorted_products() {

		List<WebElement> allProductsPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for (WebElement productPrice : allProductsPrice) {
			System.out.println(productPrice.getText());
		}

		WebElement drpNames = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

		Select sel = new Select(drpNames);
		sel.selectByValue("hilo");

		List<WebElement> allProductsPricesAfterSort = driver
				.findElements(By.xpath("//div[@class='inventory_item_name ']"));

		for (WebElement sortProductPrices : allProductsPricesAfterSort) {
			System.out.println("After sorting " + sortProductPrices.getText());
		}
		if (allProductsPrice.equals(allProductsPricesAfterSort)) {
			log.warn("Test Passed:product price is sorted as per the selection....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:product price is not sorted as per the selection....");
			Assert.assertTrue(false);

		}

	}

	@Then("User should see the correct products images")
	public void user_should_see_the_correct_products_images() {

		String[] imgSrcNames = { "sauce-backpack", "bike-light", "bolt-shirt", "sauce-pullover", "red-onesie",
				"red-tatt" };

		int j = 1;
		for (int i = 1; i <= 12; i += 2) {
			String imgsrc = product.ItemImg().get(i).getAttribute("src").toString();

			if (imgsrc.contains(imgSrcNames[i - j])) {
				System.out.println("Image is correct : " + imgSrcNames[i - j]);
			}

			else {
				System.out.println("Image source is wrong : " + imgsrc);
			}
			j++;
		}

	}

	////////////////////// footer functionality//////////////////////////

	@Then("User should see the footer")
	public void user_should_see_the_footer() {

		if (footer.validateFooterSection()) {
			log.warn("Test Passed:footer section is displayed....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:footer section is not displayed....");
			Assert.assertTrue(false);

		}
	}

	@Then("User should see the footer text as {string}")
	public void user_should_see_the_footer_text_as(String actText) {
		WebElement footerText = driver.findElement(By.xpath("//footer[@class='footer']/child::div"));
		String expText = footerText.getText();
		if (actText.equalsIgnoreCase(expText)) {
			log.warn("Test Passed:footer text is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:footer text is not matched....");
			Assert.assertTrue(false);
		}
	}

	@When("click on twitter")
	public void click_on_twitter() throws InterruptedException {

		footer.clickOnTwitter();
		Thread.sleep(3000);

	}

	@Then("User should navigate to swag labs twitter page")
	public void user_should_navigate_to_swag_labs_twitter_page() {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));
		String twitterpageName = footer.TwitterPage().getAttribute("innerText");
		if (twitterpageName.equals("Sauce Labs")) {

			System.out.println("Navigated to twitter page");
		} else {
			System.out.println("Not Navigated to twitter page");
		}

	}

	@When("click on facebook")
	public void click_on_facebook() {
		footer.clickOnFacebook();

	}

	@Then("User should navigate to swag labs Facebook page")
	public void user_should_navigate_to_swag_labs_facebook_page() {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));

		WebElement closeButton = driver.findElement(By.xpath("//div[@role='dialog']//i"));
		closeButton.click();

		String fbpageName = footer.FacebookPage().getAttribute("innerText");

		if (fbpageName.equals("Sauce Labs")) {

			System.out.println("Navigated to facebook page");
		}

		else {

			System.out.println("Not Navigated to facebook page");
		}

	}

	@When("click on linkedin")
	public void click_on_linkedin() {

		footer.clickOnLinkedin();

	}

	@Then("User should navigate to swag labs LinkedIn page")
	public void user_should_navigate_to_swag_labs_linked_in_page() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));

		String linkedInPageName = footer.LinkedinPage().getAttribute("innerText");

		if (linkedInPageName.equals("Sauce Labs")) {

			System.out.println("Navigated to linkedIn page");
		}

		else {

			System.out.println("Not Navigated to linkedIn page");
		}
	}

	///////////////////////// Add To Cart/////////////////////////////////

	@When("click on add to cart")
	public void click_on_add_to_cart() {
		add.clickOnAddToCart();
	}

	@Then("User should see the updated cart badge")
	public void user_should_see_the_updated_cart_badge() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File(
				"C:\\Users\\piyush ramteke\\Piyush-Workspace\\SwagLabs_Cucumber\\Screenshots\\add_to_cart.png");
		FileUtils.copyFile(src, Dest);
	}

	@Then("User should see the remove buttons")
	public void user_should_see_the_remove_buttons() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\piyush ramteke\\Piyush-Workspace\\SwagLabs_Cucumber\\Screenshots\\remove.png");
		FileUtils.copyFile(src, Dest);

	}

	@When("click on product")
	public void click_on_product() {
		add.clickOnSauceLabs();
	}

	@Then("User should see the full product view")
	public void user_should_see_the_full_product_view() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File(
				"C:\\Users\\piyush ramteke\\Piyush-Workspace\\SwagLabs_Cucumber\\Screenshots\\fullproductview.png");
		FileUtils.copyFile(src, Dest);

	}

	@When("click on cart")
	public void click_on_cart() {
		add.clickOnCart();

	}

	@Then("User should see the cart items added to cart")
	public void user_should_see_the_cart_items_added_to_cart() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\piyush ramteke\\Piyush-Workspace\\SwagLabs_Cucumber\\Screenshots\\cart.png");
		FileUtils.copyFile(src, Dest);

	}

	@When("click on remove")
	public void click_on_remove() {
		add.clickOnRemove();
	}

	@Then("User should see the cart without removed item")
	public void user_should_see_the_cart_without_removed_item() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File(
				"C:\\Users\\piyush ramteke\\Piyush-Workspace\\SwagLabs_Cucumber\\Screenshots\\cartafterremove.png");
		FileUtils.copyFile(src, Dest);

	}

	@When("click on Back To Products")
	public void click_on_back_to_products() {

		add.clickOnBackToProducts();

	}

	@Then("User should see the product page and URL should be {string}")
	public void user_should_see_the_product_page_and_url_should_be(String actURL) {

		String expURL = driver.getCurrentUrl();
		if (actURL.equalsIgnoreCase(expURL)) {
			log.warn("Test Passed:product page URL is matched....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:product page URL is not matched....");
			Assert.assertTrue(false);
		}

	}

	@When("click on continue shopping")
	public void click_on_continue_shopping() {
		add.clickOnContinueShopping();
	}

	@When("click on checkout")
	public void click_on_checkout() {
		add.clickOnCheckout();
	}

	@Then("User should see the checkout info page and URL should be {string}")
	public void user_should_see_the_checkout_info_page_and_url_should_be(String actURL) {

		String expURL = driver.getCurrentUrl();
		if (actURL.equalsIgnoreCase(expURL)) {
			log.warn("Test Passed:Navigated successfully to checkout page ....");
			Assert.assertTrue(true);
		} else {
			log.warn("Test Failed:checkout page is not visible....");
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
