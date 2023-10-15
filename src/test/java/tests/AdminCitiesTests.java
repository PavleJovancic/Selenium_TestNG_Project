package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{

    @BeforeMethod
    public void visitCitiesPage() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.clickLangButton();
        navPage.clickENButton();
        navPage.clickLoginButton();
        loginPage.login(email, password);

        navPage.clickAdminButton();
        navPage.clickCitiesLink();
        wait
                .withMessage("Page should redirect to cities page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
    }

}
