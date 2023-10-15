package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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


}
