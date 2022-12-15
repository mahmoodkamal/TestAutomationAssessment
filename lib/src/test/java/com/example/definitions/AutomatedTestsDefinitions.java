package com.example.definitions;

import junit.framework.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Paths;

import org.junit.*;
import org.junit.Assert;


import com.example.actions.FindBorrowingCapacityPageActions;
import com.example.utils.HelperClass;
import com.google.common.io.Files;

import org.json.simple.JSONObject;


import java.nio.file.Paths;  
import java.util.Scanner;  


 
public class AutomatedTestsDefinitions {
	
	    String globalStatusVariable = ""; 
	    String globalResponseIDFromPostRequest= "";
	    String globalResponseIDFromGetRequest="";
	    String globalMessageInResponse= "";
         
	    FindBorrowingCapacityPageActions findBorrowingAmount = new FindBorrowingCapacityPageActions();
	         
	    @Given("User is on Calculator page {string}")
	    public void BorrowingCapacityTest(String url) {
	         
	        HelperClass.openPage(url);
	    }
	  
	    @When("User enters application Type as {string} and annual income as {string} and borrow type as {string} and annual other income as {string} and monthly living expenses as {string} and current home monthly repayment as {string} and other loan monthly repayment as {string} and other monthly commitment as {string} and total credit card limit as {string} and number of dependants as {string}")
	    public void setUserDetails(String applicationType, String annualIncome, String borrowType, String annualOtherIncome, String monthlyLivingExpenses, String currentHomeLoanMonthlyRepayment, String otherLoanMonthlyRepayment, String otherMonthlyCommitment, String totalCreditCardLimit, String numberOfDependants) {
	  
	    	findBorrowingAmount.setApplicationType(applicationType); 
	    	findBorrowingAmount.enterAnnualIncome(annualIncome);
	    	findBorrowingAmount.setBorrowType(borrowType);
	    	findBorrowingAmount.enterAnnualOtherIncome(annualOtherIncome);
	    	findBorrowingAmount.enterMonthlyLivingExpenses(monthlyLivingExpenses);
	    	findBorrowingAmount.enterCurrentHomeLoanMonthlyRepayments(currentHomeLoanMonthlyRepayment);
	    	findBorrowingAmount.enterOtherLoanMonthlyRepayments(otherLoanMonthlyRepayment);
	    	findBorrowingAmount.enterOtherMonthlyCommitments(otherMonthlyCommitment);
	    	findBorrowingAmount.enterTotalCreditCardLimits(totalCreditCardLimit);
	    	findBorrowingAmount.selectNumberOfDependants(numberOfDependants);
	    	findBorrowingAmount.clickButtonToCalculateBorrowingCapacity();
	    	try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	   
	    @Then("Borrowing Capacity is {string}")
	    public void matchBorrowedValue(String borrowedAmount) {
	    	System.out.println("Borrowed value on page is: " + findBorrowingAmount.getBorrowedAmount());
	    	System.out.println("Borrowed value according to step is: " + borrowedAmount);
	    	Assert.assertEquals(findBorrowingAmount.getBorrowedAmount(), borrowedAmount);
	    }
	    
	    
	    @When("User clicks Start Over")
	    public void startTheProcessOver() {
	    	findBorrowingAmount.clickButtonToStartOver();
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @Then("Fields get reset")
	    public void checkIfFieldsHaveBeenReset() {
	    	String valueOfField= findBorrowingAmount.valueOfField("Monthly Living Expenses");
	    	Assert.assertEquals(valueOfField, "");
	    }
	    
	    
	    @When("User attempts to register a station without API key")
	    public void registerStationWithoutValidKey() {
	    	
	    	String myjson = "{\"external_id\":\"Demo_Test_Mahmood\",\"name\": \"Team demo Test Station 001\",\"latitude\": 33.33,\"longitude\": -122.43,\"altitude\": 222}";
	    	
	    	Response response = given()
	                .header("Content-type", "application/json")
	                .and()
	                .body(myjson)
	                .when()
	                .post("http://api.openweathermap.org/data/3.0/stations?APPID=")
	                .then()
	                .extract().response();
	    	
	    	System.out.println("Response after creation: "+ response.statusLine());
	    	globalStatusVariable= response.statusLine();
	    	globalMessageInResponse= response.jsonPath().getString("message");
	    	System.out.println("Message in Response: "+globalMessageInResponse);
	    	
	    }
	    
	    @Then("A status code of 401 gets returned and a message is also included")
	    public void checkStatusCode() {
	    	Assert.assertEquals("HTTP/1.1 401 Unauthorized",globalStatusVariable);
	    	Assert.assertEquals("Invalid API key. Please see https://openweathermap.org/faq#error401 for more info.", globalMessageInResponse);
	    	
	    }
	    	
	    @When("User attempts to register the first station with a valid key")
	    public void registerStationWithValidKey() {
	    	String myjson = "{\"external_id\":\"Demo_Test001\",\"name\": \"Team demo Test Station 001\",\"latitude\": 33.33,\"longitude\": -122.43,\"altitude\": 222}";
	    	
	    	Response response = given()
	                .header("Content-type", "application/json")
	                .and()
	                .body(myjson)
	                .when()
	                .post("http://api.openweathermap.org/data/3.0/stations?APPID=b6d232325f2a5b83e97d2d0d10f3201b")
	                .then()
	                .extract().response();
	    	
	    	System.out.println("Response after creation: "+ response.statusLine());
	    	globalStatusVariable= response.statusLine();
	    	System.out.println("ID from JSON response: "+ response.jsonPath().getString("ID"));
	    	globalResponseIDFromPostRequest = response.jsonPath().getString("ID");
	 
	    }
	    
	    @Then("A status code of 201 gets returned")
	    public void checkStatusFirstStation() {
	    	Assert.assertEquals("HTTP/1.1 201 Created",globalStatusVariable);
	    }
	    
	    @When("Script makes a GET request for the first station")
	    public void getJsonOfFirstStation() {
	    	Response response = given()
	                .contentType(ContentType.JSON)
	                .param("APPID", "b6d232325f2a5b83e97d2d0d10f3201b")
	                .when()
	                .get("http://api.openweathermap.org/data/3.0/stations/"+globalResponseIDFromPostRequest)
	                .then()
	                .extract().response();
	    	
	    	globalResponseIDFromGetRequest = response.jsonPath().getString("id");
	    	
	    }
	    
	    @Then("The correct JSON response is sent")
	    public void checkIDFromResponseForSecondStation() {
	    	Assert.assertEquals(globalResponseIDFromPostRequest, globalResponseIDFromGetRequest);
	    }
	    
	    @When("User attempts to register the second station with a valid key")
	    public void registerSecondStationWithValidKey() {
	    	String myjson = "{\"external_id\":\"Demo_Test002\",\"name\": \"Team demo Test Station 002\",\"latitude\": 44.44,\"longitude\": -122.44,\"altitude\": 111}";
	    	
	    	Response response = given()
	                .header("Content-type", "application/json")
	                .and()
	                .body(myjson)
	                .when()
	                .post("http://api.openweathermap.org/data/3.0/stations?APPID=b6d232325f2a5b83e97d2d0d10f3201b")
	                .then()
	                .extract().response();
	    	
	    	System.out.println("Response after creation: "+ response.statusLine());
	    	globalStatusVariable= response.statusLine();
	    	System.out.println("ID from JSON response: "+ response.jsonPath().getString("ID"));
	    	globalResponseIDFromPostRequest = response.jsonPath().getString("ID");
	 
	    }
	    
	    @Then("A status code of 201 gets returned for second station")
	    public void checkStatusSecondStation() {
	    	Assert.assertEquals("HTTP/1.1 201 Created",globalStatusVariable);
	    }
	    
	    @When("Script makes a GET request for the second station")
	    public void getJsonOfSecondStation() {
	    	Response response = given()
	                .contentType(ContentType.JSON)
	                .param("APPID", "b6d232325f2a5b83e97d2d0d10f3201b")
	                .when()
	                .get("http://api.openweathermap.org/data/3.0/stations/"+globalResponseIDFromPostRequest)
	                .then()
	                .extract().response();
	    	
	    	globalResponseIDFromGetRequest = response.jsonPath().getString("id");
	    	
	    }
	    
	    @Then("The correct JSON response is sent for second station")
	    public void checkIDFromResponseForFirstStation() {
	    	Assert.assertEquals(globalResponseIDFromPostRequest, globalResponseIDFromGetRequest);
	    }
	    
}

