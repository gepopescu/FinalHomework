package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class OwnerAdmin {

    private RequestSpecification request;
    private Response response;

    @Given("^I have access to perform GET request with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iHaveAccessToPerformGETRequestWithUsernameAndPassword(String username, String password) throws Throwable {
        request = given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(username,password).
                contentType(ContentType.JSON);
    }
    @When("^I perform GET request to \"([^\"]*)\"$")
    public void iPerformGETRequestTo(String path) throws Throwable {
        response = request.when().get(path);

    }


    @Then("^I will have status code \"([^\"]*)\"$")
    public void iWillHaveStatusCode(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }




    @Given("^I have access to perform POT request with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iHaveAccessToPerformPOTRequestWithUsernameAndPassword(String username, String password) throws Throwable {
        request = given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(username,password).
                contentType(ContentType.JSON);
    }



    @Given("^I have access to perform POST request with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iHaveAccessToPerformPOSTRequestWithUsernameAndPassword(String username, String password) throws Throwable {
        request = given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(username,password).body("{\n" +
                "  \"address\": \"adTest\",\n" +
                "  \"city\": \"cityT\",\n" +
                "  \"firstName\": \"test\",\n" +
                "  \"id\": 101,\n" +
                "  \"lastName\": \"testf\",\n" +
                "  \"pets\": [\n" +
                "    {\n" +
                "      \"birthDate\": \"2018-10-30T10:56:26.545Z\",\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"pet\",\n" +
                "      \"owner\": {},\n" +
                "      \"type\": {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"string\"\n" +
                "      },\n" +
                "      \"visits\": [\n" +
                "        {\n" +
                "          \"date\": \"yyyy/MM/dd\",\n" +
                "          \"description\": \"string\",\n" +
                "          \"id\": 0,\n" +
                "          \"pet\": {}\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"telephone\": \"072377\"\n" +
                "}").contentType(ContentType.JSON);

    }

    @When("^I perform Post request to \"([^\"]*)\"$")
    public void iPerformPostRequestTo(String path) throws Throwable {
        response = request.when().post(path);
    }


    @Given("^I have access to perform Delete request with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iHaveAccessToPerformDeleteRequestWithUsernameAndPassword(String username, String password) throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(username,password).
                pathParam("specialtyId",15).
                contentType(ContentType.JSON);
    }

    @When("^I perform a Delete to \"([^\"]*)\"$")
    public void iPerformADeleteTo(String path) throws Throwable {
        response = request.when().delete(path);
    }


    @Given("^I have access to perform Put request with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iHaveAccessToPerformPutRequestWithUsernameAndPassword(String username, String password) throws Throwable {
        request = given().
                baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().
                preemptive().
                basic(username,password).
                pathParam("petTypeId",82).
                body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"name\": \"Animall\"\n" +
                        "}").
                contentType(ContentType.JSON);
    }

    @When("^I perform a Put to \"([^\"]*)\"$")
    public void iPerformAPutTo(String path) throws Throwable {
        response = request.when().put(path);
    }
}
