package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

	WebDriver ldriver;

	public FooterPage(WebDriver rDriver) {
		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//footer[@class='footer']")
	private WebElement footer;

	@FindBy(xpath = "//footer[@class='footer']/child::ul//a[text()='Twitter']")
	private WebElement twitter;

	@FindBy(xpath = "//footer[@class='footer']/child::ul//a[text()='Facebook']")
	private WebElement facebook;
	
	@FindBy(xpath = "//footer[@class='footer']/child::ul//a[text()='LinkedIn']")
	private WebElement linkedin;

	public boolean validateFooterSection() {
		return footer.isDisplayed();

	}

	public void clickOnTwitter() {
		twitter.click();
	}

	public void clickOnFacebook() {
		facebook.click();
	}
	
	public void clickOnLinkedin() {
		linkedin.click();
	}

	public WebElement TwitterPage() {
		By twitterPage = By.xpath(
				"//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[1]/div/div/div/div/div/div[2]/div/h2/div/div/div/div/span[1]/span/span[1]");
		return ldriver.findElement(twitterPage);

	}

	public WebElement FacebookPage() {
		By fbPage = By.xpath("//html[@id='facebook']");
		return ldriver.findElement(fbPage);
	}

	public WebElement LinkedinPage() {
		By linkedInPage = By.xpath("/html/body/main/section[1]/section/div/div[2]/div[1]/h1");
		return ldriver.findElement(linkedInPage);
	}
}
