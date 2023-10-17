package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyEditProfile(){
        String name = "John Doe";
        String phone = "+12347755633";
        String city = "Prague";
        String country = "Czech Republic";
        String twitter = "https://twitter.com/profile/johndoe123";
        String github = "https://github.com/johndoe";

        profilePage.clearAndSendKeysToNameInputField(name);
        profilePage.clearAndSendKeysToPhoneInputField(phone);
        profilePage.clearAndSendKeysToCityInputField(city);
        profilePage.clearAndSendKeysToCountryInputField(country);
        profilePage.clearAndSendKeysToTwitterInputField(twitter);
        profilePage.clearAndSendKeysToGitHubInputField(github);

        wait
                .withMessage("Profile saved successfully dialog is present")
                .until(ExpectedConditions.visibilityOf(profilePage.getProfileSavedSuccessfullyDialog()));
        profilePage.clickProfileSavedSuccessfullyDialogButton();

        Assert.assertEquals(profilePage.getNameInputFieldText(), name,
                "Name should be changed");
        Assert.assertEquals(profilePage.getPhoneInputFieldText(), phone,
                "Phone should be changed");
        Assert.assertEquals(profilePage.getCityInputFieldText(), city,
                "City should be changed");
        Assert.assertEquals(profilePage.getCountryInputFieldText(), country,
                "Country should be changed");
        Assert.assertEquals(profilePage.getTwitterInputFieldText(), twitter,
                "Tshould be changed");
        Assert.assertEquals(profilePage.getGitHubInputFieldText(), github,
                "should be changed");

    }






}
