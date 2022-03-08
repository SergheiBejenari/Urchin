package urchin.POM.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

import java.util.ArrayList;
import java.util.List;

public class UrchinSystemsJobsPage extends BasePage {
//    private final By urchinSystemsJobsTitle = By.xpath(".company-branding__title");
//    private final By seeJobsButton = By.xpath("//a[contains(text(),'See jobs')]");
//    private final By numberOfApplicants = By.xpath(".num-applicants__caption");

    @FindBy(css = ".company-branding__title")
    private List<WebElement> urchinSystemsJobsTitle;

    @FindBy(css = "//a[contains(text(),'See jobs')]")
    private List<WebElement> seeJobsButton;

    @FindBy(css = ".num-applicants__caption")
    private List<WebElement> numberOfApplicants;

    @FindBy(css = ".base-card__full-link")
    private List<WebElement> availableJobs;

    public UrchinSystemsJobsPage(Application app) {
        super(app);
    }

    @Step("Wait until Patient Listing page is displayed")
    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(urchinSystemsJobsTitle));
        wait.until(ExpectedConditions.visibilityOfAllElements(seeJobsButton));
    }

    @Step("User Clicks to the See Jobs button")
    public void clickSeeJobsButton() {
        click((WebElement) seeJobsButton);
    }

    public ArrayList<String> getAvailableJobs() {
        ArrayList<String> list = new ArrayList<>();
        availableJobs.stream().forEach(s -> {
            click(s);
            list.add(s.getAttribute("innerText"));
        });
        return list;
    }

    public boolean ifJobAvailable(String job) {
        for (String list : getAvailableJobs()) {
            if (list.equals(job)) {
                return true;
            }
        }
        return false;
    }
}
