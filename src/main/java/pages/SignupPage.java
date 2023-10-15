package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInputField() {
        return driver.findElement(By.id("name"));
    }

    public String getNameInputFieldType() {
        return getNameInputField().getAttribute("type");
    }

    public void clearAndSendKeysToNameInputField(String name) {
        getNameInputField().clear();
        getNameInputField().sendKeys(name);
    }

    public WebElement getEmailInputField() {
        return driver.findElement(By.id("email"));
    }

    public String getEmailInputFieldType() {
        return getEmailInputField().getAttribute("type");
    }

    public void clearAndSendKeysToEmailInputField(String email) {
        getEmailInputField().clear();
        getEmailInputField().sendKeys(email);
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.id("password"));
    }

    public String getPasswordInputFieldType() {
        return getPasswordInputField().getAttribute("type");
    }

    public void clearAndSendKeysToPasswordInputField(String password) {
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(password);
    }

    public WebElement getConfirmPasswordInputField() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public String getConfirmPasswordInputFieldType() {
        return getConfirmPasswordInputField().getAttribute("type");
    }

    public void clearAndSendKeysToConfirmPasswordInputField(String password) {
        getConfirmPasswordInputField().clear();
        getConfirmPasswordInputField().sendKeys(password);
    }

    public WebElement getSignMeUpButton() {
        return driver.findElement(By.cssSelector("button[type=submit]"));
    }

    public void clickSignMeUpButton() {
        getSignMeUpButton().click();
    }

    public WebElement getErrorMessage(){
        return driver.findElement(By.className("v-snack__wrapper"));
    }
    public String getErrorMessageText(){
        return driver.findElement(By.cssSelector(".v-snack__wrapper li")).getText();
    }
}
