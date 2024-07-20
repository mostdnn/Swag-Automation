package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilites.validDataReader;

public class Checkouttest extends BaseTest {

    @DataProvider(name = "loginValidData")
    public static Object[][] GetValidLoginData() {
        return validDataReader.GetValidLoginData();
    }

    @Test(dataProvider = "loginValidData", description = "do checkout with valid data")
    public void checkoutwithvaliddata(String username,String password) throws InterruptedException {
        login(username,password);
       addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        checkoutLoc.checkoutbuttonloc(driver).click();
       checkoutLoc.firstnameloc(driver).sendKeys("mostafa");
       checkoutLoc.lastnameloc(driver).sendKeys("ramadan");
       checkoutLoc.postalcodeloc(driver).sendKeys("12356");
       checkoutLoc.continuecheckoutloc(driver).click();
       checkoutLoc.finishcheckoutloc(driver).click();
        String actualmessage=checkoutLoc.messageforsuccesscheckoutloc(driver).getText();
        String expectedmessage="Thank you for your order!";
        Assert.assertEquals(expectedmessage,actualmessage);

    }
    @Test(dataProvider = "loginValidData", description = "do checkout with empty data")
    public void checkoutwithemptydata(String username,String password) throws InterruptedException {
        login(username,password);
        addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        checkoutLoc.checkoutbuttonloc(driver).click();
        checkoutLoc.firstnameloc(driver).sendKeys("");
        checkoutLoc.lastnameloc(driver).sendKeys("");
        checkoutLoc.postalcodeloc(driver).sendKeys("");
        checkoutLoc.continuecheckoutloc(driver).click();
        String actualerrorrmessage=checkoutLoc.messageforemptyerrortloc(driver).getText();
        String expectederorrmessage="Error: First Name is required";
        Assert.assertEquals(expectederorrmessage,actualerrorrmessage);

    }

    @Test(dataProvider = "loginValidData", description = "verify the total price is added correctly")
    public void verifytotalprice(String username,String password) throws InterruptedException {
        login(username,password);
        addtocartLoc.addtocartbuttonloc(driver).click();
        checkoutLoc.addanotherproductocartloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        // get the price of products and add it and count taxes
        String price1 =checkoutLoc.price1loc(driver).getText();
        String price2=checkoutLoc.price2loc(driver).getText();
        // Extract the price text and remove the dollar sign
        String priceText1 = price1.replace("$", "");
        String priceText2 = price2.replace("$", "");

        // Convert the price text to floating-point numbers
        double price1Value = Double.parseDouble(priceText1);
        double price2Value = Double.parseDouble(priceText2);
        checkoutLoc.checkoutbuttonloc(driver).click();
        checkoutLoc.firstnameloc(driver).sendKeys("mostafa");
        checkoutLoc.lastnameloc(driver).sendKeys("ramadan");
        checkoutLoc.postalcodeloc(driver).sendKeys("12324");
        checkoutLoc.continuecheckoutloc(driver).click();
        String tax=checkoutLoc.taxloc(driver).getText();
        String taxremove = tax.replace("Tax: $", "");
        double taxparse = Double.parseDouble(taxremove);
        // Calculate the total price
        double totalPrice = price1Value + price2Value+taxparse;
        System.out.println(totalPrice);
        String actualtotalprice=checkoutLoc.actualtotalpriceloc(driver).getText();
        String actualtotalpriceemove = actualtotalprice.replace("Total: $", "");
        double actualtotalpriceparse = Double.parseDouble(actualtotalpriceemove);
        Assert.assertEquals(totalPrice,actualtotalpriceparse);
    }

    @Test(dataProvider = "loginValidData", description = "cancel checkout")
    public void cancelcheckout(String username,String password) throws InterruptedException {
        login(username,password);
        addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
       checkoutLoc.checkoutbuttonloc(driver).click();
        checkoutLoc.cancelcheckoutloc(driver).click();
        //verify get back to cart page
        String expectedurl="https://www.saucedemo.com/cart.html";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);

    }
    @Test(dataProvider = "loginValidData", description = "get back to home page after checkout ")
    public void getbacktohomepage(String username,String password) throws InterruptedException {
        login(username,password);
        addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        checkoutLoc.checkoutbuttonloc(driver).click();
        checkoutLoc.firstnameloc(driver).sendKeys("mostafa");
        checkoutLoc.lastnameloc(driver).sendKeys("ramadan");
        checkoutLoc.postalcodeloc(driver).sendKeys("12235");
        checkoutLoc.continuecheckoutloc(driver).click();
        checkoutLoc.finishcheckoutloc(driver).click();
        checkoutLoc.backhomeaftercheckoutloc(driver).click();
        //verify get back to home page
        String expectedurl="https://www.saucedemo.com/inventory.html";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);

    }

    @Test(dataProvider = "loginValidData", description = "verify product is removed from cart after checkout")
    public void verifyremovingtheproduct(String username,String password) throws InterruptedException {
        login(username,password);
       addtocartLoc.addtocartbuttonloc(driver).click();
       addtocartLoc.cartcontainerloc(driver).click();
        checkoutLoc.checkoutbuttonloc(driver).click();
        checkoutLoc.firstnameloc(driver).sendKeys("mostafa");
        checkoutLoc.lastnameloc(driver).sendKeys("ramadan");
        checkoutLoc.postalcodeloc(driver).sendKeys("13554");
        checkoutLoc.continuecheckoutloc(driver).click();
        checkoutLoc.finishcheckoutloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        // Verify that the product is no longer in the cart
        Assert.assertFalse(checkoutLoc.cartitemsloc(driver).getText().contains("Sauce Labs Backpack"));

    }






}
