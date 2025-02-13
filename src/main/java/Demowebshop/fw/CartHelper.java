package Demowebshop.fw;

import Demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper {

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart(String itemName) {
        click(By.linkText(itemName));
        click(By.id("add-to-cart-button-4"));
    }
}
