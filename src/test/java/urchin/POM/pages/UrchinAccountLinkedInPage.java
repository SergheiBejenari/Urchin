package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class UrchinAccountLinkedInPage extends BasePage {

    @FindBy(css = ".top-card-layout__title")
    private WebElement profileName;

    @FindBy(xpath = "//a[contains(text(),'See jobs')]")
    private WebElement seeJobsButton;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/login?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2Fcompany%2Furchinsys&fromSignIn=true&trk=organization_guest_nav-header-signin']")
    private WebElement signInButton;

    public UrchinAccountLinkedInPage(Application app) {
        super(app);
    }

    @Step("Wait until Patient Listing page is displayed")
    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(seeJobsButton));
        wait.until(ExpectedConditions.visibilityOfAllElements(seeJobsButton));
    }

    @Step("User Clicks to the See Jobs button")
    public void clickSeeJobsButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(seeJobsButton));
        click(seeJobsButton);
    }

    @Step("User clicks to Sign In Button")
    public void clickSignInButton() {
        click(signInButton);
    }

    @Step("Is Sign In button displayed")
    public boolean isPresent() {
        isElementPresent(signInButton);
        return false;
    }
}
