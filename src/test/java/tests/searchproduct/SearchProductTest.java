package tests.searchproduct;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.Header;
import pages.common.credentialsapi.User;
import dataprovider.CredentialsDataProvider;
import pages.home.HomePage;
import pages.products.ProductsPage;
import pages.signuplogin.SignupLoginPage;
import pages.signuplogin.forms.LoginForm;
import tests.BaseTest;

/**
 * class for search product.
 *
 * @author Hovhannes Mkrtchyan
 *
 */
public class SearchProductTest extends BaseTest {

    private static Header header;
    private User validUser;


    @BeforeMethod
    public void setup(){
        CredentialsDataProvider userDataProvider = new CredentialsDataProvider();
        validUser = userDataProvider.getValidUser().orElseThrow(() -> new RuntimeException("Failed to load valid user data"));
        header = new Header(driver);
        header.clickOnSignUpLogin();
    }

    @Test
    public void verifySearchFunctionality() {
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);

        LoginForm loginForm =  signupLoginPage.onLogin();
        loginForm.fill(validUser);
        loginForm.clickOnLoginButton();
        HomePage homePage = new HomePage(driver);
        Assertions.assertThat(homePage.featuresItemsTitle.isDisplayed()).isTrue();

        header.clickOnProductIcon();
        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertThat(productsPage.allProductsTitle.isDisplayed()).isTrue();
        productsPage.searchProduct("White");
        productsPage.isSearchedTextPresentInItems("White");
    }

}
