package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	WebDriver ldriver;

	public AddToCartPage(WebDriver rDriver) {
		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_list']/div[1]//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement btnAddToCart;

	public void clickOnAddToCart() {
		btnAddToCart.click();
	}

}
