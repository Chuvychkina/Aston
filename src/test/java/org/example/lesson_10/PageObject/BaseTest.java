package org.example.lesson_10.PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Автоматическая настройка chromedriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Максимизируем окно браузера (полный экран в рамках ОС)
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));  // Инициализируем wait

        // Обязательно: Инициализируем элементы с @FindBy
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
