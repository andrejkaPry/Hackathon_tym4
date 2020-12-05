package cz.czechitas;

import org.openqa.selenium.*;

public class LoginPage {

    private WebDriver browser;

    public LoginPage(WebDriver webDriver) {
        browser = webDriver;
    }

    public void fillEmailAdress(String emailAdress) {
        System.out.println("Najdi element Email Adress a vepis do nej email " + emailAdress);
        WebElement loginUserName = browser.findElement(By.id("email"));
        loginUserName.sendKeys(emailAdress);
    }

    public void fillUserPassword(String password) {
        System.out.println("Najdi element Password a vepis do nej heslo " + password);
        WebElement logInpassword = browser.findElement(By.id("passwd"));
        logInpassword.sendKeys(password);
    }

    public AdminHomePage clickonSignInButton() {
        System.out.println("Najdi element SignInButton a klikni na nej");
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();
        return new AdminHomePage(browser);
    }
    public boolean isInvalidUserAlertPresent(){
        System.out.println("Zkontroluji ze je na strance error message ");
        WebElement alertError = browser.findElement(By.xpath("//p[contains(text(),'There is 1 error')]"));
        return alertError.isDisplayed();
    }


}
