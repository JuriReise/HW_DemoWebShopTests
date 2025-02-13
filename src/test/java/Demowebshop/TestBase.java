package Demowebshop;

import Demowebshop.core.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase extends ApplicationManager {
    protected WebDriver driver;
    protected TestData testData = new TestData();
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class); // 🔹 Добавляем логгер

    @BeforeMethod
    public void setUp() {
        logger.info("🟢 [SETUP] Инициализация WebDriver"); // Лог перед запуском WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        logger.info("🔗 [BROWSER] Открыт сайт Demowebshop");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("🛑 [TEARDOWN] Закрытие браузера"); // Лог перед закрытием браузера
            driver.quit();
        }
    }
}
