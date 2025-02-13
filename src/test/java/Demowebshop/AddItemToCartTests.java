package Demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class AddItemToCartTests extends TestBase {

    @Test
    public void testAddItemToCart() {
        System.out.println("🛒 Запуск теста: добавление товара в корзину");

        // 🔹 Предусловие: залогиниться
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(TestData.email);
        driver.findElement(By.id("Password")).sendKeys(TestData.password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        // 🔹 Найти все товары на главной странице
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
        Assert.assertTrue(products.size() > 1, "❌ Недостаточно товаров на главной странице!");

        // 🔹 Выбрать 2-й товар и кликнуть "Add to cart"
        WebElement secondProduct = products.get(1);
        WebElement addToCartButton = secondProduct.findElement(By.cssSelector("input[value='Add to cart']"));
        addToCartButton.click();
        System.out.println("✅ Второй товар добавлен в корзину");

        // 🔹 Проверить, что товар появился в корзине (по тексту)
        WebElement cartLink = driver.findElement(By.linkText("Shopping cart"));
        cartLink.click();

        WebElement cartContent = driver.findElement(By.cssSelector(".cart-item-row"));
        Assert.assertTrue(cartContent.isDisplayed(), "❌ Товар не был добавлен в корзину!");

        System.out.println("🎉 Тест успешен! Товар есть в корзине.");
    }
}
