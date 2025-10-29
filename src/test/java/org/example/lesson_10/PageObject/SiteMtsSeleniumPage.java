package org.example.lesson_10.PageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SiteMtsSeleniumPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Конструктор принимает driver
    public SiteMtsSeleniumPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    // Базовый локатор для сервисов
    private static final String SERVICE_XPATH = "//li//p[text()='%s']";
    String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
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
    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    private WebElement phoneNumberByUserInput;
    @FindBy(xpath = "//input[@placeholder='Номер счета на 44']")
    private WebElement accNumber44Input;
    @FindBy(xpath = "//input[@placeholder='Номер счета на 2073']")
    private WebElement accNumber2073Input;
    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement sumInput;
    @FindBy(xpath = "(//input[@placeholder='Сумма'])[1]")
    private WebElement sumComServInput;
    @FindBy(xpath = "(//input[@placeholder='Сумма'])[2]")
    private WebElement sumHomeNetInput;
    @FindBy(xpath = "(//input[@placeholder='Сумма'])[3]")
    private WebElement sumInsallmentInput;
    @FindBy(xpath = "(//input[@placeholder='Сумма'])[4]")
    private WebElement sumDebtInput;
    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement emailInput;
    @FindBy(xpath = "(//input[@placeholder='E-mail для отправки чека'])[1]")
    private WebElement emailComServInput;
    @FindBy(xpath = "(//input[@placeholder='E-mail для отправки чека'])[2]")
    private WebElement emailHomeNetInput;
    @FindBy(xpath = "(//input[@placeholder='E-mail для отправки чека'])[3]")
    private WebElement emailInstallmentInput;
    @FindBy(xpath = "(//input[@placeholder='E-mail для отправки чека'])[4]")
    private WebElement emailDebtInput;
    @FindBy(xpath = "//span[contains(text(),'Оплата: Услуги связи')]")
    private WebElement payCommunicationServices;
    @FindBy(xpath = "//span[contains(text(),'Номер:375297777777')]")
    private WebElement payNumber;
    @FindBy(xpath = "//span[@class='select__arrow']")
    private WebElement payServicesSelect;
    @FindBy(xpath = "//label[text()='Имя и фамилия на карте']")
    private WebElement nameOnCard;
    @FindBy(xpath = "//label[text()='Номер карты']")
    private WebElement cardNumber;
    @FindBy(xpath = "//label[text()='Срок действия']")
    private WebElement validityPeriod;
    @FindBy(xpath = "//label[text()='CVC']")
    private WebElement cvcNumber;
    @FindBy(xpath = "(//span[contains(text(),'Оплатить')])[1]")
    private WebElement submitButton;


    public SiteMtsSeleniumPage goToPage(String url) {
        driver.get(url);
        acceptButton.click();
        scrollToElement(headerTitle);
        return this;
    }

    public SiteMtsSeleniumPage selectService() {
        payServicesSelect.click();
        return this;
    }


    public SiteMtsSeleniumPage chooseAndClickSelectService(String service) throws InterruptedException {

        // Формируем динамический xpath
        String dynamicXpath = SERVICE_XPATH.formatted(service);
        // Находим и кликаем элемент
        WebElement serviceElement = driver.findElement(By.xpath(dynamicXpath));
        wait.until(ExpectedConditions.elementToBeClickable(serviceElement));
        serviceElement.click();
        Thread.sleep(500);
        return this;
    }

    public void checkInputByTextVisible() throws InterruptedException {
        checkElementVisibility(phoneNumberInput, "Номер телефона")
                .checkElementVisibility(sumComServInput, "Сумма")
                .checkElementVisibility(emailComServInput, "email")
                .selectService()
                .chooseAndClickSelectService("Домашний интернет")
                .checkElementVisibility(phoneNumberByUserInput, "Номер абонента")
                .checkElementVisibility(sumHomeNetInput, "Сумма")
                .checkElementVisibility(emailHomeNetInput, "email")
                .selectService()
                .chooseAndClickSelectService("Рассрочка")
                .checkElementVisibility(accNumber44Input, "Номер счета на 44")
                .checkElementVisibility(sumInsallmentInput, "Сумма")
                .checkElementVisibility(emailInstallmentInput, "email")
                .selectService()
                .chooseAndClickSelectService("Задолженность")
                .checkElementVisibility(accNumber2073Input, "Номер счета на 2073")
                .checkElementVisibility(sumDebtInput, "Сумма")
                .checkElementVisibility(emailDebtInput, "email");
    }


    public void checkBlockTitle() {
        String actualText = headerTitle.getText();
        Assertions.assertAll(
                () -> Assertions.assertTrue(actualText.contains("Онлайн пополнение")),
                () -> Assertions.assertTrue(actualText.contains("без комиссии"))
        );
    }

    public void checkWorkLink() {
        checkElementVisibility(moreAboutService, "Ссылка подробнее о сервисе");
        clickAndVerifyLink(moreAboutService, expectedUrl);
    }

    public void checkLogo() {
        checkElementVisibility(visaLogo, "Visa");
        checkElementVisibility(verifiedByVisaLogo, "Verified By Visa");
        checkElementVisibility(masterCardLogo, "MasterCard");
        checkElementVisibility(masterCardSecureCodeLogo, "MasterCard Secure Code");
        checkElementVisibility(belkartLogo, "Белкарт");
    }

    public SiteMtsSeleniumPage checkСommunicationServicesForm() {
        checkElementVisibility(phoneNumberInput, "Поле номера телефона");
        checkElementVisibility(sumInput, "Поле суммы");
        checkElementVisibility(emailInput, "Поле email");
        checkElementVisibility(continueButton, "Кнопка Продолжить");
        return this;
    }

    public SiteMtsSeleniumPage checkIframeElementsIsVisible() {
        checkElementVisibility(payCommunicationServices, "Оплата: Услуги связи");
        checkElementVisibility(payNumber, "Номер:375297777777");
        return this;
    }

    public SiteMtsSeleniumPage setValuesСommunicationServicesForm() {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys("297777777");

        sumInput.clear();
        sumInput.sendKeys("10");

        emailInput.clear();
        emailInput.sendKeys("test@example.com");

        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        return this;
    }
    public SiteMtsSeleniumPage switchToFrame() {
        // Жди iframe и переключайся на него
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(iframe);
        return this;
    }

    public void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    protected SiteMtsSeleniumPage checkElementVisibility(WebElement webElement, String elementName) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        scrollToElement(webElement);
        Assertions.assertTrue(webElement.isDisplayed(), "%s элемент не отображается".formatted(elementName));
        return this;
    }

    protected void clickAndVerifyLink(WebElement link, String expectedUrlPart) {
        wait.until(ExpectedConditions.elementToBeClickable(link));  // Ожидаем кликабельности
        String currentUrl = driver.getCurrentUrl();  // Запоминаем текущий URL
        link.click();  // Кликаем
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));  // Ждём изменения URL
        Assertions.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains(expectedUrlPart), "Ссылка не привела к ожидаемой странице");
    }

    public void assertTextIframeElements() {
        String payComServText = payCommunicationServices.getText();
        String payNumberText = payNumber.getText();
        double paySum = 10.00;
        String submitButtonText = submitButton.getText();
        Assertions.assertAll(
                () -> Assertions.assertTrue(payComServText.contains("Оплата: Услуги связи"), "Текст 'Оплата: Услуги связи' не найден в модальном окне"),
                () -> Assertions.assertTrue(payNumberText.contains("Номер:375297777777"), "Номер '375297777777' не найден в модальном окне"),
                () -> Assertions.assertTrue(submitButtonText.contains(Double.toString(paySum)), "Текст кнопки не содержит искомую сумму"),
                () -> checkElementVisibility(nameOnCard, "Имя и Фамилия"),
                () -> checkElementVisibility(validityPeriod, "Период действия карты"),
                () -> checkElementVisibility(cardNumber, "Номер карты"),
                () -> checkElementVisibility(cvcNumber,"CVС"));
    }
}
