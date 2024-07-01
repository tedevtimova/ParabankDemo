package Helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class BaseClass {

    private List<TestParameters> testParametersList;

    public static WebDriver driver;
    private TestParameters testParameters;

    @BeforeClass
    @Parameters("dataSet")

    public void setUp(int dataSet) throws IOException {
        String filePath = Paths.get("resources", "parameters.json").toString();
        testParametersList = TestParameters.loadFromFile(filePath);
        if (dataSet < testParametersList.size()) {
            testParameters = testParametersList.get(dataSet);
        } else {
            throw new IndexOutOfBoundsException("Invalid data set index");
        }
    }

    public TestParameters getTestParameters() {
        return testParameters;
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

