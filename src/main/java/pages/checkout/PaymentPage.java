package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.common.credentialsapi.Card;
import helpers.WaitHelps;

public class PaymentPage extends BasePage<PaymentPage> {

    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement inputNameOnCard;
    @FindBy(xpath = "//input[@name='card-number']")
    public WebElement inputCardNumber;
    @FindBy(xpath = "//input[@name='cvc']")
    public WebElement inputCvc;
    @FindBy(xpath = "//input[@name='expiry_month']")
    public WebElement inputExpiryMonth;
    @FindBy(xpath = "//input[@name='expiry_year']")
    public WebElement inputExpiryYear;
    @FindBy(id = "submit")
    public WebElement payAndConfirmButton;


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fill(Card card) {
        enterCardName(card.name());
        enterCardNumber(card.number());
        enterCvc(card.cvc());
        enterExpiryMonth(card.expiryMonth());
        enterExpiryYear(card.expiryYear());
    }

    private void enterCardName(String nameOnCurd) {
        WaitHelps.getWait().waitUntilElementToBeVisible(inputNameOnCard);
        inputNameOnCard.sendKeys(nameOnCurd);
    }
    private void enterCardNumber(String curdNumber) {
        WaitHelps.getWait().waitUntilElementToBeVisible(inputCardNumber);
        inputCardNumber.sendKeys(curdNumber);
    }
    private void enterCvc(String cvc) {
        inputCvc.sendKeys(cvc);
    }

    private void enterExpiryMonth(String month) {
        inputExpiryMonth.sendKeys(month);
    }

    private void enterExpiryYear(String year) {
        inputExpiryYear.sendKeys(year);
    }

    public void clickOnPayAndConfirmButton() {
        payAndConfirmButton.click();
    }

}
