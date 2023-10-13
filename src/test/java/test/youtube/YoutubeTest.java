package test.youtube;

import actions.mobile.youtube.HomeActions;
import actions.mobile.youtube.SearchActions;
import actions.mobile.youtube.WelcomeActions;
import base.BaseMobileTest;
import org.testng.annotations.Test;


public class YoutubeTest extends BaseMobileTest {


    @Test()
    public void searchVideo(){
        WelcomeActions WelcomeScreenActions = new WelcomeActions(driver);
        HomeActions homeScreenActions = WelcomeScreenActions.clickOnDontAllowNotifications();
        homeScreenActions.clickOnSearchButton();
        homeScreenActions.typeOnSearchInputText("Ferxxo Edition");
        SearchActions searchScreenActions = homeScreenActions.searchInputTyped();
        searchScreenActions.clickOnVideoThatDescContains("Feid");
    }
}
