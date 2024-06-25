package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import helpers.WaitHelps;

public class Header extends BasePage<Header> {


    @FindBy(xpath = "//a[text()=' Home'")
    public  WebElement homeIcon;
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public  WebElement signupLogin;
    @FindBy(xpath = "//a[text()=' Delete Account']")
    public  WebElement deleteIcon;
    @FindBy(xpath = "//a[text()=' Products']")
    public  WebElement productsIcon;
    @FindBy(xpath = "//a[text()=' Cart']")
    public  WebElement cartIcon;
    @FindBy(xpath = "//a[contains(text(),' Logged in as')] ")
    public  WebElement loggedInAsName;


    public Header(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
       return loggedInAsName.getText();
    }
    public void clickOnHome() {
        WaitHelps.getWait().waitUntilElementToBeVisible(homeIcon);
        homeIcon.click();
    }
    public void clickOnSignUpLogin() {
        WaitHelps.getWait().waitUntilElementToBeVisible(signupLogin);
        signupLogin.click();
    }
    public void clickOnProductIcon() {
        WaitHelps.getWait().waitUntilElementToBeVisible(productsIcon);
        productsIcon.click();
    }
    public void clickOnDeleteIcon() {
        WaitHelps.getWait().waitUntilElementToBeVisible(deleteIcon);
        deleteIcon.click();
    }

}
