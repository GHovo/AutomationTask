package pages.products;

import constants.productdetails.ProductDetailsConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProductDetailsPage extends BasePage<ProductDetailsPage> {

    private final WebDriver driver;
    @FindBy(xpath = "//span//button")
    public WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void openProductDetails(int index) {
        driver.get(ProductDetailsConstants.URL + index);
    }
}
