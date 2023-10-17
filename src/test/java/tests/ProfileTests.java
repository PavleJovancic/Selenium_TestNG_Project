package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

    @BeforeMethod
    public void visitProfilePage() {
        String email = "jonhdoe@mail.com";
        String password = "12345";

        navPage.clickLangButton();
        navPage.clickENButton();

        navPage.clickLoginButton();
        loginPage.login(email, password);

        navPage.clickMyProfileLink();
        wait
                .withMessage("Page should redirect to my profile page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/profile"));

    }




}
