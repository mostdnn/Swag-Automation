package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutpage {
    public WebElement checkoutbuttonloc(WebDriver driver){
        WebElement checkoutElement=driver.findElement(By.id("checkout"));
        return checkoutElement;
    }

    public WebElement firstnameloc(WebDriver driver){
        WebElement firstnameElement=driver.findElement(By.id("first-name"));
        return firstnameElement;
    }
    public WebElement lastnameloc(WebDriver driver){
        WebElement lastnameElement=driver.findElement(By.id("last-name"));
        return lastnameElement;
    }
    public WebElement postalcodeloc(WebDriver driver){
        WebElement postalcodeElement=driver.findElement(By.id("postal-code"));
        return postalcodeElement;
    }
    public WebElement continuecheckoutloc(WebDriver driver){
        WebElement continueElement=driver.findElement(By.id("continue"));
        return continueElement;
    }
    public WebElement finishcheckoutloc(WebDriver driver){
        WebElement finishElement=driver.findElement(By.id("finish"));
        return finishElement;
    }
    public WebElement messageforsuccesscheckoutloc(WebDriver driver){
        WebElement messageElement=driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        return messageElement;
    }

    public WebElement messageforemptyerrortloc(WebDriver driver){
        WebElement messageElement=driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]"));
        return messageElement;
    }
    public WebElement addanotherproductocartloc(WebDriver driver){
        WebElement addtocartElement=driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        return addtocartElement;
    }

    public WebElement price1loc(WebDriver driver){
        WebElement price1Element=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
        return price1Element;
    }

    public WebElement price2loc(WebDriver driver){
        WebElement price2Element=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div"));
        return price2Element;
    }


    public WebElement taxloc(WebDriver driver){
        WebElement taxElement=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));
        return taxElement;
    }
    public WebElement actualtotalpriceloc(WebDriver driver){
        WebElement actualtotalpriceElement=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
        return actualtotalpriceElement;
    }
    public WebElement cancelcheckoutloc(WebDriver driver){
        WebElement cancelElement=driver.findElement(By.id("cancel"));
        return cancelElement;
    }
    public WebElement backhomeaftercheckoutloc(WebDriver driver){
        WebElement backlElement=driver.findElement(By.id("back-to-products"));
        return backlElement;
    }

    public WebElement cartitemsloc(WebDriver driver){
        WebElement itemsElement=driver.findElement(By.id("cart_contents_container"));
        return itemsElement;
    }





}

