package cz.czechitas;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;


public class AdminHomePage {

    private WebDriver browser;


    public AdminHomePage(WebDriver webDriver){
        browser = webDriver;
    }

    public void clickOnUserIcon(){
        System.out.println("Hledam user icon a klikam na ni");
        WebElement userIcon = browser.findElement(By.className("caret"));
        userIcon.click();
    }

    public LoginPage clickOnLogout(){
        System.out.println("Hledam Logout a klikam na nej, po uspesnem prihlaseni by uzivatel mel byt presmerovan na Login Page");
        WebElement userIcon = browser.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        userIcon.click();
        return new LoginPage(browser);
        
    }

    public boolean MyAccountIsShown() {
        System.out.println("Zkontroluji ze je na strance element my account ");
        WebElement navListElement = browser.findElement(By.id("center_column"));
        return navListElement.isDisplayed();
    }

}
