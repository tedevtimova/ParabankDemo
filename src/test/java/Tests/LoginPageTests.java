package Tests;

import Helpers.PageObjectsManager;
import Helpers.TestNgHooks;
import Pages.AccountPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestNgHooks {

    LoginPage loginPage;
    AccountPage accountPage;

    @Test

    public void testSuccessfulLogin() {
        loginPage = PageObjectsManager.getLoginPage();
        accountPage = PageObjectsManager.getAccountPage();
        loginPage.fillInCredentials("tedevtimova112", "123456");
        loginPage.clickLogIn();
        Assert.assertEquals(accountPage.logOutLinkIsDisplayed(), true, "logout link is not displayed");
    }
}
