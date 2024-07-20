package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addtocartpage {

    public WebElement addtocartbuttonloc(WebDriver driver){
        By addtocartbutton=By.id("add-to-cart-sauce-labs-backpack");
        WebElement addtocartElement=driver.findElement(addtocartbutton);
        return addtocartElement;
    }
    public WebElement cartcontainerloc(WebDriver driver){
        By cartcontainericon=By.id("shopping_cart_container");
        WebElement cartcontainerElement=driver.findElement(cartcontainericon);
        return cartcontainerElement;
    }
    public WebElement itemnameloc(WebDriver driver){
        By itemname=By.id("item_4_title_link");
        WebElement itemnameElement=driver.findElement(itemname);
        return itemnameElement;
    }
    public WebElement priceofproductpageloc(WebDriver driver){
        By priceofproductpage=By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
        WebElement priceofproductpageElement=driver.findElement(priceofproductpage);
        return priceofproductpageElement;
    }
    public WebElement removefromcartbuttonloc(WebDriver driver){
        By removeaproduct=By.id("remove-sauce-labs-backpack");
        WebElement removeaproductElement=driver.findElement(removeaproduct);
        return removeaproductElement;
    }

    public WebElement cartitemcontainerloc(WebDriver driver){
        WebElement cartitemcontainerElement=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]"));
        return cartitemcontainerElement;
    }
    public WebElement removefromcartpageloc(WebDriver driver){
        WebElement removeafromcartpageElement=driver.findElement(By.id("remove-sauce-labs-backpack"));
        return removeafromcartpageElement;
    }
    public WebElement continuebuttonloc(WebDriver driver){
        WebElement continuebuttonElement=driver.findElement(By.id("continue-shopping"));
        return continuebuttonElement;
    }

}




