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


}
