package Demowebshop.fw;

import Demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends BaseHelper {

    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(By.linkText("Log in"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input[value='Log in']"));
    }
}
