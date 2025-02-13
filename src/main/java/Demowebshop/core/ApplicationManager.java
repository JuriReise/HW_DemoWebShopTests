package Demowebshop.core;

import Demowebshop.fw.LoginHelper;
import Demowebshop.fw.CartHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    private WebDriver driver;
    private LoginHelper loginHelper;
    private CartHelper cartHelper;

    public void init() {
        driver = new ChromeDriver();
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
