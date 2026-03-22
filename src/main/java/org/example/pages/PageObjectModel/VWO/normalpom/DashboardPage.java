package org.example.pages.PageObjectModel.VWO.normalpom;

import org.example.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private final By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    public String loggedInUserName(){
        WaitHelpers.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard?accountId=1207845");
        WaitHelpers.waitJVM(3000);
        return driver.findElement(userNameOnDashboard).getText();
    }


}
