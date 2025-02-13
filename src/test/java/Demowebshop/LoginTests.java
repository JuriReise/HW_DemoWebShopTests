package Demowebshop;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    @Description("Проверка успешного входа в систему с валидными учетными данными")
    public void testSuccessfulLogin() {
        logStep("🔑 Запуск теста: успешный вход в систему");

        String email = TestData.generateEmail(); // Используем тот же email, что и в регистрации

        logStep("Открываем страницу логина");
        driver.findElement(By.linkText("Log in")).click();

        logStep("Вводим email: " + email + " и пароль");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(TestData.password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        logStep("Проверяем, что вход выполнен успешно");
        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed(), "❌ Не удалось войти в систему!");

        logStep("✅ Вход выполнен успешно для email: " + email);
    }

    @Step("{0}")
    private void logStep(String step) {
        System.out.println(step);
    }
}
