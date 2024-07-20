package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logoutpage {


    public WebElement logoutbuttonloc(WebDriver driver){
        By logoutbutton=By.id("logout_sidebar_link");
        WebElement logoutElement=driver.findElement(logoutbutton);
        return logoutElement;
    }

    public WebElement menubuttonloc(WebDriver driver){
        By menubutton=By.id("react-burger-menu-btn");
        WebElement menubuttonElement=driver.findElement(menubutton);
        return menubuttonElement;
    }


}


