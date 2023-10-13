package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    //init
    @BeforeMethod
//    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless=new");


        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.get("https://www.avianca.com/co/es/");
    }


    //kill
    @AfterMethod
//    @AfterClass
    public void tearDown() {
//        System.out.println("After test");
//        driver.close();

        driver.quit();
    }

    public void onFailure(){

    }
}
