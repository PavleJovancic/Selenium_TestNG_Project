package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInputField(){
        return driver.findElement(By.id("name"));
    }
    public String getNameInputFieldType(){
        return getNameInputField().getAttribute("type");
    }
    public String getNameInputFieldText(){
        return getNameInputField().getText();
    }
    public void clearAndSendKeysToNameInputField(String name){
        getNameInputField().click();
        getNameInputField().sendKeys(Keys.CONTROL, "a");
        getNameInputField().sendKeys(Keys.BACK_SPACE);
        getNameInputField().sendKeys(name);
    }

    public WebElement getPhoneInputField(){
        return driver.findElement(By.id("phone"));
    }
    public String getPhoneInputFieldType(){
        return getPhoneInputField().getAttribute("type");
    }
    public String getPhoneInputFieldText(){
        return getPhoneInputField().getText();
    }
    public void clearAndSendKeysToPhoneInputField(String number){
        getPhoneInputField().click();
        getPhoneInputField().sendKeys(Keys.CONTROL, "a");
        getPhoneInputField().sendKeys(Keys.BACK_SPACE);
        getPhoneInputField().sendKeys(number);
    }

    public WebElement getCityInputField(){
        return driver.findElement(By.id("city"));
    }
    public String getCityInputFieldType(){
        return getCityInputField().getAttribute("type");
    }
    public String getCityInputFieldText(){
        return getCityInputField().getText();
    }
    public void clearAndSendKeysToCityInputField(String city){
        getCityInputField().click();
        getCityInputField().sendKeys(Keys.CONTROL, "a");
        getCityInputField().sendKeys(Keys.BACK_SPACE);
        getCityInputField().sendKeys(city);
    }

    public WebElement getCountryInputField(){
        return driver.findElement(By.id("country"));
    }
    public String getCountryInputFieldType(){
        return getCountryInputField().getAttribute("type");
    }
    public String getCountryInputFieldText(){
        return getCountryInputField().getText();
    }
    public void clearAndSendKeysToCountryInputField(String country){
        getCountryInputField().click();
        getCountryInputField().sendKeys(Keys.CONTROL, "a");
        getCountryInputField().sendKeys(Keys.BACK_SPACE);
        getCountryInputField().sendKeys(country);
    }

    public WebElement getTwitterInputField(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getTwitterInputFieldType(){
        return getTwitterInputField().getAttribute("type");
    }
    public String getTwitterInputFieldText(){
        return getTwitterInputField().getText();
    }
    public void clearAndSendKeysToTwitterInputField(String url){
        getTwitterInputField().click();
        getTwitterInputField().sendKeys(Keys.CONTROL, "a");
        getTwitterInputField().sendKeys(Keys.BACK_SPACE);
        getTwitterInputField().sendKeys(url);
    }

    public WebElement getGitHubInputField(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getGitHubInputFieldType(){
        return getGitHubInputField().getAttribute("type");
    }
    public String getGitHubInputFieldText(){
        return getGitHubInputField().getText();
    }
    public void clearAndSendKeysToGitHubInputField(String url){
        getGitHubInputField().click();
        getGitHubInputField().sendKeys(Keys.CONTROL, "a");
        getGitHubInputField().sendKeys(Keys.BACK_SPACE);
        getGitHubInputField().sendKeys(url);
    }

    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public void clickSaveButton(){
        getSaveButton().click();
    }
    public WebElement getChangeMyPasswordButton(){
        return driver.findElement(By.className("btnChangePassword"));
    }
    public void clickChangeMyPasswordButton(){
        getChangeMyPasswordButton().click();
    }
    public WebElement getChangeMyPasswordDialog(){
        return driver.findElement(By.className("v-card__title"));
    }
    public WebElement getCurrentPasswordInputField(){
        return driver.findElement(By.id("oldPassword"));
    }
    public String getCurrentPasswordInputFieldType(){
        return getCurrentPasswordInputField().getAttribute("type");
    }
    public void clearAndSendKeysToCurrentPasswordInputField(String password){
        getCurrentPasswordInputField().clear();
        getCurrentPasswordInputField().sendKeys(password);
    }

    public WebElement getNewPasswordInputField(){
        return driver.findElement(By.id("newPassword"));
    }
    public String getNewPasswordInputFieldType(){
        return getNewPasswordInputField().getAttribute("type");
    }
    public void clearAndSendKeysToNewPasswordInputField(String password){
        getNewPasswordInputField().clear();
        getNewPasswordInputField().sendKeys(password);
    }
    public WebElement getConfirmPasswordInputField(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public String getConfirmPasswordInputFieldType(){
        return getConfirmPasswordInputField().getAttribute("type");
    }
    public void clearAndSendKeysToConfirmPasswordInputField(String password){
        getConfirmPasswordInputField().clear();
        getConfirmPasswordInputField().sendKeys(password);
    }
    public WebElement getChangeMyPasswordDialogSaveButton(){
        return driver.findElement(By.id("updatePassword"));
    }
    public void clickChangeMyPasswordDialogSaveButton(){
        getChangeMyPasswordButton().click();
    }
    public WebElement getPasswordChangedSuccessfullyDialog(){
        return driver.findElement(By.xpath("//*[contains(text(),'Password changed successfully')]"));
    }

    public WebElement getProfileSavedSuccessfullyDialog(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Profile saved successfuly')]"));
    }
    public WebElement getProfileSavedSuccessfullyDialogButton(){
        return driver.findElement(By.xpath("//*[contains(text(),'Profile saved successfuly')]/button"));
    }
    public void clickProfileSavedSuccessfullyDialogButton(){
        getProfileSavedSuccessfullyDialogButton().click();
    }

}
