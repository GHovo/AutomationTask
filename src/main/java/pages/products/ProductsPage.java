package pages.products;

import constants.products.ProductsConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import helpers.WaitHelps;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage<ProductsPage> {

    private final WebDriver driver;
    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProductsTitle;
    @FindBy(id = "search_product")
    public WebElement searchInput;

    @FindBy(id = "div>h2~p")
    public List<WebElement> searchedItems;


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openProductPageWithURL() {
        driver.get(ProductsConstants.URL);
    }
    public List<String> getSearchedItemTexts() {
        return searchedItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isSearchedTextPresentInItems(String text) {
        return getSearchedItemTexts().stream()
                .allMatch(itemText -> itemText.contains(text));
    }

    public void searchProduct(String productTitle) {
        WaitHelps.getWait().waitUntilElementToBeVisible(searchInput);
        searchInput.sendKeys(productTitle);
    }

}
