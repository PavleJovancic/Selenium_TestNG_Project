package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest{

    @BeforeMethod
    public void visitSignupPage() {
        navPage.clickLangButton();
        navPage.clickENButton();
        navPage.clickSignupButton();
        wait
                .withMessage("Signup button should redirect to signup page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/signup"));
    }
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes() {
        Assert.assertEquals(signupPage.getNameInputFieldType(), "text",
                "Name input type should be text");
        Assert.assertEquals(signupPage.getEmailInputFieldType(), "email",
                "Email input type should be email");
        Assert.assertEquals(signupPage.getPasswordInputFieldType(), "password",
                "Password input type should be password");
        Assert.assertEquals(signupPage.getConfirmPasswordInputFieldType(), "password",
                "Confirm password input type should be password");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyDisplayErrorMessageWhenUserAlreadyExists(){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";

        signupPage.signup(name, email, password);

        wait
                .withMessage("Error message should appear when user already exist")
                .until(ExpectedConditions.visibilityOf(signupPage.getErrorMessage()));
        Assert.assertEquals(signupPage.getErrorMessageText(), "E-mail already exists",
                "Error message should be 'E-mail already exists'");
        Assert.assertEquals(signupPage.getCurrentPageURL(), baseUrl + "/signup",
                "Page does not redirect when user already exist");
    }

    @Test(priority = 3)
    public void verifySuccesfullSignup() {
        String name = "John Doe";
        String email = "johndoe@mail.com";
        String password = "12345";

        signupPage.signup(name, email, password);

        wait
                .withMessage("After successful signup dialog should appear with text 'IMPORTANT: Verify your account'")
                .until(ExpectedConditions.visibilityOf(signupPage.getVerifyYourAccountDialog()));
        Assert.assertEquals(signupPage.getVerifyYourAccountDialogText(), "IMPORTANT: Verify your account",
                "Successful dialog text should be 'IMPORTANT: Verify your account'");

        signupPage.clickVerifyYourAccountDialogCloseButton();

        wait
                .withMessage("After sign page should be redirected to home page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));
    }
}
