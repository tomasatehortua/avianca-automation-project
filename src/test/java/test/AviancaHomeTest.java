package test;

import actions.AviancaHomeActions;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.OffsetDateTime;


public class AviancaHomeTest extends BaseTest {

    static AviancaHomeActions aviancaHomeActions;

    @BeforeMethod
//    @BeforeClass
    public void setupPages(){
        aviancaHomeActions = new AviancaHomeActions(driver);
    }

    @Test
    public void typeNormalInput(){
        aviancaHomeActions.typeInOriginInput("Medellin");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
    }

    @Test
    public void typeUppercaseInput(){
        aviancaHomeActions.typeInOriginInput("MEDELLIN");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
    }

    @Test
    public void typeAccentuatedInput(){
        aviancaHomeActions.typeInOriginInput("MEDELLÍN");
        Assert.assertTrue(aviancaHomeActions.verifiedCityIsDisplayed("MDE"));
    }

    @Test
    public void typeNonExistingCity(){
        aviancaHomeActions.typeInOriginInput("CiudadMuyFachera");
        Assert.assertFalse(aviancaHomeActions.verifiedErrorIsDisplayed());
//        Assert.assertTrue(aviancaHomeActions.verifiedErrorIsDisplayed());
    }

    @Test
    public void happyEndToEnd(){
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
