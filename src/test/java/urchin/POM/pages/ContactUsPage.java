package urchin.POM.pages;

import com.oracle.tools.packager.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import urchin.POM.Application;
import urchin.POM.pages.common.BasePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Email Address']")
    private WebElement emailField;

    @FindBy(xpath = "//textarea[@placeholder='Message']")
    private WebElement messageField;

    @FindBy(xpath = "//p[text()='Please, fix the following errors:']")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public ContactUsPage(Application app) {
        super(app);
    }

    public static ArrayList<String> readFromFile() {
        ArrayList<String> list = new ArrayList<>();
        try {
            File myObj = new File("src/test/resources/emailAddresses.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Log.info("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

    @Step("User types credentials into required fields: $name, %email")
    public void typeActionsIntoRequiredFields(String name, String email) {
        actions.click(nameField).build().perform();
        actions.sendKeys(name).build().perform();
        actions.click(emailField).build().perform();
        actions.sendKeys(email).build().perform();
    }

    @Step("User clicks to Submit Button")
    public void clickSubmitButton() {
        click(submitButton);
    }

    @Step("User types credentials into required fields: $name, %email")
    public void typeIntoRequiredFields(String name, String email) {
        nameField.sendKeys("test");
        emailField.sendKeys("Test@test");
    }

    public void waitForDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(nameField));
        wait.until(ExpectedConditions.visibilityOfAllElements(emailField));
        wait.until(ExpectedConditions.visibilityOfAllElements(messageField));
        wait.until(ExpectedConditions.visibilityOfAllElements(submitButton));
    }

    public boolean isDisplayed() {
        return isElementPresent(nameField)
                && isElementPresent(emailField)
                && isElementPresent(messageField)
                && isElementPresent(submitButton);
    }

    @Step("Pay attention to error message displayed")
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfAllElements(errorMessage));
        return errorMessage.getAttribute("innerText");
    }
}
