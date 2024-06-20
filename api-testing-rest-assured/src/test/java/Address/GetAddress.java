package Address;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import models.Address;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetAddress {

    /**
     * This test show how you would make assert using object mapper for nested objects.
     * Also it show how to use Response interface to create a test.
     */
    @Test
    public void getAddress() throws JsonProcessingException {
        String endpoint = "https://25536437-5c33-435a-a284-efd3f231bc7d.mock.pstmn.io/getAddress/1";

        Response response = given().when().get(endpoint);

        response.then().
                assertThat().log().all().
                header("Content-Type", "text/html; charset=utf-8").
                statusCode(200).
                body(is(notNullValue()));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Address responseBodyObject = mapper.readValue(responseBody, Address.class);
        System.out.println("Response Body Object: " + responseBodyObject.getAddress().getPostalCode());

        assertEquals("Amalgamated Steel", responseBodyObject.getName());
        assertEquals("01734", responseBodyObject.getAddress().getPostalCode());
        assertEquals("123 Main St.", responseBodyObject.getAddress().getStreet());
        assertEquals("Belmont", responseBodyObject.getAddress().getCity());
        assertEquals("MA", responseBodyObject.getAddress().getState());
    }
}
