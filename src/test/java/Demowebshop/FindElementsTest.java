package Demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest extends TestBase {

    @Test
    public void findTenElementsTest() {
        System.out.println("🔍 Ищем 10 различных элементов на странице...");

        // 1. Логотип сайта
        WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']//a"));
        System.out.println("🌍 Логотип: " + logo.getAttribute("href"));

        // 2. Поле поиска
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("🔍 Поле поиска найдено");

        // 3. Кнопка поиска
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Search']"));
        System.out.println("🖱️ Кнопка поиска: " + searchButton.getAttribute("value"));

        // 4. Один из пунктов меню
        WebElement menuItem = driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space(.)!='']"));
        System.out.println("📄 Пункт меню: " + menuItem.getText());

        // 5. Название одного из товаров
        WebElement productTitle = driver.findElement(By.xpath("//h2[@class='product-title']/a"));
        System.out.println("📦 Товар: " + productTitle.getText());

        // 6. Цена этого товара (если найдётся)
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='prices']//span[@class='price']"));
        if (!productPrices.isEmpty()) {
            System.out.println("💵 Цена товара: " + productPrices.get(0).getText());
        } else {
            System.out.println("❌ Цена товара не найдена");
        }

        // 7. Кнопка "Add to Cart"
        WebElement addToCartButton = driver.findElement(By.xpath("//input[contains(@class, 'add-to-cart-button')]"));
        System.out.println("🛒 Кнопка 'Add to Cart' найдена");

        // 8. Ссылка на регистрацию
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(@href, '/register')]"));
        System.out.println("📝 Ссылка на регистрацию: " + registerLink.getText());

        // 9. Ссылка на корзину
        WebElement cartLink = driver.findElement(By.xpath("//a[contains(@href, '/cart')]"));
        System.out.println("🛍️ Ссылка на корзину: " + cartLink.getText());

        // 10. Ссылка на контактную страницу
        WebElement contactLink = driver.findElement(By.xpath("//a[contains(@href, '/contactus')]"));
        System.out.println("📞 Ссылка на контактную страницу: " + contactLink.getText());
    }
}
