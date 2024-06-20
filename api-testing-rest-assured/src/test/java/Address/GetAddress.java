package Address;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetAddress {


    @Test
    public void getAddress() {
        String endpoint = "https://25536437-5c33-435a-a284-efd3f231bc7d.mock.pstmn.io/getAddress/1";

        Response response = given().when().get(endpoint);

        response.then().
                assertThat().log().all().
                header("Content-Type", "text/html; charset=utf-8").
                statusCode(200).
                body(is(notNullValue()));

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Parse the HTML response with jsoup
        Document doc = Jsoup.parse(responseBody);
        System.out.println("Parsed HTML: " + doc);


    }
}
