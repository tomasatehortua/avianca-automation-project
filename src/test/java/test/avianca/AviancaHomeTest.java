package test.avianca;

import actions.web.AviancaHomeActions;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.OffsetDateTime;


public class AviancaHomeTest extends BaseTest {

    static AviancaHomeActions aviancaHomeActions;

    @BeforeMethod
//    @BeforeClass
    public void setupPage() {
        aviancaHomeActions = new AviancaHomeActions(driver);
        aviancaHomeActions.implicitWait(2);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(description = "Type origin input normal case")
    @Epic("Home test")
    @Feature("Essential feature")
    @Story("Home searchbar")
    public void typeNormalInput() {
        aviancaHomeActions.typeInOriginInput("Medellin");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
    }

    @Test(description = "Type origin input upper case")
    public void typeUppercaseInput() {
        aviancaHomeActions.typeInOriginInput("MEDELLIN");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
    }

    @Test(description = "Type origin input accentuated")
    public void typeAccentuatedInput() {
        aviancaHomeActions.typeInOriginInput("MEDELLÍN");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
    }

    @Test(description = "Type origin input non existing city")
    public void typeNonExistingCity() {
        aviancaHomeActions.typeInOriginInput("CiudadMuyFachera");
        Assert.assertFalse(aviancaHomeActions.verifiedErrorIsDisplayed());
//        Assert.assertTrue(aviancaHomeActions.verifiedErrorIsDisplayed());
    }

    @Test(description = "Search flight with passengers")
    public void happyEndToEnd() {
        aviancaHomeActions.typeInOriginInput("Medellín");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
        aviancaHomeActions.clickOnCityByAbbrv("MDE");
        aviancaHomeActions.typeInDestinationInput("Bogotá");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("BOG"));
        aviancaHomeActions.clickOnCityByAbbrv("BOG");

        aviancaHomeActions.clickOnOutDateInput();
        OffsetDateTime currentDate = Utils.getCurrentDate();
        aviancaHomeActions.clickOnDateFromCalendar(Utils.formattedDate(currentDate));
        aviancaHomeActions.clickOnBackDateInput();
        OffsetDateTime futureDate = Utils.getRandomFutureDate();
        aviancaHomeActions.clickOnDateFromCalendar(Utils.formattedDate(futureDate));

        aviancaHomeActions.clickOnPassengerInput();
        aviancaHomeActions.clickOnAddAdultPassengerButton(5);
        aviancaHomeActions.clickOnAddChildPassengerButton(2);
        aviancaHomeActions.clickOnAddBabyPassengerButton(3);
        aviancaHomeActions.clickOnContinuePassengerButton();

//        aviancaHomeActions.clickOnSearchFlightButton();
    }


}
