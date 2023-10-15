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


}
