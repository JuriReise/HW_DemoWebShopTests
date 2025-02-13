package Demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

public class CreateAccountTests extends TestBase {

    @Test
    public void testCreateNewAccount() {
        System.out.println("📝 Запуск теста: создание нового аккаунта");

        String email = TestData.generateEmail(); // Генерируем email и сохраняем в TestData

        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("User");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(TestData.password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(TestData.password);
        driver.findElement(By.id("register-button")).click();

        String confirmationText = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(confirmationText, "Your registration completed");

        System.out.println("✅ Регистрация успешна для email: " + email);
    }
}
