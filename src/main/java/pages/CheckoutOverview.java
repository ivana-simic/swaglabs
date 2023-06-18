package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview {

    WebDriver driver;

    public By finishButton = By.xpath("//button[@name='finish']");

    public CheckoutOverview(WebDriver driver){
        this.driver = driver;
    }

    public Double totalCostOfItemsInTheCart(){
        Double priceItem1 = 29.99;
        Double priceItem2 = 9.99;
        return priceItem1 + priceItem2 ;
    }

    public void completeStepTwo(){
        driver.findElement(finishButton).click();
    }

}
