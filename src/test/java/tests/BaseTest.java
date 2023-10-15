package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CitiesPage;
import pages.LoginPage;
import pages.NavPage;
import pages.SignupPage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        navPage = new NavPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);

    }

    @BeforeMethod
    public void navigateToBaseURL() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void deleteWebStorageData(){
        WebStorage webStorage = (WebStorage) driver;
        webStorage.getSessionStorage().clear();
        webStorage.getLocalStorage().clear();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
