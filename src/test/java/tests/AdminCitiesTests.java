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

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyCreateNewCity(){
        String city = "New Asia";

        citiesPage.clickNewItemButton();
        wait
                .withMessage("New item dialog should be present")
                .until(ExpectedConditions.visibilityOf(citiesPage.getNewItemDialog()));

        citiesPage.clearAndSendKeysToNewItemNameInput(city);

        wait
                .withMessage("Save button should be enabled after text is entered")
                .until(ExpectedConditions.elementToBeClickable(citiesPage.getNewItemDialogSaveButton()));

        citiesPage.clickNewItemDialogSaveButton();
        wait
                .withMessage("Saved successfully dialog is present")
                .until(ExpectedConditions.visibilityOf(citiesPage.getSavedSuccessfullyDialog()));
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void verifyEditCity(){
        String city = "New Asia";
        String cityEdited = "New Asia Edited";

        citiesPage.clearAndSendKeysToSearchInputField(city);

        ;
        wait
                .withMessage("Search result should have only one result")
                .until(ExpectedConditions.numberOfElementsToBe(citiesPage.getCitiesTableRows(), 1));

        citiesPage.clickEditButton();

        citiesPage.clearAndSendKeysToEditItemNameInputField(cityEdited);
        wait
                .withMessage("Save button should be enabled after text is entered")
                .until(ExpectedConditions.elementToBeClickable(citiesPage.getEditItemDialogSaveButton()));

        citiesPage.clickEditItemDialogSaveButton();

        wait
                .withMessage("Saved successfully dialog should be present")
                .until(ExpectedConditions.visibilityOf(citiesPage.getSavedSuccessfullyDialog()));
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifySearchCity(){
        String city = "New Asia";

        citiesPage.clearAndSendKeysToSearchInputField(city);

        wait
                .withMessage("Search result should have only one result")
                .until(ExpectedConditions.numberOfElementsToBe(citiesPage.getCitiesTableRows(), 1));
        Assert.assertEquals(citiesPage.getCitiesTableNameCellText(), city,
                "Searched city name should be the same as name in a cell");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void verifyDeleteCity(){
        String city = "New Asia Edited";

        citiesPage.clearAndSendKeysToSearchInputField(city);

        wait
                .withMessage("Search result should have only one result")
                .until(ExpectedConditions.numberOfElementsToBe(citiesPage.getCitiesTableRows(), 1));
        Assert.assertEquals(citiesPage.getCitiesTableNameCellText(), city,
                "Searched city name should be the same as name in a cell");

        citiesPage.clickCitiesTableDeleteButton();

        wait
                .withMessage("Delete warning dialog should be present")
                .until(ExpectedConditions.visibilityOf(citiesPage.getDeleteWarningDialog()));

        citiesPage.clickDeleteWarningDialogDeleteButton();
        wait
                .withMessage("Deleted successfully dialog should be present")
                .until(ExpectedConditions.visibilityOf(citiesPage.getDeletedSuccessfullyDialog()));
    }
}
