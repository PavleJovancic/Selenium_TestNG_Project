package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
    public WebElement getNewItemDialog(){
        return driver.findElement(By.className("dlgNewEditItem"));
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
    public void clearAndSendKeysToNewItemNameInput(String city){
        getNewItemNameInputField().clear();
        getNewItemNameInputField().sendKeys(city);
    }
    public WebElement getNewItemDialogSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }

    public void clickNewItemDialogSaveButton(){
        getNewItemDialogSaveButton().click();
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
    public void clearAndSendKeysToEditItemNameInputField(String city){
        getEditItemNameInputField().click();
        getEditItemNameInputField().sendKeys(Keys.CONTROL, "a");
        getEditItemNameInputField().sendKeys(Keys.BACK_SPACE);
        getEditItemNameInputField().sendKeys(city);
    }
    public WebElement getEditItemDialogSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }

    public void clickEditItemDialogSaveButton(){
        getEditItemDialogSaveButton().click();
    }
    public WebElement getSavedSuccessfullyDialog(){
        return driver.findElement(By.xpath("//*[contains(text(), ' Saved successfully ')]"));
    }

    public WebElement getSearchInputField(){
        return driver.findElement(By.id("search"));
    }
    public void clearAndSendKeysToSearchInputField(String search){
        getSearchInputField().clear();
        getSearchInputField().sendKeys(search);
    }
    public WebElement getCitiesTableRow(){
        return driver.findElement(By.cssSelector("tbody > tr"));
    }
    public By getCitiesTableRows() {
        return By.cssSelector("tbody > tr");
    }

}
