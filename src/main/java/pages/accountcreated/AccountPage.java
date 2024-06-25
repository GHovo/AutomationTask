package pages.accountcreated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AccountPage extends BasePage<AccountPage> {

    @FindBy(xpath = "//h2[b[text()='Account Created!']]")
    public WebElement accountCreatedMassage;
    @FindBy(xpath = "//h2[b[text()='Account Deleted!']]")
    public WebElement accountDeletedMassage;
    @FindBy(css = "[data-qa='continue-button']")
    public WebElement continueButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
