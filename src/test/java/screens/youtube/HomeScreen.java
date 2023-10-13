package screens.youtube;

import base.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private By searchButton = AppiumBy.ByAndroidUIAutomator
            .androidUIAutomator("new UiSelector()" +
            ".resourceId(\"com.google.android.youtube:id/menu_item_view\")" +
            ".descriptionContains(\"Search\")");

    @AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
    private WebElement searchInputText;



    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getSearchButton() {
        waitElementVisibility(searchButton);

        return driver.findElement(searchButton);
    }

    public WebElement getSearchInputText() {
        return searchInputText;
    }


}
