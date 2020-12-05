package cz.czechitas;

import org.openqa.selenium.*;

public class SearchResultPage {

  private WebDriver browser;

  public SearchResultPage(WebDriver webDriver) {
    browser = webDriver;
  }

  public String getSearchResultText() {
    System.out.println("Zkontroluji, ze je ve vysledcich napsano 0 items found");
    WebElement zeroItemsFound = browser.findElement(By.xpath("//*[@id=\"products-qty\"]"));
    return zeroItemsFound.getText();
  }
}
