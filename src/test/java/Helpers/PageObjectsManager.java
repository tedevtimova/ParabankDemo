package Helpers;

import Pages.AccountPage;
import Pages.LoginPage;
import Pages.RegistrationPage;

public class PageObjectsManager {

    private static RegistrationPage registrationPage;
    private static LoginPage loginPage;
    private static AccountPage accountPage;


    public static AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage(BrowserFactory.getDriver());
        }
        return accountPage;
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(BrowserFactory.getDriver());
        }
        return loginPage;
    }

    public static RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage(BrowserFactory.getDriver());
        }
        return registrationPage;
    }
}
