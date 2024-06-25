package pages.products.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import helpers.WaitHelps;

public class ProductAddedForm extends BasePage<ProductAddedForm> {

    @FindBy(xpath = "//a[u='View Cart']")
    public WebElement vewCart;


    public ProductAddedForm(WebDriver driver) {
        super(driver);
    }

    public void clickOnViewCart() {
        WaitHelps.getWait().waitUntilElementToBeVisible(vewCart);
        vewCart.click();
    }
}
