package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHomeLink(){
        return driver.findElement(By.className("btnHome"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.className("btnAbout"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.className("btnProfile"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesLink(){
        return driver.findElement(By.className("btnAdminCities"));
    }
    public WebElement getUsersLink(){
        return driver.findElement(By.className("btnAdminUsers"));
    }
    public WebElement getSignUpButton(){
        return driver.findElement(By.cssSelector(".btnLogin:nth-child(4)"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector(".btnLogin:nth-child(3)"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getLangButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getENButton(){
        return driver.findElement(By.className("btnEN"));
    }
    public WebElement getESButton(){
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getFRButton(){
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getCNButton(){
        return driver.findElement(By.className("btnCN"));
    }
    public WebElement getUAButton(){
        return driver.findElement(By.className("btnUA"));
    }

}
