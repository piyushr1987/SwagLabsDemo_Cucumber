package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver ldriver;

	public ProductPage(WebDriver rDriver) {
		ldriver = rDriver;

		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_list']/div[@class='inventory_item']")
	List<WebElement> inventoryItems;

	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	List<WebElement> productLabels;

	public List<WebElement> InventoryItem() {

		return inventoryItems;
	}

	public List<WebElement> allProducts() {

		return productLabels;
	}

	public List<WebElement> ItemImg() {
		return ldriver.findElements(By.className("inventory_item_img"));
	}

}
