package testcases;

import base.BaseTest;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilites.validDataReader;

import static base.BaseTest.driver;
import static base.BaseTest.loginLoc;
@Listeners({AllureTestNg.class})
public class logouttest extends BaseTest {

    @DataProvider(name = "loginValidData")
    public static Object[][] GetValidLoginData() {
        return validDataReader.GetValidLoginData();
    }


    @Test(dataProvider = "loginValidData", description = "log out from the website")
    public void logout(String username,String password) throws InterruptedException {
       login(username,password);
       logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logoutLoc.logoutbuttonloc(driver).click();
        // verify that we back to the login page
        String actualtitle=driver.getTitle();
        System.out.println(actualtitle);
        String expectedtitle="Swag Labs";
        Assert.assertEquals(actualtitle,expectedtitle);
    }
    @Test(dataProvider = "loginValidData", description = "press back after logout to sure that website does not back to login situation ")
    public void pressback(String username,String password) throws InterruptedException {
        login(username,password);
        logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logoutLoc.logoutbuttonloc(driver).click();
        driver.navigate().back();
        // verify we still in log in page
        String actualtitle=driver.getTitle();
        System.out.println(actualtitle);
        String expectedtitle="Swag Labs";
        Assert.assertEquals(actualtitle,expectedtitle);
    }

}
