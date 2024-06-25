package pages.signuplogin.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.common.credentialsapi.User;
import pages.common.intarfaces.FormSection;
import helpers.WaitHelps;


public class LoginForm extends BasePage<LoginForm> implements FormSection {

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement inputPassword;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void typePassword(String password) {
        WaitHelps.getWait().waitUntilElementToBeVisible(inputPassword);
        inputPassword.sendKeys(password);
    }
    public void typeEmail(String email) {
        inputEmail.sendKeys(email);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Override
    public void fill(User user) {
        typeEmail(user.email());
        typePassword(user.password());
    }
}
