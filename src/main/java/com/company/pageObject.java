package com.company;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

// PIS PRIVATE METODy

public class pageObject {
    WebDriver browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver", "C://Java-Training//Selenium//geckodriver.exe");
        browser = new FirefoxDriver();
    }

    @Test
    public void SearchTest() throws InterruptedException {
        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

//        CVICENI 2 + 3

        System.out.println("Najdi element SearchBox a vepis do nej text ,urcite neexistujici kabelka");
        WebElement searchBox = browser.findElement(By.id("searchField"));
        searchBox.sendKeys("Urcite neexistujici kabelka");
        Thread.sleep(5000);

        System.out.println("Najdi element SearchButton a klikni na nej");
        WebElement button = browser.findElement(By.className("btn-lg"));
        button.click();
        Thread.sleep(5000);

        System.out.println("Zkontroluji ze jsem byl presmerovan na stranku http://czechitas-shopizer.azurewebsites.net/shop/search/search.html");
        String currentUrl = browser.getCurrentUrl();
        Assert.assertEquals("http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", currentUrl);
        Thread.sleep(5000);

//        CVICENI 4

        System.out.println("Zkontroluji, ze je ve vysledcich napsano 0 items found");
        WebElement zeroItemsFound = browser.findElement(By.xpath("//*[@id=\"products-qty\"]"));
//        WebElement zeroItemsFound = browser.findElement(By.id("products-qty"));
        String textValue = zeroItemsFound.getText();
        Assert.assertEquals("0 item(s) found", textValue);
        Thread.sleep(5000);

//        Assert.assertTrue("Tohle ma byt true", true);
//        Assert.assertTrue("Tohle ma byt false", false);

    }

    @After
    public void CleanUp() {
        browser.quit();
    }
}
