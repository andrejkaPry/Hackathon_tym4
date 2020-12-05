package cz.czechitas;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class LoginTests {

    private WebDriver browser;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.gecko.driver", "C://Java-Training//Selenium//geckodriver.exe");
        browser = new FirefoxDriver();

//        System.setProperty("webdriver.chrome.driver", "C://Java-Training//Selenium//chromedriver.exe");
//        browser = new ChromeDriver();

        browser.navigate().to("http://www.czechitas-hackhaton.cz/en/login?back=my-account");
    }

    @Test
//    REQ - 0036
    public void Login_ValidUser_AdminSectionIsShown() throws InterruptedException {

        LoginPage loginPage = new LoginPage(browser);
        loginPage.fillEmailAdress("andrea.vojtova@gmail.com");
        Thread.sleep(2000);
        loginPage.fillUserPassword("12345");
        Thread.sleep(2000);
        AdminHomePage adminHomePage = loginPage.clickonSignInButton();
        Assert.assertTrue("uzivatel nebyl prihlasen", adminHomePage.MyAccountIsShown());

    }

    @Test
    
    public void Login_InvalidUser_ErrorIsShown() throws InterruptedException {

        LoginPage loginPage = new LoginPage(browser);
        loginPage.fillEmailAdress("fakeuser@gmail.com");
        Thread.sleep(2000);
        loginPage.fillUserPassword("nopass");
        Thread.sleep(2000);
        loginPage.clickonSignInButton();
        Thread.sleep(2000);
        Assert.assertTrue("mel by se zobrazit alert", loginPage.isInvalidUserAlertPresent());

    }

    @Test
    // REQ - 0037
    public void LoginLogout_ValidUser_LogInPageIsShown() throws InterruptedException {
        LoginPage loginPage = new LoginPage(browser);
        loginPage.fillEmailAdress("andrea.vojtova@gmail.com");
        loginPage.fillUserPassword("12345");
        loginPage.clickonSignInButton();
        AdminHomePage adminHomePage = new AdminHomePage(browser);
        Thread.sleep(5000);
        adminHomePage.clickOnUserIcon();
        adminHomePage.clickOnLogout();
        Thread.sleep(5000);
    }


    @After
    public void CleanUp() {
        browser.quit();
    }




   


}





