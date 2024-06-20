
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        ValidatableResponse response = given().when().get(endpoint).then().
                assertThat().
                header("Content-Type", "application/json; charset=UTF-8").
                statusCode(200).
                body("records.size()", greaterThan(0)).
                body("records.id", everyItem(notNullValue())).
                body("records.name", everyItem(notNullValue()));
        response.log().body();
    }

    @Test
    public void getProducts() {
        String endpoint = "http://localhost:8888/api_testing/product/read.php";
        var response = given().queryParam("id", 1).when().get(endpoint).then().assertThat().
                statusCode(200).
                body("name", equalTo("Water Bottle"));
        response.log().body();

    }

    @Test
    public void createProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body = """ 
                {
                "name": "Water Bottle",
                "description": "A bottle to hold water",
                "price": 5.99,
                "category_id": 3
                } 
                """;
        var response  = given().body(body).when().post(endpoint).then().assertThat().
                statusCode(201);
        response.log().body();
    }

    @Test
    public void updateProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        String body = """ 
                {
                "id": 100,
                "name": "Water Bottle",
                "description": "A bottle to hold water",
                "price": 7.00,
                "category_id": 3
                } 
                """;
        var response  = given().body(body).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """ 
                {
                "id": 1000
                } 
                """;
        var response  = given().body(body).when().delete(endpoint).then();
        response.log().body();


    }

    @Test
    public void createSerialiazedProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product("Water Bottle Product", "A bottle to hold water", 8.00, 3);
        System.out.println("Product: " + product);
        var response  = given().body(product).when().post(endpoint).then();
        response.log().body();
    }
}