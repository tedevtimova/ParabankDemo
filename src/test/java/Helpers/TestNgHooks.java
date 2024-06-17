package Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNgHooks {

    public static WebDriver driver;

    @BeforeSuite

    public void openBrowser() {
        driver = BrowserFactory.getDriver();
        driver.get("http://localhost:8081/parabank/index.htm");
    }

    @AfterSuite

    public void closeBrowser() {
        BrowserFactory.tearDownBrowser();
    }
}
