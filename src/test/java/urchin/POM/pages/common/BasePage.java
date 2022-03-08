package urchin.POM.pages.common;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import urchin.POM.Application;
import urchin.utils.PropertyReader;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public abstract class BasePage {
    private WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String baseUrl;
    private short defaultTimeout;

    protected BasePage(Application app) {
        this.driver = app.getDriver();
        defaultTimeout = 15;
        this.wait = app.getWait();
        baseUrl = PropertyReader.applicationProperties().getProperty("base.url");
        this.actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Step
    protected boolean isElementPresent(By selector) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(selector);
            driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
            return false;
        }
    }

    @Step
    protected boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath(element.toString()));
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
            return true;
        } catch (NoSuchElementException e) {
            driver.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
            return false;
        }
    }

    @Step
    protected void typeJS(WebElement element, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('aria-invalid',true);", element);
        element.sendKeys(text);
    }

    @Step
    protected void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    @Step
    protected void click(WebElement element) {
        wait.until(elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step
    public void switchToTabNextTab() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    @Step
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    @Step
    public void clickToElement(WebElement element) {
        element.click();
    }
}
