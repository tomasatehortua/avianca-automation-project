package actions.mobile.youtube;

import io.appium.java_client.AppiumDriver;
import screens.youtube.HomeScreen;
import screens.youtube.WelcomeScreen;

public class WelcomeActions extends WelcomeScreen {

    public WelcomeActions(AppiumDriver driver) {
        super(driver);
    }

    public HomeActions clickOnDontAllowNotifications(){
        getDontAllowNotifications().click();
        return new HomeActions(driver);
    }

}
