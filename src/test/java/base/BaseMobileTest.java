package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import screens.youtube.WelcomeScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseMobileTest {

    Dotenv dotenv = Dotenv.load();
    public static AppiumDriver driver;

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = this.environmentSetup();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities);
        }catch (MalformedURLException exception){
            exception.printStackTrace();
        }
    }

    private DesiredCapabilities environmentSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotenv.get("device_name"));
//        capabilities.setCapability(MobileCapabilityType.APP, dotenv.get("app_path"));
        capabilities.setCapability("appPackage", "com.google.android.youtube");
        capabilities.setCapability("appActivity",
                "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("automationName", "UiAutomator2");

        return capabilities;
    }

    public WelcomeScreen getHomeScreen(){
        return new WelcomeScreen(driver);
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }
}
