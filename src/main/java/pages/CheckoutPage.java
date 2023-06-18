package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    WebDriver driver;

    public By firstNameInputField = By.xpath("//input[@placeholder='First Name']");
    public By lastNameInputField = By.xpath("//input[@placeholder='Last Name']");
    public By zipCodeInputField = By.xpath("//input[@placeholder='Zip/Postal Code']");
    public By continueButton = By.xpath("//input[@name='continue']");


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void completeStepOne(String firstName,String lastName,String zipCode){
        driver.findElement(firstNameInputField).sendKeys(firstName);
        driver.findElement(lastNameInputField).sendKeys(lastName);
        driver.findElement(zipCodeInputField).sendKeys(zipCode);
        driver.findElement(continueButton).click();
    }




}
