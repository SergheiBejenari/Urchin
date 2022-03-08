package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class UrchinAccountInstagramPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'urchinsys')]")
    private WebElement profileName;

    @FindBy(xpath = "//span[contains(text(),'Urchin Systems')]")
    private WebElement profileFullName;

    @FindBy(xpath = "//div[contains(text(),'We are a software company that delivers innovative solutions and services through creativity. Join our team!')]")
    private WebElement profileDescription;

    public UrchinAccountInstagramPage(Application app) {
        super(app);
    }

    @Step("Wait until Patient Listing page is displayed")
    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(profileName));
        wait.until(ExpectedConditions.visibilityOfAllElements(profileFullName));
        wait.until(ExpectedConditions.visibilityOfAllElements(profileDescription));
    }

    public String getSoftProfileNameText() {
        return profileName.getAttribute("innerText");
    }

    public String getSoftProfileFullNameText() {
        return profileFullName.getAttribute("innerText");
    }

    public String getSoftProfileDescriptionsText() {
        return profileDescription.getAttribute("innerText");
    }
}
