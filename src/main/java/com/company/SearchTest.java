package com.company;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import cz.czechitas.*;

//      CVICENI 1

public class SearchTest {

    WebDriver browser;

    @Before
    public void SetUp() {
//        System.setProperty("webdriver.gecko.driver", "C://Java-Training//Selenium//geckodriver.exe");
//        browser = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C://Java-Training//Selenium//chromedriver.exe");
        browser = new ChromeDriver();

    }

    @Test
    public void SearchTest() throws InterruptedException {

        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");
        HomePage homePage = new HomePage(browser);
        homePage.fillSearchText("neexistujiciVec");
        Thread.sleep(5000);
        homePage.clickOnSearchButton();
        SearchResultPage resultPage = new SearchResultPage(browser);
        resultPage.getSearchResultText();
        Thread.sleep(5000);
    }

//        //        CVICENI 2 + 3
//
//        WebElement searchBox = browser.findElement(By.id("searchField"));
//        searchBox.sendKeys("Urcite neexistujici kabelka");
//        Thread.sleep(5000);
//
//        WebElement button = browser.findElement(By.className("btn-lg"));
//        button.click();
//        Thread.sleep(5000);
//
//        System.out.println("Zkontroluji ze jsem byl presmerovan na stranku http://czechitas-shopizer.azurewebsites.net/shop/search/search.html");
//        String currentUrl = browser.getCurrentUrl();
//        Assert.assertEquals("http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", currentUrl);
//        Thread.sleep(5000);
//
////        CVICENI 4
//
//
//        WebElement zeroItemsFound = browser.findElement(By.xpath("//*[@id=\"products-qty\"]"));
////        WebElement zeroItemsFound = browser.findElement(By.id("products-qty"));
//        String textValue = zeroItemsFound.getText();
//        Assert.assertEquals("0 item(s) found", textValue);
//        Thread.sleep(5000);

//        Assert.assertTrue("Tohle ma byt true", true);
//        Assert.assertTrue("Tohle ma byt false", false);

    @After
    public void CleanUp() {
        browser.quit();
    }

}
