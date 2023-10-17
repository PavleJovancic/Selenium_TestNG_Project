package pages;

import org.openqa.selenium.By;
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

    public WebElement getPhoneInputField(){
        return driver.findElement(By.id("phone"));
    }
    public String getPhoneInputFieldType(){
        return getPhoneInputField().getAttribute("type");
    }

    public WebElement getCityInputField(){
        return driver.findElement(By.id("city"));
    }
    public String getCityInputFieldType(){
        return getCityInputField().getAttribute("type");
    }

    public WebElement getCountryInputField(){
        return driver.findElement(By.id("country"));
    }
    public String getCountryInputFieldType(){
        return getCountryInputField().getAttribute("type");
    }

    public WebElement getTwitterInputField(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getTwitterInputFieldType(){
        return getTwitterInputField().getAttribute("type");
    }

    public WebElement getGitHubInputField(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getGitHubInputFieldType(){
        return getGitHubInputField().getAttribute("type");
    }

    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getChangeMyPasswordButton(){
        return driver.findElement(By.className("btnChangePassword"));
    }


}
