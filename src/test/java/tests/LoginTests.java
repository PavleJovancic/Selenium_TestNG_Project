package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @BeforeMethod
    public void visitLoginPage(){
        navPage.clickLangButton();
        navPage.clickESButton();
        navPage.clickLoginButton();
        wait
                .withMessage("Login button should redirect to login page")
                .until(ExpectedConditions.urlToBe(baseUrl + "login"));
    }


}
