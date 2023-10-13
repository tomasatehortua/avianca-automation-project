package screens.youtube;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomeScreen extends BaseScreen {

    @AndroidFindBy(id =
            "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement dontAllowNotifications;


    public WelcomeScreen(AppiumDriver driver){
        super(driver);
    }

    public WebElement getDontAllowNotifications() {
        return dontAllowNotifications;
    }


}
