package org.example.lesson_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SiteMtsSeleniumTests {
    String url = "https://www.mts.by/";
    String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//button[text()='Принять']")
    private WebElement acceptButton;
    @FindBy(xpath = "(//button[text()='Продолжить'])[1]")
    private WebElement continueButton;
    @FindBy(xpath = "//h2[text()='Онлайн пополнение ' and text()='без комиссии']")
    private WebElement headerTitle;
    @FindBy(xpath = "//ul//li//img[@alt='Visa']")
    private WebElement visaLogo;
    @FindBy(xpath = "//ul//li//img[@alt='Verified By Visa']")
    private WebElement verifiedByVisaLogo;
    @FindBy(xpath = "//ul//li//img[@alt='MasterCard']")
    private WebElement masterCardLogo;
    @FindBy(xpath = "//ul//li//img[@alt='MasterCard Secure Code']")
    private WebElement masterCardSecureCodeLogo;
    @FindBy(xpath = "//ul//li//img[@alt='Белкарт']")
    private WebElement belkartLogo;
    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement moreAboutService;
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;
    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement sumInput;
    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement emailInput;
    @FindBy(xpath = "//span[contains(text(),'Оплата: Услуги связи')]")
    private WebElement payCommunicationServices;
    @FindBy(xpath = "//span[contains(text(),'Номер:375297777777')]")
    private WebElement payNumber;


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


    @Test
    @DisplayName("Проверка названия указанного блока")
    public void assertNameOfTitle() {
        driver.get(url);
        acceptButton.click();
        scrollToElement(headerTitle);
        String actualText = headerTitle.getText();
        Assertions.assertAll(
                () -> Assertions.assertTrue(actualText.contains("Онлайн пополнение")),
                () -> Assertions.assertTrue(actualText.contains("без комиссии"))
        );
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void assertLogotypePaySystems() {
        driver.get(url);
        acceptButton.click();
        scrollToElement(headerTitle);
        // Проверяем логотипы с помощью нового метода
        checkElementVisibility(visaLogo, "Visa");
        checkElementVisibility(verifiedByVisaLogo, "Verified By Visa");
        checkElementVisibility(masterCardLogo, "MasterCard");
        checkElementVisibility(masterCardSecureCodeLogo, "MasterCard Secure Code");
        checkElementVisibility(belkartLogo, "Белкарт");
    }

    @Test
    @DisplayName("Проверить работу ссылки 'Подробнее о сервисе'")
    public void assertMoreAboutServiceLink() {
        driver.get(url);
        acceptButton.click();
        scrollToElement(headerTitle);
        checkElementVisibility(moreAboutService, "Ссылка подробнее о сервисе");
        clickAndVerifyLink(moreAboutService, expectedUrl);
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки 'Продолжить'")
    public void assertWorkByContinueButton() {
        driver.get(url);
        acceptButton.click();
        scrollToElement(headerTitle);

        checkElementVisibility(phoneNumberInput, "Поле номера телефона");
        checkElementVisibility(sumInput, "Поле суммы");
        checkElementVisibility(emailInput, "Поле email");
        checkElementVisibility(continueButton, "Кнопка Продолжить");

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys("297777777");

        sumInput.clear();
        sumInput.sendKeys("10");

        emailInput.clear();
        emailInput.sendKeys("test@example.com");

        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();

        // Жди iframe и переключайся на него
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOf(payCommunicationServices));
        wait.until(ExpectedConditions.visibilityOf(payNumber));

        String payComServText = payCommunicationServices.getText();
        String payNumberText = payNumber.getText();
        Assertions.assertAll(
                () -> Assertions.assertTrue(payComServText.contains("Оплата: Услуги связи"), "Текст 'Оплата: Услуги связи' не найден в модальном окне"),
                () -> Assertions.assertTrue(payNumberText.contains("Номер:375297777777"), "Номер '375297777777' не найден в модальном окне"));
    }

    public void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    private void checkElementVisibility(WebElement webElement, String elementName) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        scrollToElement(webElement);
        Assertions.assertTrue(webElement.isDisplayed(), "%s элемент не отображается".formatted(elementName));
    }

    private void clickAndVerifyLink(WebElement link, String expectedUrlPart) {
        wait.until(ExpectedConditions.elementToBeClickable(link));  // Ожидаем кликабельности
        String currentUrl = driver.getCurrentUrl();  // Запоминаем текущий URL
        link.click();  // Кликаем
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));  // Ждём изменения URL
        Assertions.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains(expectedUrlPart), "Ссылка не привела к ожидаемой странице");
    }
}
