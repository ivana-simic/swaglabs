package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public By userNameInputField = By.xpath("//input[@placeholder='Username']");
    public By passwordInputField = By.xpath("//input[@placeholder='Password']");
    public By loginButton = By.xpath("//input[@name='login-button']");
    public By errorMessage = By.xpath("//h3[@data-test='error' and text()='Epic sadface: Username and password do not match any user in this service']");
    public By blankUsernameFieldMessage = By.xpath("//h3[@data-test='error' and text()='Epic sadface: Username is required']");
    public By blankPasswordFieldMessage = By.xpath("//h3[@data-test='error' and text()='Epic sadface: Password is required']");


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterUserName(String username){
        driver.findElement(userNameInputField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public String getBlankFieldUsernameMessage(){
        return driver.findElement(blankUsernameFieldMessage).getText();
    }
    public String getBlankFieldPasswordMessage() {
       return driver.findElement(blankPasswordFieldMessage).getText();
    }
    public void login(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }




}
