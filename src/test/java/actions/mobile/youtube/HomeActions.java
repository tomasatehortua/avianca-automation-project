package actions.mobile.youtube;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import screens.youtube.HomeScreen;

public class HomeActions extends HomeScreen {


    public HomeActions(AppiumDriver driver) {
        super(driver);
    }


    public void clickOnSearchButton(){
        WebElement searchButton = getSearchButton();
        searchButton.click();
    }

    public void typeOnSearchInputText(String text){
        getSearchInputText().sendKeys(text);
    }

    public SearchActions searchInputTyped(){
        pressEnter();
        return new SearchActions(driver);
    }
}
