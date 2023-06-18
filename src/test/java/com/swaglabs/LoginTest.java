package com.swaglabs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.InventoryPage;
import pages.LoginPage;

import static com.swaglabs.UserDetailsRandomGenerate.generateRandomPassword;
import static com.swaglabs.UserDetailsRandomGenerate.generateRandomUsername;
import static pages.CartButton.generateAddToCartButtonName;

public class LoginTest extends BaseTest {



    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    @Before
    public void setup() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginWithValidUsernameAndPassword() {
        loginPage.login("standard_user", "secret_sauce");
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        boolean displayedProductsTitle = driver.findElement(By.xpath("//span[@class='title' and text()='Products']")).isDisplayed();
        Assert.assertTrue("The user is not on the Inventory page", currentUrl.equals(expectedUrl));
        Assert.assertTrue("Products title is not displayed", displayedProductsTitle);

    }

    @Test
    public void loginWithInvalidUsername() {
        loginPage.login(generateRandomUsername(), "secret_sauce");
        String errorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("The error message doesn't show up for the invalid username", errorMessage.equals(expectedErrorMessage));
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.login("standard_user", generateRandomPassword());
        String errorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue("The error message doesn't show up for the invalid password", errorMessage.equals(expectedErrorMessage));
    }

    @Test
    public void loginWithoutUsername() {
        loginPage.login("", "secret_sauce");
        String errorMessage = loginPage.getBlankFieldUsernameMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertTrue("The error message doesn't show up for the unpopulated username field", errorMessage.equals(expectedErrorMessage));
    }

    @Test
    public void loginWithoutPassword() {
        loginPage.login("standard_user", "");
        String errorMessage = loginPage.getBlankFieldPasswordMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertTrue("The error message doesn't show up for the unpopulated password field", errorMessage.equals(expectedErrorMessage));
    }


}

