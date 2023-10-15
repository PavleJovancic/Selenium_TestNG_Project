package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void checkCreateEditNameInputTypes(){
        int rowNumber = 1;
        citiesPage.clickNewItemButton();
        Assert.assertEquals(citiesPage.getNewItemNameInputFieldType(), "text",
                "Name input field type for new item should be 'text'");
        citiesPage.clickNewItemDialogCancelButton();

        citiesPage.clickCitiesTableRowEditButton(rowNumber);
        Assert.assertEquals(citiesPage.getEditItemNameInputFieldType(), "text",
                "Edit input field type for item should be 'text'");
        citiesPage.clickEditItemDialogCancelButton();
    }
}
