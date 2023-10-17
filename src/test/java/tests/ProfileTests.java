package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

    @BeforeMethod
    public void visitProfilePage() {
        String email = "admin@admin.com";
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
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes() {
        Assert.assertEquals(profilePage.getNameInputFieldType(), "text",
                "Name input type should be text");
        Assert.assertEquals(profilePage.getPhoneInputFieldType(), "tel",
                "Phone input type should be tel");
        Assert.assertEquals(profilePage.getCityInputFieldType(), "text",
                "City input type should be text");
        Assert.assertEquals(profilePage.getCountryInputFieldType(), "text",
                "Country input type should be text");
        Assert.assertEquals(profilePage.getTwitterInputFieldType(), "url",
                "Twitter input type should be url");
        Assert.assertEquals(profilePage.getGitHubInputFieldType(), "url",
                "GitHub input type should be url");

    }




}
