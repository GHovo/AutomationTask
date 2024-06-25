package pages.checkout;

import helpers.WaitHelps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class CartPage extends BasePage<CartPage> {

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    public WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProceedToCheckoutButton() {
        WaitHelps.getWait().waitUntilElementToBeVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }

}
