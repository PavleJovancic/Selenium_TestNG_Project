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
    public WebElement getPasswordInputField(){
        return driver.findElement(By.id("password"));
    }
    public String getPasswordInputFieldType(){
        return getPasswordInputField().getAttribute("type");
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("button[type=submit]"));
    }
}
