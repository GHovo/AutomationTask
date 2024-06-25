package pages.signuplogin;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.signuplogin.forms.LoginForm;
import pages.signuplogin.forms.SignupForm;


public class SignupLoginPage extends BasePage<SignupLoginPage> {

    private final WebDriver driver;

    public SignupLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginForm onLogin() {
       return new LoginForm(driver);
    }
    public SignupForm onSignUp() {
       return new SignupForm(driver);
    }

}
