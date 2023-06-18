package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pages.CartButton.generateRemoveFromCartButtonName;

public class CartPage {

    WebDriver driver;

    public By checkoutButton = By.xpath("//button[@name='checkout']");
    public By continueShoppingButton = By.xpath("//button[@name='continue-shopping']");

    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public WebElement getRemoveFromCartItemButton(String itemName){
        return driver.findElement(By.xpath("//button[@name='" + generateRemoveFromCartButtonName(itemName) + "']"));
    }

    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }
    public void clickContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }






}
