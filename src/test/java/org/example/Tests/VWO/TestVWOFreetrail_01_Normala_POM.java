package org.example.Tests.VWO;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.pages.PageObjectModel.VWO.normalpom.FreeTrialPage;
import org.example.pages.PageObjectModel.VWO.normalpom.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class TestVWOFreetrail_01_Normala_POM {
    @Owner("shraddha")
    @Description("Check if free trial works.")
    @Test
    public void Start_Free_Trial() {

        WebDriver driver = new ChromeDriver();
        String URL = "https://app.vwo.com/#/login";
        driver.get(URL);
        driver.manage().window().maximize();


        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);
        // 490E6ED1FFCE856958FBB4A646C90572


        WebElement link_parent = driver.findElement(By.xpath("//a[normalize-space()='Start a FREE TRIAL']"));
        link_parent.click();

        Set<String> windows_handles_ids = driver.getWindowHandles();
        // 1D338BD81AC274FF43D0698647443AD0
        //98C2024C16C8DACAC182BDDC5D7C6ED9

        for (String window : windows_handles_ids) {
            System.out.println(window);
            if (!window.equalsIgnoreCase(parent_id)) {
                driver.switchTo().window(window);

                // Whatever you want to verify in the child, now you can.
                //free trial page
                FreeTrialPage CreateFreeTrial = new FreeTrialPage(driver);
                CreateFreeTrial.CreateFreeTrialAccount("nirmalahgs@bigbasket.com");
                //Sign up page
                SignUpPage CreateAccount = new SignUpPage(driver);
                CreateAccount.SignUp("Nirmala", "M", "9740433820");


            }



        }
    }
}
