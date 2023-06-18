package com.swaglabs;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import pages.InventoryPage;
import pages.LoginPage;

public class SocialMediaTest extends BaseTest {

    InventoryPage inventoryPage = new InventoryPage(driver);

    @BeforeClass
    public static void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @Test
    public void twitterLinkTest() {
        WebElement twitter = inventoryPage.getTwitterLink();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",twitter);
        twitter.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://twitter.com/saucelabs";
        System.out.println(currentUrl);
        Assert.assertFalse("Twitter is open on the new page",currentUrl.equals(expectedUrl));
    }

    @Test
    public void facebookLinkTest() {
        WebElement facebook = inventoryPage.getFacebookLink();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",facebook);
        facebook.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/saucelabs";
        System.out.println(currentUrl);
        Assert.assertFalse("Facebook is open on the new page",currentUrl.equals(expectedUrl));
    }

    @Test
    public void linkedinLinkTest() {
        WebElement linkedin = inventoryPage.getLinkedinLink();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",linkedin);
        linkedin.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.linkedin.com/company/sauce-labs/";
        System.out.println(currentUrl);
        Assert.assertFalse("Linkedin is open on the new page",currentUrl.equals(expectedUrl));
    }
}
