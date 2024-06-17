package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BillPayApiTest {

    String accountId;

    @Test
    @Parameters({"username", "password"})

    public void billPay(String username, String pass) {
        accountId = AccountPageTests.accountId;
        System.out.println("Initial accountId: " + accountId);
        RestAssured.baseURI = "http://localhost:8081/parabank";

        String payload = "{\n" +
                "  \"address\": {\n" +
                "    \"street\": \"etert\",\n" +
                "    \"city\": \"tert\",\n" +
                "    \"state\": \"tertr\",\n" +
                "    \"zipCode\": \"456646\"\n" +
                "  },\n" +
                "  \"name\": \"Testname\",\n" +
                "  \"phoneNumber\": \"65456546\",\n" +
                "  \"accountNumber\": \"66\"\n" +
                "}";

        System.out.println("Payload: " + payload);
        System.out.println("Full URL: " + RestAssured.baseURI + "/services_proxy/bank/billpay?accountId=" + accountId + "&amount=5");

        Response response = given()
                .auth().preemptive().basic(username, pass)
                .contentType("application/json")
                .queryParam("accountId", accountId)
                .queryParam("amount", "5")
                .body(payload)

                .when()
                .post("/services_proxy/bank/billpay")

                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

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
