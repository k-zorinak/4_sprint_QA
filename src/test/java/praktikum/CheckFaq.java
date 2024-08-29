package praktikum;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

public class CheckFaq {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);
    HomePage homePage = new HomePage(driver);

    @Before
    public void testPreparing(){
        driver.get(HomePage.URL);
        homePage.clickCloseCookie();
        new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = homePage.faqButtons();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @Test
    public void openFaqHowMuch() {
        String answer = homePage.openFaqHowMuch();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", answer);
    }

    @Test
    public void openFaqSeveralScooters() {
        String answer = homePage.openFaqSeveralScooters();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", answer);
    }

    @Test
    public void openFaqRentalTime() {
        String answer = homePage.openFaqRentalTime();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", answer);
    }

    @Test
    public void openFaqOrderToday() {
        String answer = homePage.openFaqOrderToday();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", answer);
    }

    @Test
    public void openFaqExtendOrderOrEarlier() {
        String answer = homePage.openFaqExtendOrderOrEarlier();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", answer);
    }

    @Test
    public void openFaqBringChargers() {
        String answer = homePage.openFaqBringChargers();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", answer);
    }

    @Test
    public void openFaqCancelOrder() {
        String answer = homePage.openFaqCancelOrder();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", answer);
    }

    @Test
    public void openFaqOutsideMoscowRingRoad() {
        String answer = homePage.openFaqOutsideMoscowRingRoad();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", answer);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
