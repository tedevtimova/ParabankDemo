package Pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BillPayPage {

    protected String accountId;
    protected String payload;

    public BillPayPage() {

        RestAssured.baseURI = "http://localhost:8081/parabank";
        payload = "{\n" +
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
    }

    protected Response executeBillPay(String username, String password, String accountId) {
        return given()
                .auth().preemptive().basic(username, password)
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
    }
}


