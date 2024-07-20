package testcases;


import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilites.validDataReader;


public class Addtocarttest extends BaseTest {

    @DataProvider(name = "loginValidData")
    public static Object[][] GetValidLoginData() {
        return validDataReader.GetValidLoginData();
    }

    @Test(priority = 1,dataProvider = "loginValidData", description = "add product to the cart")
    public void addproducttocart(String username,String password) throws InterruptedException {
        login(username,password);
       addtocartLoc.addtocartbuttonloc(driver).click();
       addtocartLoc.cartcontainerloc(driver).click();
        String expitemname="Sauce Labs Backpack";
        Assert.assertEquals(expitemname,addtocartLoc.itemnameloc(driver).getText());
        logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test(priority = 2,dataProvider = "loginValidData", description = "verify the price in product page is equal price in cart")
    public void verifytheprice(String username,String password) throws InterruptedException {
        login(username,password);
        String priceofproductpage =addtocartLoc.priceofproductpageloc(driver).getText();
        addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        String priceofcartpage="$29.99";
        Assert.assertEquals(priceofcartpage,priceofproductpage);
        logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test(priority = 3,dataProvider = "loginValidData", description = "remove product from the product page ")
    public void removeproductinhomepage(String username,String password) throws InterruptedException {
        login(username,password);
        addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.removefromcartbuttonloc(driver).click();
        String buttontextafterremoving=addtocartLoc.addtocartbuttonloc(driver).getText();
        System.out.println(buttontextafterremoving);
        String expbuttontext="Add to cart";
        Assert.assertEquals(expbuttontext,buttontextafterremoving);
        logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test(priority = 4,dataProvider = "loginValidData", description = "remove product from cart page")
    public void removeproductfromcartpage(String username,String password) throws InterruptedException {
        login(username,password);
        addtocartLoc.addtocartbuttonloc(driver).click();
        addtocartLoc.cartcontainerloc(driver).click();
        addtocartLoc.removefromcartpageloc(driver).click();
        // Verify that the product is no longer in the cart
        WebElement cartItems = addtocartLoc.cartitemcontainerloc(driver);
        Assert.assertFalse(cartItems.getText().contains("Sauce Labs Backpack"));
        logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5,dataProvider = "loginValidData", description = "get back to product page")
    public void getbacktoproductpage(String username,String password) throws InterruptedException {
        login(username,password);
       addtocartLoc.addtocartbuttonloc(driver).click();
       addtocartLoc.cartcontainerloc(driver).click();
        addtocartLoc.continuebuttonloc(driver).click();
        // verify we back to product page
        String actualurl= driver.getCurrentUrl();
        System.out.println(actualurl);
        String expectedurl="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedurl,actualurl);
        logoutLoc.menubuttonloc(driver).click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
