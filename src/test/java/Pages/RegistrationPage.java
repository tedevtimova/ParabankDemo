package Pages;

import Helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeField;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneField;

    @FindBy(id = "customer.ssn")
    private WebElement snnField;

    @FindBy(id = "customer.username")
    private WebElement userNameField;

    @FindBy(id = "customer.password")
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassField;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    @FindBy(id = "repeatedPassword.errors")
    private WebElement passErrorMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void fillFirstName(String fName) {
        Waits.getExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameField.sendKeys(fName);
        Assert.assertTrue(firstNameField.getAttribute("value").contains(fName), "Entered First Name and displayed text do not match");
    }

    public void fillLastName(String lName) {
        lastNameField.sendKeys(lName);
        Assert.assertTrue(lastNameField.getAttribute("value").contains(lName), "Entered Last Name and displayed text do not match");
    }

    public void fillAddress(String address) {
        addressField.sendKeys(address);
        Assert.assertTrue(addressField.getAttribute("value").contains(address), "Entered address and displayed text do not match");
    }

    public void fillCity(String city) {
        cityField.sendKeys(city);
        Assert.assertTrue(cityField.getAttribute("value").contains(city), "Entered city and displayed text do not match");
    }

    public void fillState(String state) {
        stateField.sendKeys(state);
        Assert.assertTrue(stateField.getAttribute("value").contains(state), "Entered State and displayed text do not match");
    }

    public void fillzipCode(String zCode) {
        zipCodeField.sendKeys(zCode);
        Assert.assertTrue(zipCodeField.getAttribute("value").contains(zCode), "Entered Zip code and displayed text do not match");
    }

    public void fillPhone(int phone) {
        phoneField.sendKeys(String.valueOf(phone));
        Assert.assertTrue(phoneField.getAttribute("value").contains(String.valueOf(phone)), "Entered Phone and displayed text do not match");
    }

    public void fillSsn(String snn) {
        snnField.sendKeys(snn);
        Assert.assertTrue(snnField.getAttribute("value").contains(snn), "Entered Snn and displayed text do not match");
    }

    public void fillUsername(String username) {
        userNameField.sendKeys(username);
        Assert.assertTrue(userNameField.getAttribute("value").contains(username), "Entered Username and displayed text do not match");
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
        Assert.assertTrue(passwordField.getAttribute("value").contains(password), "Entered Password and displayed text do not match");
    }

    public void fillConfirm(String confirm) {
        confirmPassField.sendKeys(confirm);
        Assert.assertTrue(confirmPassField.getAttribute("value").contains(confirm), "Entered Confirm password and displayed text do not match");
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean verifyErrorPassMessage() {
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(passErrorMessage));
        boolean passwordConfirmError = passErrorMessage.isDisplayed();
        return passwordConfirmError;
    }
}




