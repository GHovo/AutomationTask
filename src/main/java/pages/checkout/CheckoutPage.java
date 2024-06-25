package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import helpers.ElementsHelps;


public class CheckoutPage extends BasePage<CheckoutPage> {

    private final WebDriver driver;
    @FindBy(xpath = "//a[text()='Place Order']")
    public WebElement placeOrderButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnPlaceOrderButton() {
        ElementsHelps.scrollToBottom(driver);
        placeOrderButton.click();
    }

}
