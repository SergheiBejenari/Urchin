package urchin.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import urchin.POM.Application;

import static org.testng.Assert.assertEquals;

public class Tests extends BaseTest {

    private final Application app = new Application();
    SoftAssert softAssert = new SoftAssert();

    @Epic("Test task")
    @Feature("Verification Urchins Systems")
    @Issue("Test")
    @Test(description = "Test Case #1")
    public void testCase_1() {
        app.homePage().open();
        for (String email : app.countuctUs().readFromFile()) {
            app.homePage().clickOnContactUsHyperLink();
            app.contactUsPage().waitForDisplayed();
            app.contactUsPage().typeIntoRequiredFields("Test", email);
            app.contactUsPage().clickSubmitButton();
            assertEquals(app.contactUsPage().getErrorMessage(),
                    "Please, fix the following errors:");
        }
    }

    @Test(description = "Test Case #1")
    public void testCase_2() {
        app.homePage().open();
        app.homePage().clickOnServicesButton();
        app.servicesPage().waitForDisplayed();
        softAssert.assertEquals(app.servicesPage().getCurrentURL(), "https://urchinsys.com/#services",
                "Invalid URL");
        softAssert.assertEquals(app.servicesPage().getSoftDevelopmentTitle(), "Software Development",
                "Titles different");
        softAssert.assertEquals(app.servicesPage().getSoftDevelopmentInfo(),
                "Fully tailored software development to help your business achieve scalability, flexibility, and customer-serving efficiency.",
                "Software Development info different");
        app.homePage().clickInstagramButton();
        app.homePage().switchToTabNextTab();
        app.urchinAccountInstagramPage().waitForDisplayed();
        softAssert.assertEquals(app.servicesPage().getCurrentURL(), "https://www.instagram.com/urchinsys/",
                "Invalid URL");
        softAssert.assertEquals(app.urchinAccountInstagramPage().getSoftProfileNameText(), "urchinsys",
                "Profile Name don't match");
        softAssert.assertEquals(app.urchinAccountInstagramPage().getSoftProfileFullNameText(), "Urchin Systems",
                "Profile Full Name don't match");
        softAssert.assertEquals(app.urchinAccountInstagramPage().getSoftProfileDescriptionsText(),
                "We are a software company that delivers innovative solutions and services through creativity. Join our team!",
                "Profile description don't match");
        softAssert.assertAll();
    }

    @Test(description = "Test Case #1")
    public void testCase_3() {
        app.homePage().open();
        app.homePage().clickLinkedinButton();
        app.homePage().switchToTabNextTab();
        app.urchinAccountLinkedInPage().clickSeeJobsButton();
        app.urchinSystemsJobsPage().getAvailableJobs();
        assertEquals(app.urchinSystemsJobsPage().ifJobAvailable("Support Specialist"), true,
                "Support Specialist not found, but was found next available jobs: " +
                        app.urchinSystemsJobsPage().getAvailableJobs());
    }
}
