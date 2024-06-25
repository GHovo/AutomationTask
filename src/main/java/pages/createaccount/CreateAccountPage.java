package pages.createaccount;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.createaccount.forms.AddressInformationSectionPage;
import pages.createaccount.forms.EnterAccountSectionPage;
import helpers.ElementsHelps;

public class CreateAccountPage extends BasePage<CreateAccountPage>{

    private final WebDriver driver;
    @Getter
    private EnterAccountSectionPage enterAccountSection;
    @Getter
    private AddressInformationSectionPage addressInformationSection;

    @FindBy(css = "[data-qa='create-account']")
    private WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.enterAccountSection = new EnterAccountSectionPage(driver);
        this.addressInformationSection = new AddressInformationSectionPage(driver);
    }

    public void clickCreateAccount() {
        ElementsHelps.scrollToElement(createAccountButton , driver);
        createAccountButton.click();
    }

}
