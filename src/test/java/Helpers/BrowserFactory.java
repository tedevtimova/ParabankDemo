package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver CreateDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("mozilla")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name");
        }
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = CreateDriver("mozilla");
        }
        return driver;
    }

    public static void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
