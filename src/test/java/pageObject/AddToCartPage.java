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

	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item_label']/a[@id='item_4_title_link']")
	private WebElement sauceLabs;

	@FindBy(xpath = "//div[@id='shopping_cart_container']/a")
	private WebElement cart;

	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	private WebElement btnRemove;

	public void clickOnAddToCart() {
		btnAddToCart.click();
	}

	public void clickOnSauceLabs() {
		sauceLabs.click();
	}

	public void clickOnCart() {
		cart.click();
	}

	public void clickOnRemove() {
		btnRemove.click();
	}

}
