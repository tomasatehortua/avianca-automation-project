package actions.web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import pages.AviancaHomePage;

import static io.qameta.allure.Allure.step;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
public class AviancaHomeActions extends AviancaHomePage {

    public AviancaHomeActions(WebDriver driver) {
        super(driver);
    }

    @Step("Type {0} in origin input")
    public void typeInOriginInput(String text){
//        step(String.format("I type %s as origin city", text));

        waitForElementVisibility(findElementBy(getOriginInput()));
        elementIsDisplayed(getOriginInput());
        sendKeysBy(getOriginInput(), text);
    }

    @Step("Type in destination input")
    public void typeInDestinationInput(String text){
        step(String.format("I type %s as destination city", text));

        waitForElementVisibility(findElementBy(getOriginInput()));
        elementIsDisplayed(getDestinationInput());
        sendKeysBy(getDestinationInput(), text);
    }

    @Step("Verified city is displayed")
    public boolean verifiedCityIsDisplayed(String countryAbbrv) {
        step(String.format("Verified city abbreviation [%s] is displayed", countryAbbrv));

        return elementIsDisplayed(getCityByAbbrv(countryAbbrv));
    }

    @Step("Click on city abbreviation option")
    public void clickOnCityByAbbrv(String countryAbbrv) {
        step(String.format("Click on %s city abbreviation", countryAbbrv));

        findElementBy(getCityByAbbrv(countryAbbrv)).click();
    }

    @Step("Click on out date input")
    public void clickOnOutDateInput(){
        step("Click on out date input");

        findElementBy(getOutDateInput()).click();
    }

    @Step("Click on back date input")
    public void clickOnBackDateInput(){
        step("Click on back date input");

        findElementBy(getBackDateInput()).click();
    }

    @Step("Click on date from calendar")
    public void clickOnDateFromCalendar(String date){
        step(String.format("I selected date: [%s] from calendar", date));

        getDateFromCalendar(date).click();
    }

    @Step("Click on passenger input")
    public void clickOnPassengerInput(){
        step("Click on passenger input");

        findElementBy(getPassengerInput()).click();
    }

    @Step("Click on add adult passenger button")
    public void clickOnAddAdultPassengerButton(){
        step("Click on add adult passenger button");

        getAddAdultPassengerButton().click();
    }

    @Step("Click on add adult passenger button {0} times")
    public void clickOnAddAdultPassengerButton(int times){
        step(String.format("I add [%s] adult passengers", times));

        clickOn(getAddAdultPassengerButton(), times);
    }

    @Step("Click on add child passenger button")
    public void clickOnAddChildPassengerButton(){
        getAddChildPassengerButton().click();
    }

    @Step("Click on add child passenger button {0} times")
    public void clickOnAddChildPassengerButton(int times){
        step(String.format("I add [%s] child passengers", times));
        clickOn(getAddChildPassengerButton(), times);
    }

    @Step("Click on add baby passenger button")
    public void clickOnAddBabyPassengerButton(){
        getAddBabyPassengerButton().click();
    }

    @Step("Click on add baby passenger button {0} times")
    public void clickOnAddBabyPassengerButton(int times){
        step(String.format("I add [%s] baby passengers", times));

        clickOn(getAddBabyPassengerButton(), times);
    }

    @Step("Click on continue with passengers button")
    public void clickOnContinuePassengerButton(){
        step("I continue with selected passengers");

        getContinuePassengerButton().click();
    }

    @Step("Click on search flight button")
    public void clickOnSearchFlightButton(){
        step("I click on search flights");

        findElementBy(getSearchFlightButton()).click();
    }

    @Step("Verified error message is displayed")
    public boolean verifiedErrorIsDisplayed(){
        step("Verified error message is displayed");

        return getErrMsg().isDisplayed();
    }

}
