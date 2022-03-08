package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

public class ServicesPage extends BasePage {

    @FindBy(xpath = "(//h1//span[text()='SERVICES'])[1]")
    private WebElement servicesTitle;

    @FindBy(xpath = "//h2//b[contains(text(),'Software Development')]")
    private WebElement softDevelopmentTitle;

    @FindBy(xpath = "//p//span[contains(text(),'Fully tailored software development to help your business achieve scalability, flexibility, and customer-serving efficiency.')]")
    private WebElement softDevelopmentInfo;

    public ServicesPage(Application app) {
        super(app);
    }

    @Step("Is Completed button displayed")
    public boolean isCompletedButtonPresent() {
        return isElementPresent(softDevelopmentInfo);
    }

    @Step("Is Services title displayed")
    public boolean isPresent() {
        return isElementPresent(servicesTitle);
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(servicesTitle));
        wait.until(ExpectedConditions.visibilityOfAllElements(softDevelopmentTitle));
        wait.until(ExpectedConditions.visibilityOfAllElements(softDevelopmentInfo));
    }

    public String getSoftDevelopmentTitle() {
        return softDevelopmentTitle.getAttribute("innerText");
    }

    public String getSoftDevelopmentInfo() {
        return softDevelopmentInfo.getAttribute("innerText");
    }
}
