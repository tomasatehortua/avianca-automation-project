package screens.youtube;

import base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchScreen extends BaseScreen {


    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getVideoByText(String text) {
        String uiSelector = String.format(
                "new UiSelector().className(\"android.view.ViewGroup\").descriptionMatches(\".*%s.*\")",
                text
        );
//        String uiSelector = "new UiSelector().className(\"android.view.ViewGroup\").descriptionMatches(\".*${text}.*\")";
        By locator = AppiumBy.ByAndroidUIAutomator
                .androidUIAutomator(uiSelector);
        waitElementVisibility(locator);

        return driver.findElement(locator);
    }
}
