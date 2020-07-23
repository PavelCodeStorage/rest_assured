package com.project;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.util.Random;

@SuppressWarnings("ALL")
public class ApiVerification {

private String responseBody;

     @Given("^User sent request with ([^\"]*) method and ([^\"]*)file$")
     public void UserPerformGetOperation(String str1,String str2) throws IOException {

         String jsonBody = new ReadJson().generateStringFromResource("/Users/paveldovgan/Desktop/ApiTests/src/test/resources/body.json");
         RequestSpecification httpRequest = RestAssured.given();

         Response response =  httpRequest.baseUri("https://api.todoist.com/rest/v1/tasks")
         .header("Content-Type","application/json")
         .header("X-Request-Id", new Random().nextInt(10000))
         .header("Authorization","Bearer bd61ffff0f5da1cc4be629aa75c8a8dd61e21ac0")
         .body(jsonBody)
         .when()
         .post();
         ResponseBody body = response.getBody();
         responseBody= body.asString();
        }

    @Given("^User once again sent request with ([^\"]*) method and ([^\"]*)file$")
    public void UserPerformGetOperation2(String str1,String str2) throws IOException {

        String jsonBody = new ReadJson().generateStringFromResource("/Users/paveldovgan/Desktop/ApiTests/src/test/resources/body.json");
        RequestSpecification httpRequest = RestAssured.given();

        Response response =  httpRequest.baseUri("https://api.todoist.com/rest/v1/tasks")
                .header("Content-Type","application/json")
                // .header("X-Request-Id", new Random().nextInt(10000))
                .header("X-Request-Id", 1)

                .header("Authorization","Bearer bd61ffff0f5da1cc4be629aa75c8a8dd61e21ac0")
                .body(jsonBody)
                .when()
                .post();
        ResponseBody body = response.getBody();
        responseBody= body.asString();
    }

@Then("^Response is appeared with projectId ([^\"]*)$")
public void UserPerformGetOperation2(String projectId) {
    Assert.assertTrue(responseBody.contains(projectId));
}

@Then("^Response error ([^\"]*) is appeared$")
public void UserPerformGetOperation3(String responce) {
    Assert.assertTrue(responseBody.contains(responce));
}

@Then("^Response is not null$")
public void UserPerformGetOperation4() {
    Assert.assertNotNull(responseBody);
}
}

