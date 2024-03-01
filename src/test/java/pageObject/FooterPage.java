package pageObject;

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

	public boolean validateFooterSection() {
		return footer.isDisplayed();

	}

}
