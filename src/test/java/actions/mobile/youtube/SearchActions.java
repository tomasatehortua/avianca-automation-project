package actions.mobile.youtube;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import screens.youtube.SearchScreen;

public class SearchActions extends SearchScreen {

    public SearchActions(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnVideoThatDescContains(String text){
        WebElement video =  getVideoByText(text);
        video.click();
    }
}
