package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @BeforeMethod
    public void visitLoginPage() {
        navPage.clickLangButton();
        navPage.clickENButton();
        navPage.clickLoginButton();
        wait
                .withMessage("Login button should redirect to login page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifySetLocaleToES(){
        navPage.clickLangButton();
        navPage.clickESButton();

        Assert.assertEquals(loginPage.getPageHeadingText(), "Ingresar",
                "Login page heading should change to 'Ingresar'");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifySetLocaleToFR(){
        navPage.clickLangButton();
        navPage.clickFRButton();

        Assert.assertEquals(loginPage.getPageHeadingText(), "Connexion",
                "Login page heading should change to 'Connexion'");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifySetLocaleToCN(){
        navPage.clickLangButton();
        navPage.clickCNButton();

        Assert.assertEquals(loginPage.getPageHeadingText(), "登录",
                "Login page heading should change to '登录'");
    }
}
