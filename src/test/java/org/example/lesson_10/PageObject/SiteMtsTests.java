package org.example.lesson_10.PageObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SiteMtsTests extends BaseTest  {


    private SiteMtsSeleniumPage siteMtsSeleniumPage;
    String url = "https://www.mts.by/";

    @BeforeEach
    public void beforeEach() {
        siteMtsSeleniumPage = new SiteMtsSeleniumPage(driver);  // Передаем driver в конструктор
    }


    @Test
    @DisplayName("Проверка названия указанного блока")
    public void assertNameOfTitle() {
        siteMtsSeleniumPage
                .goToPage(url)
                .checkBlockTitle();
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void assertLogotypePaySystems() {
        siteMtsSeleniumPage
                .goToPage(url)
                .checkLogo();
    }

    @Test
    @DisplayName("Проверить работу ссылки 'Подробнее о сервисе'")
    public void assertMoreAboutServiceLink() {
        siteMtsSeleniumPage
                .goToPage(url)
                .checkWorkLink();

    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки 'Продолжить' и надписи в незаполненных полях")
    public void assertWorkByContinueButton() {
        siteMtsSeleniumPage
                .goToPage(url)
                .checkСommunicationServicesForm()
                .setValuesСommunicationServicesForm()
                .switchToFrame()
                .checkIframeElementsIsVisible()
                .assertTextIframeElements();
    }

    @Test
    @DisplayName("Проверить надписи в незаполненных полях каждого варианта оплаты услуг")
    public void assertTextByBlankFields() throws InterruptedException {
        siteMtsSeleniumPage
                .goToPage(url)
                .checkInputByTextVisible();
    }
}
