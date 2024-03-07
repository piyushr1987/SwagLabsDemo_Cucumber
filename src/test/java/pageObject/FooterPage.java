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

	public boolean validateFooterSection() {
		return footer.isDisplayed();

	}

	public void clickOnTwitter() {
		twitter.click();
	}

	public WebElement TwitterPage() {
		By twitterPage = By.xpath(
				"//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[1]/div/div/div/div/div/div[2]/div/h2/div/div/div/div/span[1]/span/span[1]");
		return ldriver.findElement(twitterPage);

	}
}
