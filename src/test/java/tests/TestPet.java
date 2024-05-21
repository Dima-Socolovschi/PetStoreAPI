package tests;

import classes.Category;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import static io.restassured.RestAssured.baseURI;
import static utils.Steps.*;

public class TestPet {

    @BeforeSuite
    public void setUp() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(description = "Get a valid pet.", priority = 1)
    public void getPetPositive(){
        String url = "/pet/";
        int id = 7;

        Response response = getPetById(url, id);

        isStatusCodeValid(response, 200);
        isTheFieldValueCorrect(response, "id", "7");
        isTheFieldValueCorrect(response, "name", "doggie");
    }

    @Test(description = "Get a 404 error for invalid pet id.", priority = 2)
    public void getPetNotFound(){
        String url = "/pet/";
        int id = 200;

        Response response = getPetById(url, id);

        isStatusCodeValid(response, 404);
        isTheFieldValueCorrect(response, "code", "1");
        isTheFieldValueCorrect(response, "message", "Pet not found");
    }
}
