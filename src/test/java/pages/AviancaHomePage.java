package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AviancaHomePage extends BasePage {

    By originInput = By.cssSelector("fieldset div.form-group.new-animate input[data-name='pbOrigen']");
    By destinationInput = By.cssSelector("fieldset div.form-group.new-animate input[data-name='pbDestino']");
    By listCountries = By.cssSelector("fieldset div.bs-list-countries");
    By outDateInput = By.cssSelector("fieldset input[name='pbFechaIda'");
    By backDateInput = By.cssSelector("fieldset input[name='pbFechaRegreso'");
    By calendarPlugin = By.cssSelector("div[data-x-plugin='calendar-av'][data-source='ida'][data-close-select='true']");
    By passengerInput = By.cssSelector("fieldset input[name='pbPasajeros'");
    By searchFlightButton = By.cssSelector("fieldset button[title='Buscar vuelos'].btn.primary.btn-codepromo.pull-btn.rojo");

    /*
        passenger plugin elements
    */
    By passengersPlugin = By.cssSelector("fieldset div[data-x-plugin='pasajeros-av'][data-noshowclass='true'][data-source='passenger.normal'][data-cabin='true']");
    By addAdultPassengerButton = By.cssSelector("div[data-property='adults'][role='button'].plus.control");
    By addChildPassengerButton = By.cssSelector("div[data-property='child'][role='button'].plus.control");
    By addBabyPassengerButton = By.cssSelector("div[data-property='infant'][role='button'].plus.control");
    By continuePassengerButton = By.cssSelector("button[aria-label='Continuar, cerrar cuadro de pasajeros'].hidden-xs");

    public AviancaHomePage(WebDriver driver) {
        super(driver);
    }

    public By getOriginInput() {
        return originInput;
    }

    public By getDestinationInput() {
        return destinationInput;
    }

    public By getListCountries() {
        return listCountries;
    }

    public By getOutDateInput() {
        return outDateInput;
    }

    public By getBackDateInput() {
        return backDateInput;
    }

    public By getPassengerInput() {
        return passengerInput;
    }

    public By getSearchFlightButton(){
        return searchFlightButton;
    }

    public By getPassengersPlugin() {
        return passengersPlugin;
    }

    public By getCityByAbbrv(String countryAbbrv) {
        return By.cssSelector(String.format("li[data-city='%s']", countryAbbrv));
    }

    //Ask if is better to use web elements or manage elements using By
    public WebElement getErrMsg() {
        return findElementBy(listCountries).findElement(By.cssSelector("div.item"));
    }

    public WebElement getDateFromCalendar(String date) {
        String dateSelector = String.format("div[data-day='%s']", date);
        return findElementBy(calendarPlugin).findElement(By.cssSelector(dateSelector));
    }

    public WebElement getAddAdultPassengerButton() {
        return findElementBy(passengersPlugin)
                .findElement(addAdultPassengerButton);
    }

    public WebElement getAddChildPassengerButton() {
        return findElementBy(passengersPlugin)
                .findElement(addChildPassengerButton);
    }

    public WebElement getAddBabyPassengerButton() {
        return findElementBy(passengersPlugin)
                .findElement(addBabyPassengerButton);
    }

    public WebElement getContinuePassengerButton() {
        return findElementBy(passengersPlugin)
                .findElement(continuePassengerButton);
    }
}
