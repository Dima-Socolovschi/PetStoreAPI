package tests;

import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.baseURI;

public class TestStore {
    @BeforeSuite
    public void setUp() {
        baseURI = "https://reqres.in/api";
    }
}
