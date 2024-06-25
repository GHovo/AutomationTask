package tests.scroll;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.home.HomePage;
import tests.BaseTest;
import helpers.ElementsHelps;

/**
 * class for scroll up and down.
 *
 * @author Hovhannes Mkrtchyan
 *
 */
public class ScrollTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyScrollFunctionality() {
        Assertions.assertThat(homePage.featuresItemsTitle.isDisplayed()).isTrue();

        ElementsHelps.scrollToBottom(driver);
        Assertions.assertThat(homePage.subscriptionTitle.isDisplayed()).isTrue();

        ElementsHelps.scrollToTop(driver);

        Assertions.assertThat(homePage.fullFledgedTitle.size()).isGreaterThan(0);

    }
}
