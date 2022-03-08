package urchin.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import urchin.POM.pages.*;
import urchin.utils.DriverFactory;
import urchin.utils.PropertyReader;

public class Application {

    public final String url;
    private final short defaultTimeout;
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ServicesPage servicesPage;
    private ContactUsPage medicationPage;
    private UrchinAccountInstagramPage urchinAccountInstagramPage;
    private ContactUsPage contactUsPage;
    private LogInPageInstagram logInPageInstagram;
    private SaveYourCredentialsPage saveYourCredentialsPage;
    private UrchinAccountLinkedInPage urchinAccountLinkedInPage;
    private UrchinSystemsJobsPage urchinSystemsJobsPage;
    private JoinLinkedIn joinLinkedIn;
    private SignInLinkedIn signInLinkedIn;


    public Application() {
        url = PropertyReader.applicationProperties().getProperty("base.url");
        defaultTimeout = 10;
    }

    public UrchinAccountInstagramPage urchinAccountInstagramPage() {
        if (urchinAccountInstagramPage == null) {
            urchinAccountInstagramPage = new UrchinAccountInstagramPage(this);
        }
        return urchinAccountInstagramPage;
    }

    public ContactUsPage countuctUs() {
        if (medicationPage == null) {
            medicationPage = new ContactUsPage(this);
        }
        return medicationPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(this);
        }
        return homePage;
    }

    public ServicesPage servicesPage() {
        if (servicesPage == null) {
            servicesPage = new ServicesPage(this);
        }
        return servicesPage;
    }

    public ContactUsPage contactUsPage() {
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage(this);
        }
        return contactUsPage;
    }

    public LogInPageInstagram logInPageInstagram() {
        if (logInPageInstagram == null) {
            logInPageInstagram = new LogInPageInstagram(this);
        }
        return logInPageInstagram;
    }

    public void switchToTabNextTab() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public SaveYourCredentialsPage saveYourCredentialsPage() {
        if (saveYourCredentialsPage == null) {
            saveYourCredentialsPage = new SaveYourCredentialsPage(this);
        }
        return saveYourCredentialsPage;
    }

    public UrchinAccountLinkedInPage urchinAccountLinkedInPage() {
        if (urchinAccountLinkedInPage == null) {
            urchinAccountLinkedInPage = new UrchinAccountLinkedInPage(this);
        }
        return urchinAccountLinkedInPage;
    }

    public UrchinSystemsJobsPage urchinSystemsJobsPage() {
        if (urchinSystemsJobsPage == null) {
            urchinSystemsJobsPage = new UrchinSystemsJobsPage(this);
        }
        return urchinSystemsJobsPage;
    }

    public JoinLinkedIn joinLinkedIn() {
        if (joinLinkedIn == null) {
            joinLinkedIn = new JoinLinkedIn(this);
        }
        return joinLinkedIn;
    }

    public SignInLinkedIn signInLinkedIn() {
        if (signInLinkedIn == null) {
            signInLinkedIn = new SignInLinkedIn(this);
        }
        return signInLinkedIn;
    }

    public short getDefaultTimeout() {
        return defaultTimeout;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, defaultTimeout);
        }
        return wait;
    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.getDriver();
        }
        return driver;
    }


}
