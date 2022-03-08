package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/urchinsys']")
    private WebElement linkedInButton;

    @FindBy(xpath = "//a[@aria-label='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='https://urchinsys.com/contact-us/']")
    private WebElement contactUsHyperlink;

    @FindBy(xpath = "(//a[@href='https://urchinsys.com/services/'])[1]")
    private WebElement servicesButton;

    @FindBy(xpath = "//a[@href='https://www.instagram.com/urchinsys/?hl=en']")
    private WebElement instagramButton;

    @FindBy(css = ".form-signin-alert")
    private WebElement errorMessageSel;

    public HomePage(Application app) {
        super(app);
    }

    @Step("Users accessed to Urchin Home Page")
    public void open() {
        getDriver().get(baseUrl);
    }

    @Step("User clicks to the Contact us hyper link")
    public void clickOnContactUsHyperLink() {
        clickToElement(contactUsHyperlink);
    }

    @Step("User clicks to the Services Button")
    public void clickOnServicesButtonActions() {
        actions.click(servicesButton)
                .build().perform();
    }

    @Step("User click to Services Button")
    public void clickOnServicesButton() {
        clickToElement(servicesButton);
    }

    @Step("Pay attention to error message displayed")
    public String getErrorMessage() {
        return errorMessageSel.getAttribute("innerText");
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(contactUsHyperlink));
    }

    @Step("User clicks to the instagram button from the footer")
    public void clickInstagramButton() {
        clickToElement(instagramButton);
    }

    @Step("User clicks to the linkedIn button from the footer")
    public void clickLinkedinButton() {
        clickToElement(linkedInButton);
    }

    @Step("User clicks to the sing in button")
    public void clickSignInButton() {
        clickToElement(signInButton);
    }

}
