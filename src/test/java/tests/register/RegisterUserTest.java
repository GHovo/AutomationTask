package tests.register;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.accountcreated.AccountPage;
import pages.common.Header;
import pages.common.credentialsapi.User;
import pages.createaccount.CreateAccountPage;
import dataprovider.CredentialsDataProvider;
import pages.home.HomePage;
import pages.signuplogin.SignupLoginPage;
import pages.signuplogin.forms.SignupForm;
import tests.BaseTest;

/**
 * class for register new user.
 *
 * @author Hovhannes Mkrtchyan
 *
 */
public class RegisterUserTest extends BaseTest {

    private static Header header;
    private User validUser;


    @BeforeMethod
    public void setup(){
        CredentialsDataProvider credentialsDataProvider = new CredentialsDataProvider();
        validUser = credentialsDataProvider.getValidUser().orElseThrow(() -> new RuntimeException("Failed to load valid user data"));
        header = new Header(driver);
        header.clickOnSignUpLogin();
    }

    @Test
    public void verifyRegisterFunctionality() {
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);

        SignupForm signupForm = signupLoginPage.onSignUp();
        signupForm.fill(validUser);
        signupForm.clickOnSignupButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.getEnterAccountSection().fill(validUser);
        createAccountPage.getAddressInformationSection().fill(validUser);
        createAccountPage.clickCreateAccount();

        AccountPage accountCreatedPage = new AccountPage(driver);
        Assertions.assertThat(accountCreatedPage.accountCreatedMassage.isDisplayed()).isTrue();
        accountCreatedPage.clickOnContinueButton();
        header.clickOnDeleteIcon();

        AccountPage accountDeleted = new AccountPage(driver);
        Assertions.assertThat(accountDeleted.accountDeletedMassage.isDisplayed()).isTrue();
        accountDeleted.clickOnContinueButton();
        HomePage homePage = new HomePage(driver);
        Assertions.assertThat(homePage.featuresItemsTitle.isDisplayed()).isTrue();
    }

}
