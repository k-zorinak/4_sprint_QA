package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;

    public By faqButtons = By.xpath("//div[contains(@class,'Home_FAQ')]");
    private final By closeCookie = By.xpath(".//button[text()='да все привыкли']");


    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public String openFaq(String numberOfQuestion){
        driver.findElement(By.xpath("//*[@id='accordion__heading-" + numberOfQuestion + "']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + numberOfQuestion)));
        return driver.findElement(By.id("accordion__panel-" + numberOfQuestion)).getText();
    }

    public void clickCloseCookie(){
        driver.findElement(closeCookie).click();
    }

    public WebElement faqButtons(){
        return driver.findElement(faqButtons);
    }
}
