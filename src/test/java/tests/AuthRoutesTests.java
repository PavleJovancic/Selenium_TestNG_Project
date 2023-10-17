package tests;

import helpers.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToHomeUrlIfNotAuthenticated(){

        navigateToUrl(baseUrl + "/home");

        wait
                .withMessage("If not logged in page should redirect to login page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToProfileUrlIfNotAuthenticated(){

        navigateToUrl(baseUrl + "/profile");

        wait
                .withMessage("If not logged in page should redirect to login page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToAdminCitiesUrlIfNotAuthenticated(){

        navigateToUrl(baseUrl + "/admin/cities");

        wait
                .withMessage("If not logged in page should redirect to login page")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }
}
