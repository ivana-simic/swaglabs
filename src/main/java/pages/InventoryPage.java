package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static pages.CartButton.generateAddToCartButtonName;
import static pages.CartButton.generateRemoveFromCartButtonName;

public class InventoryPage {

    WebDriver driver;

    public By shoppingCartIcon = By.xpath("//a[@class='shopping_cart_link']");
    public By badgeShoppingCart = By.xpath("//span[@class='shopping_cart_badge']");
    public By twitterLink = By.xpath("//a[@href='https://twitter.com/saucelabs']");
    public By facebookLink = By.xpath("//a[@href='https://www.facebook.com/saucelabs']");
    public By linkedinLink = By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']");


    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getAddToCartItemButton(String itemName){
        return driver.findElement(By.xpath("//button[@name='" + generateAddToCartButtonName(itemName) + "']"));
    }
    public WebElement getRemoveFromCartItemButton(String itemName) {
        return driver.findElement(By.xpath("//button[@name='" + generateRemoveFromCartButtonName(itemName) + "']"));
    }
    public WebElement getBadgeShoppingCart(){
        return driver.findElement(badgeShoppingCart);
    }
    public void clickOnShoppingCartIcon(){
         driver.findElement(shoppingCartIcon).click();
    }

    public WebElement getTwitterLink(){
        return driver.findElement(twitterLink);
    }
    public WebElement getFacebookLink(){
        return driver.findElement(facebookLink); 
    }
    public WebElement getLinkedinLink(){
        return driver.findElement(linkedinLink);
    }




}
