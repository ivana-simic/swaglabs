package com.swaglabs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpDriver() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() throws Exception {
        driver.quit();
    }



}
