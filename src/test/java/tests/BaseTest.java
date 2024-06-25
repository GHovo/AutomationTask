package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static configs.Configuration.getBrowserURL;
import static configs.DriverManager.*;
import static configs.DriverManager.getDriver;
import static helpers.WaitHelps.getWait;

public class BaseTest {

  protected  WebDriver driver;

    @BeforeMethod
    public void setUp(){
        initDriver();
        driver = getDriver();
        openMainPage();
    }

    private void openMainPage() {
        driver.get(getBrowserURL());
        getWait().waitForPageLoadComplete(getDriver(),30);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        quitDriver();
    }
}
