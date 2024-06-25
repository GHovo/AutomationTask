package pages.signuplogin.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.common.credentialsapi.User;
import pages.common.intarfaces.FormSection;
import helpers.Helps;
import helpers.WaitHelps;

public class SignupForm extends BasePage<SignupForm> implements FormSection {

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement inputSignUpName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement inputSignUpEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    public SignupForm(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name) {
        WaitHelps.getWait().waitUntilElementToBeVisible(inputSignUpName);
        inputSignUpName.sendKeys(name);
    }
    public void typeEmail(String email) {
        inputSignUpEmail.sendKeys(email);
    }
    public void clickOnSignupButton() {
        signUpButton.click();
    }


    @Override
    public void fill(User user) {
        typeName(user.name());
        typeEmail(Helps.generateRandomEmail());
    }
}
