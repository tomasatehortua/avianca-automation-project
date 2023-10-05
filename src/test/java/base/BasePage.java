package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> fluentWait(int timeoutSec) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutSec))
                .pollingEvery(Duration.ofMillis(
                        Integer.parseInt("10000")))
                .ignoring(NoSuchElementException.class);
    }

    public boolean waitForElementVisibility(WebElement element) {
        try {
            fluentWait(10).until(ExpectedConditions.visibilityOf(element));
            return TRUE;
        } catch (Exception e) {
//            log.error("Element " + element.toString() + " is not visible after " + 5 + " seconds",
//                    e);
            return FALSE;
        }
    }


    public WebElement findElementBy(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElementsBy(By locator) {
        return driver.findElements(locator);
    }

    public Boolean elementIsDisplayed(By locator) {
        try {
            return findElementBy(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitDriver(Long duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
//        new WebDriverWait(_driver, Duration.ofSeconds(time));
    }

    public void sendKeysBy(By locator, String keys) {
        findElementBy(locator).sendKeys(keys);
    }

    public String getTextBy(By locator) {

        return findElementBy(locator).getText();
    }

    public String getAttributeBy(By locator, String attribute) {
        return findElementBy(locator).getAttribute(attribute);
    }

    public void clickOn(WebElement element, int times){
        while (times > 0){
            element.click();
            times--;
        }
    }



}
