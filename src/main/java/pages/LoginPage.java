package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInputField(){
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputFieldType(){
        return getEmailInputField().getAttribute("type");
    }
    public void clearAndSendKeysToEmailInputField(String email){
        getEmailInputField().clear();
        getEmailInputField().sendKeys(email);
    }
    public WebElement getPasswordInputField(){
        return driver.findElement(By.id("password"));
    }
    public String getPasswordInputFieldType(){
        return getPasswordInputField().getAttribute("type");
    }
    public void clearAndSendKeysToPasswordInputField(String password){
        getPasswordInputField().clear();
        getPasswordInputField().sendKeys(password);
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button[type=submit]"));
    }
    public void clickLoginButton(){
        getLoginButton().click();
    }
    public WebElement getErrorMessage(){
        return driver.findElement(By.className("v-snack__wrapper"));
    }
    public String getErrorMessageText(){
        return driver.findElement(By.cssSelector(".v-snack__wrapper li")).getText();
    }
    public void login(String username, String password){
        clearAndSendKeysToEmailInputField(username);
        clearAndSendKeysToPasswordInputField(password);
        clickLoginButton();
    }
}
