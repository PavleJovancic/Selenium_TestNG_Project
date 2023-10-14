package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @BeforeMethod
    public void visitLoginPage(){
        navPage.clickLangButton();
        navPage.clickENButton();
        navPage.clickLoginButton();
        wait
                .withMessage("Login button should redirect to login page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes(){
        Assert.assertEquals(loginPage.getEmailInputFieldType(), "email",
                "Email input type should be email");
        Assert.assertEquals(loginPage.getPasswordInputFieldType(), "password",
                "Password input type should be password");
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyDisplayErrorMessageWhenUserDoesNotExists(){
            String email = "userdoesnotexist@gmail.com";
            String password = "incorrectpassword";

            loginPage.clearAndSendKeysToEmailInputField(email);
            loginPage.clearAndSendKeysToPasswordInputField(password);
            loginPage.clickLoginButton();

            wait
                    .withMessage("Error message should appear when user does not exist")
                    .until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage()));
            Assert.assertEquals(loginPage.getErrorMessageText(), "User does not exists",
                    "Error message should be 'User does not exists'");
            Assert.assertEquals(loginPage.getCurrentPageURL(), baseUrl + "/login",
                    "Page does not redirect when user does not exist");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyDisplayErrorWhenUsingIncorrectPassword(){
        String email = "admin@admin.com";
        String password = "incorrectpassword";

        loginPage.clearAndSendKeysToEmailInputField(email);
        loginPage.clearAndSendKeysToPasswordInputField(password);
        loginPage.clickLoginButton();

        wait
                .withMessage("Error message should appear when password is incorrect")
                .until(ExpectedConditions.visibilityOf(loginPage.getErrorMessage()));
        Assert.assertEquals(loginPage.getErrorMessageText(), "Wrong password",
                "Error message should be 'Wrong password'");
        Assert.assertEquals(loginPage.getCurrentPageURL(), baseUrl + "/login",
                "Page does not redirect when password is incorrect");
    }



}
