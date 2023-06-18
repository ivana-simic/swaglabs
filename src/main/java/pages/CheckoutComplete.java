package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutComplete {

    WebDriver driver;

    public By confirmationMessage = By.xpath("//h2[@class='complete-header']");
    public By backHomeButton = By.xpath("//button[@name='back-to-products']");


    public CheckoutComplete(WebDriver driver){
        this.driver=driver;
    }

    public String getConfirmationMessage(){
       return driver.findElement(confirmationMessage).getText();
    }
    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }
  


}
