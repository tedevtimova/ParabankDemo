package Tests;

import Helpers.BaseClass;
import Pages.BillPayApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPayApiTest extends BaseClass {

    String accountId;

    @Test

    public void billPay() {
        accountId = AccountPageTests.accountId;
        System.out.println("Initial accountId: " + accountId);
        RestAssured.baseURI = "http://localhost:8081/parabank";

        Response response = new BillPayApi().executeBillPay(testParameters.username, testParameters.password, accountId);

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
