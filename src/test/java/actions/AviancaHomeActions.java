package actions;

import org.openqa.selenium.WebDriver;
import pages.AviancaHomePage;

public class AviancaHomeActions extends AviancaHomePage {

    public AviancaHomeActions(WebDriver driver) {
        super(driver);
    }

    public void typeInOriginInput(String text){
//        waitForElementVisibility(findElementBy(originInput));
        elementIsDisplayed(getOriginInput());
        sendKeysBy(getOriginInput(), text);
    }

    public void typeInDestinationInput(String text){
//        waitForElementVisibility(findElementBy(originInput));
        elementIsDisplayed(getDestinationInput());
        sendKeysBy(getDestinationInput(), text);
    }

    public boolean verifiedCityIsDisplayed(String countryAbbrv) {
        return elementIsDisplayed(getCityByAbbrv(countryAbbrv));
    }

    public void clickOnCityByAbbrv(String countryAbbrv) {
        findElementBy(getCityByAbbrv(countryAbbrv)).click();
    }

    public void clickOnOutDateInput(){
        findElementBy(getOutDateInput()).click();
    }

    public void clickOnBackDateInput(){
        findElementBy(getBackDateInput()).click();
    }

    public void clickOnDateFromCalendar(String date){
        getDateFromCalendar(date).click();
    }

    public void clickOnPassengerInput(){
        findElementBy(getPassengerInput()).click();
    }

    public void clickOnAddAdultPassengerButton(){
        getAddAdultPassengerButton().click();
    }

    public void clickOnAddAdultPassengerButton(int times){
        clickOn(getAddAdultPassengerButton(), times);
    }

    public void clickOnAddChildPassengerButton(){
        getAddChildPassengerButton().click();
    }

    public void clickOnAddChildPassengerButton(int times){
        clickOn(getAddChildPassengerButton(), times);
    }

    public void clickOnAddBabyPassengerButton(){
        getAddBabyPassengerButton().click();
    }

    public void clickOnAddBabyPassengerButton(int times){
        clickOn(getAddBabyPassengerButton(), times);
    }

    public void clickOnContinuePassengerButton(){
        getContinuePassengerButton().click();
    }

    public void clickOnSearchFlightButton(){
        findElementBy(getSearchFlightButton()).click();
    }

    public boolean verifiedErrorIsDisplayed(){

        return getErrMsg().isDisplayed();
    }

}
