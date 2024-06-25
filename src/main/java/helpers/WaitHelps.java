package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configs.DriverManager.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WaitHelps {

    private static final int TIMEOUT = 30;

    private static final int LONG_TIMEOUT = 50;

    private static WebDriverWait wait;


    public static WaitHelps getWait() {
        return getCustomWait();
    }

    private static WaitHelps getCustomWait() {
        WaitHelps waitUtils = new WaitHelps();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WaitHelps.TIMEOUT), Duration.ofMillis(LONG_TIMEOUT));
        return waitUtils;
    }

    public void waitUntilElementToBeVisible(WebElement element) {
        wait.until(visibilityOf(element));
    }

    public void waitForPageLoadComplete(WebDriver driver, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(LONG_TIMEOUT));
        wait.until((driver1) -> String.valueOf(((JavascriptExecutor)driver1)
                .executeScript("return document.readyState")).equals("complete"));
    }

}
