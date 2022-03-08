package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class SaveYourCredentialsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Not now']")
    private WebElement notNowButton;

    public SaveYourCredentialsPage(Application app) {
        super(app);
    }

    @Step("Click Log In button")
    public void clickNotNowButton() {
        click(notNowButton);
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(notNowButton));
    }
}
