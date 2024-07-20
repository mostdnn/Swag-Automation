package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    public WebElement usernamepom(WebDriver driver) {
        // Set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find the username element using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        // Reset the implicit wait to the default value (if desired)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        return usernameElement;
    }

    public WebElement passwordpom(WebDriver driver) {
        // Set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find the password element using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        // Reset the implicit wait to the default value (if desired)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        return passwordElement;
    }

    public WebElement loginbuttloc(WebDriver driver) {
        // Set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find the login button element using explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        // Reset the implicit wait to the default value (if desired)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        return loginButtonElement;
    }
    public WebElement errormessagelocforInValidData(WebDriver driver){
        WebElement errormessageElement=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        return errormessageElement;
    }
    public WebElement errormessagelocforEmptyData(WebDriver driver){
        WebElement errormessageElement=driver.findElement(By.xpath("//h3[@data-test='error']"));
        return errormessageElement;
    }



}
