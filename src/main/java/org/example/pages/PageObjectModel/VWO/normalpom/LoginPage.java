package org.example.pages.PageObjectModel.VWO.normalpom;

import org.example.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // Page Class

    // Page locator
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");
    //private By freeTrial = By.xpath("//button[normalize-space()='Sign in using SSO']");
    //private By rememberMeButton = By.xpath("//button[normalize-space()='Sign in using SSO']");


    // Page Actions
    public String loginToVWOInvalidCreds(String usr, String pwd) {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        WaitHelpers.checkVisibility(driver, error_message);
        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;

    }

    public void loginToVWOValidCreds(String usr, String pwd) {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
    }
}
