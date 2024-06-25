package pages.createaccount.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.common.intarfaces.FormSection;
import pages.common.credentialsapi.User;
import helpers.ElementsHelps;
import helpers.WaitHelps;

public class EnterAccountSectionPage extends BasePage<EnterAccountSectionPage> implements FormSection {

    private final WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement titleMrsRadioButton;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayOfBirthDropDown;

    @FindBy(id = "months")
    private WebElement monthOfBirthDropDown;

    @FindBy(id = "years")
    private WebElement yearOfBirthDropDown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckBox;


    public EnterAccountSectionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        WaitHelps.getWait().waitUntilElementToBeVisible(titleMrRadioButton);

    }

    @Override
    public void fill(User user) {
        selectGender(user.gender());
        enterPassword(user.password());
        selectDateOfBirth(user.dayOfBirth(), user.monthOfBirth(), user.yearOfBirth());
        checkNewsletter(user.newsletter());
        checkSpecialOffers(user.specialOffers());
    }

    private void selectGender(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            titleMrRadioButton.click();
        } else if (title.equalsIgnoreCase("Mrs")) {
            titleMrsRadioButton.click();
        }
    }

    private String getName() {
        return nameInput.getText();
    }

    private String getEmail() {
       return emailInput.getText();
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void selectDateOfBirth(String day, String month, String year) {
        ElementsHelps.scrollToElement(dayOfBirthDropDown , driver);
        ElementsHelps.selectByValue(dayOfBirthDropDown , day);
        ElementsHelps.selectByValue(monthOfBirthDropDown , month);
        ElementsHelps.selectByValue(yearOfBirthDropDown , year);
    }

    private void checkNewsletter(boolean subscribe) {
        if (subscribe) {
            ElementsHelps.scrollToElement(specialOffersCheckBox , driver);
            newsletterCheckBox.click();
        }
    }

    private void checkSpecialOffers(boolean subscribe) {
        if (subscribe) {
            ElementsHelps.scrollToElement(specialOffersCheckBox , driver);
            specialOffersCheckBox.click();
        }
    }

}
