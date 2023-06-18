package com.swaglabs;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.*;

import static com.swaglabs.UserDetailsRandomGenerate.*;
import static pages.CartButton.*;

public class ProductsPurchaseTest extends BaseTest {

    static LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutOverview checkoutOverview = new CheckoutOverview(driver);
    CheckoutComplete checkoutComplete = new CheckoutComplete(driver);

    @BeforeClass
    public static void setup() throws Exception {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void addItemToTheCart() {
        inventoryPage.getAddToCartItemButton("Sauce Labs Backpack").click();
        inventoryPage.getAddToCartItemButton("Sauce Labs Bike Light").click();
        inventoryPage.getAddToCartItemButton("Sauce Labs Fleece Jacket").click();
        String currentBadgeCart = inventoryPage.getBadgeShoppingCart().getText();
        String expectedBadgeCart = "3";
        WebElement sauceLabsBackpack = inventoryPage.getRemoveFromCartItemButton("Sauce Labs Backpack");
        boolean displayedRemoveButton = sauceLabsBackpack.isDisplayed();
        sauceLabsBackpack.click();
        WebElement sauceLabsBikeLight = inventoryPage.getRemoveFromCartItemButton("Sauce Labs Bike Light");
        boolean displayedRemoveButton2 = sauceLabsBikeLight.isDisplayed();
        WebElement sauceLabsFleeceJacket = inventoryPage.getRemoveFromCartItemButton("Sauce Labs Fleece Jacket");
        boolean displayedRemoveButton3 = sauceLabsFleeceJacket.isDisplayed();
        sauceLabsFleeceJacket.click();


        Assert.assertTrue("Remove button for Sauce Labs Backpack is not displayed", displayedRemoveButton);
        Assert.assertTrue("Remove button for Sauce Labs Bike Light is not displayed", displayedRemoveButton2);
        Assert.assertTrue("Remove button for Sauce Labs Fleece Jacket is not displayed", displayedRemoveButton3);
        Assert.assertTrue("Three products are not added to the shopping cart", currentBadgeCart.equals(expectedBadgeCart));
    }

    @Test
    public void removeItemFromTheCart() {
        inventoryPage.getAddToCartItemButton("Sauce Labs Fleece Jacket").click();
        inventoryPage.clickOnShoppingCartIcon();
        WebElement sauceLabsFleeceJacket = cartPage.getRemoveFromCartItemButton("Sauce Labs Fleece Jacket");
        sauceLabsFleeceJacket.click();
        cartPage.clickContinueShopping();
        boolean displayedSauceLabsJacket = inventoryPage.getAddToCartItemButton("Sauce Labs Fleece Jacket").isDisplayed();
        Assert.assertTrue("Sauce Labs Fleece Jacket is still displayed in cart", displayedSauceLabsJacket);
    }

    @Test
    public void successfulPurchase() {
        inventoryPage.getAddToCartItemButton("Sauce Labs Backpack").click();
        inventoryPage.getAddToCartItemButton("Sauce Labs Bike Light").click();
        inventoryPage.clickOnShoppingCartIcon();
        cartPage.clickCheckout();
        checkoutPage.completeStepOne(
                generateRandomFirstName(),
                generateRandomLastName(),
                generateRandomZipCode());
        Double currentAmount = checkoutOverview.totalCostOfItemsInTheCart();
        Double expectedAmount = 39.98;
        Assert.assertEquals("The amount in the cart doesn't match with the sum of products", currentAmount, expectedAmount);
        checkoutOverview.completeStepTwo();
        String currentMessage = checkoutComplete.getConfirmationMessage();
        String expectedMessage = "Thank you for your order!";
        boolean displayedBackHomeButton = checkoutComplete.getBackHomeButton().isDisplayed();
        Assert.assertTrue("Confirmation message didn't show up", currentMessage.equals(expectedMessage));
        Assert.assertTrue("BackHome button is not displayed", displayedBackHomeButton);
        checkoutComplete.getBackHomeButton().click();
    }



}
