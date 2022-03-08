package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class LogInPageInstagram extends BasePage {

    @FindBy(css = "input[name='username']")
    private WebElement userNameField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement logInButton;

    public LogInPageInstagram(Application app) {
        super(app);
    }

    @Step("Is Pop Up displayed")
    public boolean isDisplayed() {
        return isElementPresent(userNameField) && isElementPresent(passwordField);
    }

    @Step("Is LogInPageInstagram contains Ok button")
    public boolean isOkButtonPresent() {
        return isElementPresent(userNameField);
    }

    @Step("Is LogInPageInstagram contains Cross button")
    public boolean isCrossButtonPresent() {
        return isElementPresent(passwordField);
    }

    @Step("Click Log In button")
    public void clickLogInButton() {
        click(logInButton);
    }

    @Step("User types credentials")
    public void typeCredentials(String userName, String password) {
        typeJS(userNameField, userName);
        typeJS(passwordField, password);
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(userNameField));
        wait.until(ExpectedConditions.visibilityOfAllElements(passwordField));
        wait.until(ExpectedConditions.visibilityOfAllElements(logInButton));
    }
}
