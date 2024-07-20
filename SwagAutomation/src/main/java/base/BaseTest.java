package base;

import Pages.Addtocartpage;
import Pages.Logoutpage;
import Pages.checkoutpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import Pages.Loginpage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static Loginpage loginLoc=new Loginpage();
    public static Logoutpage logoutLoc= new Logoutpage();
    public static Addtocartpage addtocartLoc= new Addtocartpage();
    public static checkoutpage checkoutLoc= new checkoutpage();

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        driver = new ChromeDriver();
        FileReader Read=new FileReader("src\\test\\Resources\\configfiles\\config.properties");
        Properties prop=new Properties();
        prop.load(Read);
        driver.manage().window().maximize(); // Set full-screen mode
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        driver = new ChromeDriver();
        FileReader Read=new FileReader("src\\test\\Resources\\configfiles\\config.properties");
        Properties prop=new Properties();
        prop.load(Read);
        driver.manage().window().maximize();
        // Navigate to the login page
        driver.get(prop.getProperty("url"));
    }



        public void login(String username, String password) {
        // Set the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find and interact with the username element
        WebElement usernameElement = loginLoc.usernamepom(driver);
        usernameElement.sendKeys(username);

        // Find and interact with the password element
        WebElement passwordElement = loginLoc.passwordpom(driver);
        passwordElement.sendKeys(password);

        // Find and click the login button element
        WebElement loginButtonElement = loginLoc.loginbuttloc(driver);
        loginButtonElement.click();

        // Reset the implicit wait to the default value (if desired)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }





    @AfterTest
    public void aftertest(){
        driver.quit();
    }

    @AfterMethod
    public void aftermethod(){
        driver.quit();
    }






}

