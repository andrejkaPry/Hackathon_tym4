package cz.czechitas;

import org.openqa.selenium.*;

public class HomePage {

    private WebDriver browser;

    public HomePage(WebDriver webDriver) {
        browser = webDriver;
    }

    public void fillSearchText(String text) {
        System.out.println("Najdi element SearchBox a vepis do nej text " + text);
        WebElement searchBox = browser.findElement(By.id("searchField"));
        searchBox.sendKeys(text);
    }

    public SearchResultPage clickOnSearchButton() {
        System.out.println("Najdi element SearchButton a klikni na nej");
        WebElement searchButton = browser.findElement(By.className("btn-lg"));
        searchButton.click();
        return new SearchResultPage(browser);
    }

//    public void openProductsMenuAKlikniNaPolozku(String menuPolozku){
//        WebElement productMenuElement = browser.findElement(By.className(""));
//        productMenuElement.click();
//    }
}

