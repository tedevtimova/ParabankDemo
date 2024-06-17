package Tests;

import Helpers.PageObjectsManager;
import Helpers.TestNgHooks;
import Pages.AccountPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationPageTests extends TestNgHooks {

    RegistrationPage registrationPage;
    AccountPage accountPage;


    @Test

    public void clickRegistrationLink(){
        registrationPage = PageObjectsManager.getRegistrationPage();
        registrationPage.clickRegister();
    }

    @Test
    @Parameters({"firstName","lastName","address","city","state","zipCode","phone","ssn"})

    public void testFillInForm(String fname, String lname,String address,String city,String state,String zipCode,int phone,String ssn) throws InterruptedException {
        registrationPage.fillFirstName(fname);
        registrationPage.fillLastName(lname);
        registrationPage.fillAddress(address);
        registrationPage.fillCity(city);
        registrationPage.fillState(state);
        registrationPage.fillzipCode(zipCode);
        registrationPage.fillPhone(phone);
        registrationPage.fillSsn(ssn);
    }

    @Test
    @Parameters({"username","password","confirmPasswordOne"})

    public void fillNotMatchingPasswordsAndRegister(String username, String pass,String confPass) {
    registrationPage.fillUsername(username);
    registrationPage.fillPassword(pass);
    registrationPage.fillConfirm(confPass);
    registrationPage.clickRegisterButton();
    Assert.assertEquals(registrationPage.verifyErrorPassMessage(),true,"Error message is not displayed");
    }

    @Test
    @Parameters({"password","confirmPasswordTwo"})

    public void fillMatchingPasswordsAndRegister(String pass, String confPass){
        accountPage = PageObjectsManager.getAccountPage();
        registrationPage.fillPassword(pass);
        registrationPage.fillConfirm(confPass);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(accountPage.logOutLinkIsDisplayed(),true,"logout link is not displayed");
        Assert.assertEquals(accountPage.successRegMessage(),true,"Success registration message is not displayed");
    }

}
