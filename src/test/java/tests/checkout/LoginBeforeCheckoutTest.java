package tests.checkout;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.checkout.CartPage;
import pages.checkout.CheckoutPage;
import pages.checkout.PaymentPage;
import pages.common.credentialsapi.Card;
import pages.common.Header;
import pages.common.credentialsapi.User;
import dataprovider.CredentialsDataProvider;
import pages.home.HomePage;
import pages.products.ProductDetailsPage;
import pages.products.ProductsPage;
import pages.products.forms.ProductAddedForm;
import pages.signuplogin.SignupLoginPage;
import pages.signuplogin.forms.LoginForm;
import tests.BaseTest;

/**
 * class for login before checkout.
 *
 * @author Hovhannes Mkrtchyan
 *
 */
public class LoginBeforeCheckoutTest extends BaseTest {

    private User validUser;
    private Card validCard;


    @BeforeMethod
    public void setup(){
        CredentialsDataProvider credentialsDataProvider = new CredentialsDataProvider();
        validUser = credentialsDataProvider.getValidUser().orElseThrow(() -> new RuntimeException("Failed to load valid user data"));
        validCard = credentialsDataProvider.getValidCard().orElseThrow(() -> new RuntimeException("Failed to load valid card data"));
        Header header = new Header(driver);
        header.clickOnSignUpLogin();
    }

    @Test
    public void verifyCheckoutFunctionality() {
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        LoginForm loginForm =  signupLoginPage.onLogin();
        loginForm.fill(validUser);
        loginForm.clickOnLoginButton();

        HomePage homePage = new HomePage(driver);
        Assertions.assertThat(homePage.featuresItemsTitle.isDisplayed()).isTrue();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openProductPageWithURL();

        Assertions.assertThat(productsPage.allProductsTitle.isDisplayed()).isTrue();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.openProductDetails(1);

        productDetailsPage.clickOnAddToCartButton();
        ProductAddedForm productAddedForm = new ProductAddedForm(driver);

        productAddedForm.clickOnViewCart();
        CartPage cart = new CartPage(driver);
        cart.clickOnProceedToCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnPlaceOrderButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fill(validCard);
        paymentPage.clickOnPayAndConfirmButton();
    }
}
