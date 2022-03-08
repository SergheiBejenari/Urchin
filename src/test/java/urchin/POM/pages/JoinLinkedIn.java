package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class JoinLinkedIn extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    private WebElement signInTitle;

    @FindBy(xpath = "//h1[contains(text(),'Join LinkedIn')]")
    private WebElement joinTitle;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".no-results__main-title-keywords")
    private WebElement couldNotFindJobsTitle;

    @FindBy(xpath = "///a[text()='Join now']")
    private WebElement verificationPage;

    @FindBy(xpath = "(//a[contains(@href, 'https://www.linkedin.com/login')])[1]")
    private WebElement signInButton;

    public JoinLinkedIn(Application app) {
        super(app);
    }

    @Step("User types credentials: %userName, %password")
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

    public void clickSubmitButton() {
        clickToElement(submitButton);
    }

    @Step("Is could not find jobs title displayed")
    public boolean isPresentCouldNotFindJobs() {
        return isElementPresent(couldNotFindJobsTitle);
    }

}
