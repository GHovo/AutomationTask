package pages.createaccount.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.common.intarfaces.FormSection;
import pages.common.credentialsapi.User;
import helpers.ElementsHelps;

public class AddressInformationSectionPage extends BasePage<AddressInformationSectionPage> implements FormSection {

    private final WebDriver driver;
    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;


    public AddressInformationSectionPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void fill(User user) {
        enterFirstName(user.firstName());
        enterLastName(user.lastName());
        enterCompany(user.company());
        enterAddress(user.address());
        selectCountry(user.country());
        enterState(user.state());
        enterCity(user.city());
        enterZipcode(user.zipcode());
        enterMobileNumber(user.mobileNumber());
    }

    private void enterFirstName(String firstName) {
        ElementsHelps.scrollToElement(firstNameInput , driver);
        firstNameInput.sendKeys(firstName);
    }

    private void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    private void enterCompany(String company) {
        companyInput.sendKeys(company);
    }

    private void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    private void selectCountry(String country) {
        countryDropDown.sendKeys(country);
    }

    private void enterState(String state) {
        stateInput.sendKeys(state);
    }

    private void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    private void enterZipcode(String zipcode) {
        zipcodeInput.sendKeys(zipcode);
    }

    private void enterMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }
}
