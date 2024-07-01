package Tests;

import Helpers.BaseClass;
import Helpers.TestParameters;
import Pages.AccountPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageTests extends BaseClass {

    RegistrationPage registrationPage;
    AccountPage accountPage;
    TestParameters testParameters;

    @Test

    public void clickRegistrationLink() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegister();
    }

    @Test

    public void testFillInForm() {

        testParameters = getTestParameters();
        registrationPage.fillFirstName(testParameters.firstName);
        registrationPage.fillLastName(testParameters.lastName);
        registrationPage.fillAddress(testParameters.address);
        registrationPage.fillCity(testParameters.city);
        registrationPage.fillState(testParameters.state);
        registrationPage.fillzipCode(testParameters.zipCode);
        registrationPage.fillPhone(Integer.parseInt(testParameters.phone));
        registrationPage.fillSsn(testParameters.ssn);
    }

    @Test
    public void fillNotMatchingPasswordsAndRegister() {

        registrationPage.fillUsername(testParameters.username);
        registrationPage.fillPassword(testParameters.password);
        registrationPage.fillConfirm(testParameters.confirmPasswordOne);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.verifyErrorPassMessage(), true, "Error message is not displayed");
    }

    @Test

    public void fillMatchingPasswordsAndRegister() {

        accountPage = new AccountPage(driver);
        registrationPage.fillPassword(testParameters.password);
        registrationPage.fillConfirm(testParameters.confirmPasswordTwo);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(accountPage.logOutLinkIsDisplayed(), true, "logout link is not displayed");
        Assert.assertEquals(accountPage.successRegMessage(), true, "Success registration message is not displayed");
    }
}
