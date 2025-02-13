package Demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAddToCartInCategories extends TestBase {
    @Test
    public void findAllAddToCartButtonsInCategories() {
        List<WebElement> allAddToCartButtons = new ArrayList<>();

        // Находим все категории
        List<WebElement> categoryLinks = driver.findElements(By.xpath("//ul[@class='top-menu']//a"));
        System.out.println("🔍 Найдено категорий: " + categoryLinks.size());

        // Перебираем категории
        for (WebElement category : categoryLinks) {
            String categoryName = category.getText();
            System.out.println("📂 Заходим в категорию: " + categoryName);
            category.click();

            // Ищем кнопки "Add to Cart" в категории
            List<WebElement> buttons = driver.findElements(By.xpath("//input[@value='Add to cart']"));
            allAddToCartButtons.addAll(buttons);
            System.out.println("🔍 В категории " + categoryName + " найдено кнопок: " + buttons.size());

            // Возвращаемся назад (на главную)
            driver.navigate().back();
        }

        System.out.println("✅ Всего найдено кнопок 'Add to Cart' во всех категориях: " + allAddToCartButtons.size());
    }
}
