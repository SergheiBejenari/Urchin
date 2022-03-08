package urchin.tests;

import org.testng.annotations.AfterSuite;
import urchin.POM.Application;

public abstract class BaseTest {

    private final Application app = new Application();

//    @BeforeSuite
    public void getHomePage() {
        app.homePage().open();
    }

//    @AfterSuite
    public void quitDriver() {
        app.quitDriver();
    }

}
