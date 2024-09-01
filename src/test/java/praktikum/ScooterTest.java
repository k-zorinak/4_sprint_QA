package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ScooterTest {
    private WebDriver driver;
    public DriverFactory factory = new DriverFactory();
    private String INVALID_ORDER_ID = "123";

    @Before
    public void initDriver() {
        factory.initDriver("firefox");
        driver = factory.getDriver();
    }

    @Test
    public void openMainPage() throws Exception {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnStatus();
        mainPage.enterOrderId(INVALID_ORDER_ID);
        mainPage.clickOnGo();
        mainPage.checkErrorImage();
    }

    @Test
    public void makeAnOrder() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnOrder();
        mainPage.indicateName("Панда");
        mainPage.indicateLastName("Мао");
        mainPage.indicateAddress("Москва");
        mainPage.indicateStation();
        mainPage.indicateNumber("89253453454");
        mainPage.clickOnButtonNext();
        mainPage.indicateDate();
        mainPage.chooseRentalPeriod();
        mainPage.chooseColor();
        mainPage.writeAComment("Комментарий");
        mainPage.finalOrder();
        mainPage.clickOnYesButton();
        String text = mainPage.checkIsOrderSuccess();
        assert text.contains("Заказ оформлен");
    }

    @Test
    public void makeAnOrderSecondButton() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickCloseCookie();
        mainPage.clickOrderMiddleButton();
        mainPage.indicateName("Котик");
        mainPage.indicateLastName("Бегемотик");
        mainPage.indicateAddress("Москва");
        mainPage.indicateStation();
        mainPage.indicateNumber("89090953400");
        mainPage.clickOnButtonNext();
        mainPage.indicateDate();
        mainPage.chooseRentalPeriod();
        mainPage.chooseColor();
        mainPage.writeAComment("Комментарий");
        mainPage.finalOrder();
        mainPage.clickOnYesButton();
        String text = mainPage.checkIsOrderSuccess();
        assert text.contains("Заказ оформлен");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}