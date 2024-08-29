package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

 class MainPage {
     private final WebDriver driver;
     private final By closeCookie = By.xpath(".//button[text()='да все привыкли']");
     private final By goButton = By.cssSelector(".Header_Button__28dPO");
     private final By orderField = By.className("Input_Input__1iN_Z");
     private final By statusButton = By.className("Header_Link__1TAG7");
     private final By img = By.cssSelector("img[alt='Not found']");
     private final By orderButton = By.className("Button_Button__ra12g");
     private final By nameField = By.xpath(".//input[contains(@placeholder,'Имя')]");
     private final By lastNameField = By.xpath(".//input[contains(@placeholder,'Фамилия')]");
     private final By addressField = By.xpath(".//input[contains(@placeholder,'Адрес')]");
     private final By stationField = By.xpath(".//input[contains(@placeholder,'метро')]");
     private final By stationSelection = By.xpath(".//div[@class='Order_Text__2broi' and text()='Лубянка']");
     private final By phoneNumberField = By.xpath(".//input[contains(@placeholder,'Телефон')]");
     private final By buttonNext = By.xpath(".//button[text()='Далее']");
     private final By dateField = By.xpath(".//input[contains(@placeholder,'Когда')]");
     private final By chooseNextMonth = By.xpath(".//button[text()='Next Month']");
     private final By chooseADay = By.xpath(".//div[text()='5']");
     private final By rentalField = By.xpath("//div[contains(text(),'Срок аренды')]");
     private final By numberOfDays = By.xpath(".//div[contains(text(),'двое суток')]");
     private final By color = By.className("Checkbox_Label__3wxSf");
     private final By comment = By.xpath(".//input[contains(@placeholder,'Комментарий')]");
     private final By order = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and (text()='Заказать')]");
     private final By yesButton = By.xpath(".//button[contains(text(),'Да')]");
     private final By successResult = By.xpath(".//div[text()='Заказ оформлен']");
     private final By middleOrderButton = By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");

     public MainPage(WebDriver driver){
         this.driver = driver;
     }

     public void open(){
         driver.get(EnvConfig.BASE_URL);
     }

     public void clickOnStatus(){
        driver.findElement(statusButton).click();
    }

    public void enterOrderId(String orderNumber){
        driver.findElement(orderField).sendKeys(orderNumber);
    }

    public void clickOnGo(){
        driver.findElement(goButton).click();
    }

    public void checkErrorImage(){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(img));
        assertTrue(driver.findElement(img).isDisplayed());
    }

     public void clickOnOrder(){
         driver.findElement(orderButton).click();
     }
     public void indicateName(String name) {
         driver.findElement(nameField).click();
         driver.findElement(nameField).sendKeys(name);
     }

     public void indicateLastName(String lastName){
         driver.findElement(lastNameField).click();
         driver.findElement(lastNameField).sendKeys(lastName);
     }

     public void indicateAddress(String address){
         driver.findElement(addressField).click();
         driver.findElement(addressField).sendKeys(address);
     }
     public void indicateStation(){
         driver.findElement(stationField).click();
         driver.findElement(stationSelection).click();
     }

     public void indicateNumber(String number){
         driver.findElement(phoneNumberField).click();
         driver.findElement(phoneNumberField).sendKeys(number);
     }
     public void clickOnButtonNext(){
         driver.findElement(buttonNext).click();
     }

     public void indicateDate(){
         driver.findElement(dateField).click();
         driver.findElement(chooseNextMonth).click();
         driver.findElement(chooseADay).click();
     }

     public void chooseRentalPeriod(){
         driver.findElement(rentalField).click();
         driver.findElement(numberOfDays).click();
     }

     public void chooseColor(){
         driver.findElement(color).click();
     }
     public void writeAComment(String message){
         driver.findElement(comment).click();
         driver.findElement(comment).sendKeys(message);
     }

     public void finalOrder(){
         driver.findElement(order).click();
     }
     public void clickOnYesButton(){
         new WebDriverWait(driver, Duration.ofSeconds(15))
                 .until(ExpectedConditions.elementToBeClickable(yesButton));
         assertTrue(driver.findElement(yesButton).isDisplayed());
         driver.findElement(yesButton).click();
     }
     public String checkIsOrderSuccess(){
         return driver.findElement(successResult).getText();
     }
     public void clickOrderMiddleButton(){
         driver.findElement(middleOrderButton).click();
     }
     public void clickCloseCookie(){
         driver.findElement(closeCookie).click();
     }
 }