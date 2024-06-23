package Tests;

import Pages.BillPayPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BillPayApiTest extends BillPayPage {

    String accountId;

    @Test
    @Parameters({"username", "password"})

    public void billPay(String username, String password) {
        accountId = AccountPageTests.accountId;
        System.out.println("Initial accountId: " + accountId);

        // The constructor of BillPayBase is called here
        Response response = executeBillPay(username, password, accountId);

        String payeeName = response.path("payeeName");
        int amount = response.path("amount");
        int accountIdAfterResponse = response.path("accountId");

        System.out.println("Extracted accountId: " + accountIdAfterResponse);
        System.out.println("Initial accountId: " + accountId);

        Assert.assertEquals(String.valueOf(accountIdAfterResponse), accountId, "The accountId in the response does not match the one used in the query parameter");
        Assert.assertEquals(payeeName, "Testname", "The payeeName in the response does not match the expected value");
        Assert.assertEquals(amount, 5, "The amount in the response does not match the expected value");
    }
}
