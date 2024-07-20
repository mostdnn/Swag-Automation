package testcases;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilites.validDataReader;
import utilites.invalidDataReader;

public class logintest extends BaseTest {


    @DataProvider(name = "loginValidData")
    public static Object[][] GetValidLoginData() {
        return validDataReader.GetValidLoginData();
    }
    @DataProvider(name = "loginInValidData")
    public static Object[][] GetInValidLoginData() {
        return invalidDataReader.GetInValidLoginData();
    }


    @Test(dataProvider = "loginValidData", description = "log in with valid username and password")
    public void loginwithvaliddata(String username,String password) throws InterruptedException {
        login(username,password);
        String actualtitle=driver.getTitle();
        String expectedtitle="Swag Labs";
        Assert.assertEquals(actualtitle,expectedtitle);
    }
    @Test(dataProvider = "loginInValidData", description = "log in with invalid username and password")
    public void loginwithinvaliddata(String invalidusername,String invalidpassword){
        login(invalidusername,invalidpassword);
        // Assert that the expected error message is displayed
        String Experrorrmessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(Experrorrmessage, loginLoc.errormessagelocforInValidData(driver).getText());
    }


    @Test(description = "log in with empty username and empty password")
    public void loginwithemptydata(){
        login("","");
        // Assert that the expected error message is displayed
        Assert.assertEquals("Epic sadface: Username is required", loginLoc.errormessagelocforEmptyData(driver).getText());


    }
    @Test(dataProvider = "loginValidData", description = "Verify if the ‘Enter’ key of the keyboard is working correctly on the login page")
    public void loginwithpressenter(String username,String password) throws InterruptedException {
        loginLoc.usernamepom(driver).sendKeys(username);
        loginLoc.passwordpom(driver).sendKeys( password);
        loginLoc.passwordpom(driver).sendKeys(Keys.ENTER);
        String actualtitle=driver.getTitle();
        String expectedtitle="Swag Labs";
        Assert.assertEquals(actualtitle,expectedtitle);

    }




}



