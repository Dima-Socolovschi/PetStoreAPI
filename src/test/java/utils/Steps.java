package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;

public class Steps {

    @Step
    public static Response getPetById(String endpoint, int id){

        Allure.addAttachment("URL", baseURI + endpoint + id);
        Allure.addAttachment("Pet Id", String.valueOf(id));

        Response response = get(endpoint+id);

        Allure.addAttachment("Response Code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Response Body", response.getBody().prettyPrint());

        return response;
    }

    @Step
    public static void isStatusCodeValid(Response response, int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    @Step
    public static void isTheFieldValueCorrect(Response response, String key, String value) {
        response.then().assertThat().body(key, hasToString(value));
    }

}
