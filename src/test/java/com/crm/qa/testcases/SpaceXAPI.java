package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class SpaceXAPI extends TestBase {
    @BeforeMethod
    public void setUp(){
        System.out.println("leaving blank for now in case token generation or any pre-req can be used furthur");
    }


    @Test
    public void getSpaceXLaunches() {

        // fetch base url from config properties file
        RestAssured.baseURI = prop.getProperty("apiUrl");

        RequestSpecification httpRequest = RestAssured.given();

        //Append end point an execute request
        Response response = httpRequest.request(Method.GET, "//v4/launches/latest" );

        // get the status code and validate it:
        int statusCode = response.getStatusCode();
        System.out.println("the status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //get the response body:
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
        //validate keys from response
        Assert.assertEquals(responseBody.contains("links"), true);





        System.out.println("the status line is: " + response.getStatusLine());

        //6. get the headers:
        Headers headers = response.getHeaders();
        System.out.println(headers);

        String contentType = response.getHeader("Content-Type");
        System.out.println("the value of content-type header is: " + contentType);

        String contentLength = response.getHeader("Content-Length");
        System.out.println("the value of Content-Length header is: " + contentLength);

        //get the key value by using JsonPath:
        JsonPath jsonPathValue = response.jsonPath();
        String articleVal = jsonPathValue.get("article");
        System.out.println("the value of aarticle is: " + articleVal);

        Assert.assertEquals(articleVal, "https://spaceflightnow.com/2020/05/30/nasa-astronauts-launch-from-us-soil-for-first-time-in-nine-years/");

        String youtube_id = jsonPathValue.get("youtube_id");
        System.out.println("the value of youtube id is: " + youtube_id);
        Assert.assertEquals(youtube_id, "xY96v0OIcK4");


        String Humidity = jsonPathValue.get("Humidity");
        System.out.println("the value of Humidity is: " + Humidity);

        String WeatherDescription = jsonPathValue.get("WeatherDescription");
        System.out.println("the value of WeatherDescription is: " + WeatherDescription);

        String WindSpeed = jsonPathValue.get("WindSpeed");
        System.out.println("the value of WindSpeed is: " + WindSpeed);

        String WindDirectionDegree = jsonPathValue.get("WindDirectionDegree");
        System.out.println("the value of WindDirectionDegree is: " + WindDirectionDegree);
    }





}
