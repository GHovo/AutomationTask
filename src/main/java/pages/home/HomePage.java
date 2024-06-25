package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//h2[text()='Features Items']")
    public WebElement featuresItemsTitle;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscriptionTitle;
    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    public List<WebElement> fullFledgedTitle;


    public HomePage(WebDriver driver) {
        super(driver);
    }

}
