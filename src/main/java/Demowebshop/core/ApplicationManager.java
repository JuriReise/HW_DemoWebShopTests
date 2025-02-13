package Demowebshop.core;

import Demowebshop.fw.LoginHelper;
import Demowebshop.fw.CartHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    private WebDriver driver;
    private LoginHelper loginHelper;
    private CartHelper cartHelper;

    public void init() {
        // Получаем параметр браузера из системных переменных
        String browser = System.getProperty("browser", "chrome"); // По умолчанию Chrome

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        loginHelper = new LoginHelper(driver);
        cartHelper = new CartHelper(driver);
        driver.get("https://demowebshop.tricentis.com/");
    }

    public void stop() {
        driver.quit();
    }

    public LoginHelper login() {
        return loginHelper;
    }

    public CartHelper cart() {
        return cartHelper;
    }
}
