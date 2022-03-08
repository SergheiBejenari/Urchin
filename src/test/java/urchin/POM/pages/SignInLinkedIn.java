package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class SignInLinkedIn extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    private WebElement signInTitle;

    @FindBy(xpath = "//h1[contains(text(),'Join LinkedIn')]")
    private WebElement joinTitle;

    @FindBy(xpath = "//input[@id='email-or-phone']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement submitButton;

    @FindBy(css = ".no-results__main-title-keywords")
    private WebElement couldNotFindJobsTitle;

    @FindBy(xpath = "///a[text()='Join now']")
    private WebElement verificationPage;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/login?emailAddress=&fromSignIn=&fromSignIn=true&session_redirect=https%3A%2F%2Fwww.linkedin.com%2Fjobs%2Furchin-systems-jobs-worldwide%3Ff_C%3D11720537%26trk%3Dtop-card_top-card-primary-button-top-card-primary-cta&trk=public_jobs_nav-header-signin']")
    private WebElement signInButton;

    public SignInLinkedIn(Application app) {
        super(app);
    }

    @Step("User types credentials")
    public void typeCredentials(String userName, String password) {
        typeJS(emailField, userName);
        typeJS(passwordField, password);
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(emailField));
        wait.until(ExpectedConditions.visibilityOfAllElements(passwordField));
        wait.until(ExpectedConditions.visibilityOfAllElements(submitButton));
    }

    @Step("Is Sign In title displayed")
    public boolean isPresentSingIn() {
        return isElementPresent(signInTitle);
    }

    @Step("Is Join Linked In title displayed")
    public boolean isPresentJoinLinkedIn() {
        return isElementPresent(By.xpath("/h1[contains(text(),'Join LinkedIn')]"));
    }

    @Step("User clicks to Sing In button")
    public void clickSignInButton() {
        click(signInButton);
    }

    public void clickVerificationButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(verificationPage));
        click(verificationPage);
    }

    @Step("Is could not find jobs title displayed")
    public boolean isPresentCouldNotFindJobs() {
        return isElementPresent(couldNotFindJobsTitle);
    }

}
