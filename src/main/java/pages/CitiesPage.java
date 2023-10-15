package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }
    public void clickNewItemButton(){
        getNewItemButton().click();
    }
    public WebElement getNewItemNameInputField(){
        return driver.findElement(By.id("name"));
    }
    public String getNewItemNameInputFieldType(){
        return getNewItemNameInputField().getAttribute("type");
    }
    public WebElement getNewItemDialogCancelButton(){
        return driver.findElement(By.className("btnCancel"));
    }
    public void clickNewItemDialogCancelButton(){
        getNewItemDialogCancelButton().click();
    }
    public WebElement getEditButton(){
        return driver.findElement(By.id("edit"));
    }
    public void clickEditButton(){
        getEditButton().click();
    }
    public void clickCitiesTableRowEditButton(int rowNumber){
         driver.findElement(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ")")).click();
    }
    public WebElement getEditItemNameInputField(){
        return driver.findElement(By.id("name"));
    }
    public String getEditItemNameInputFieldType(){
        return getEditItemNameInputField().getAttribute("type");
    }
    public WebElement getEditItemDialogCancelButton(){
        return driver.findElement(By.className("btnCancel"));
    }
    public void clickEditItemDialogCancelButton(){
        getEditItemDialogCancelButton().click();
    }

    public WebElement getSearchInputField(){
        return driver.findElement(By.id("search"));
    }

}
