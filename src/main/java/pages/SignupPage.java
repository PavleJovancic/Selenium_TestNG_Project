package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInputField(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getEmailInputField(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInputField(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getConfirmPasswordInputField(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement getNSignMeUpButton(){
        return driver.findElement(By.cssSelector("button[type=submit]"));
    }
}
