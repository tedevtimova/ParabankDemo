package Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseClass {

    public TestParameters testParameters;
    public static WebDriver driver;

    @BeforeClass

    public void setUp() throws IOException {
        testParameters = TestParameters.loadFromFile("C:\\Users\\TeodoraEvtimova\\Desktop\\parameters.json");
    }


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

