package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import Commons.DataReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class post {

	String userFirstName,userLastName, userContactNumber,userEmailId,plotNumber,street,state,country,zipCode,caseno,code,message,endpoint,testtype,userid,patchbody,username,password;
	DataReader dr = new DataReader();
	String postrequest, requesturl;
	String baseurl="https://userserviceapp-f5a54828541b.herokuapp.com/uap/";
	private Response response;
	
	public void setvaluesforfield(int rownumber) throws IOException {
		 userFirstName = dr.userdata(rownumber,"userFirstName");
		 userLastName = dr.userdata(rownumber,"userLastName");
		 userContactNumber = dr.userdata(rownumber,"userContactNumber");
		 userEmailId = dr.userdata(rownumber,"userEmailId");
		 plotNumber = dr.userdata(rownumber,"plotNumber");
		 street = dr.userdata(rownumber,"street");
		 state = dr.userdata(rownumber,"state");
		 country = dr.userdata(rownumber,"country");
		 zipCode = dr.userdata(rownumber,"zipCode");
		 caseno = dr.userdata(rownumber,"caseno");
		 code = dr.userdata(rownumber,"code");
		 message = dr.userdata(rownumber,"message");
		 endpoint = dr.userdata(rownumber,"endpoint");
		testtype = dr.userdata(rownumber,"testtype");
		userid = dr.userdata(rownumber,"userid");
		patchbody = dr.userdata(rownumber,"patchbody");
		username = dr.userdata(rownumber,"username");
		password = dr.userdata(rownumber,"password");
	}
	
	public void requestbodywithallfields() {
		try {
	        ObjectMapper mapper = new ObjectMapper();
	        
	        ObjectNode requestbody = mapper.createObjectNode();
	        requestbody.put("userFirstName", userFirstName);
	        requestbody.put("userLastName", userLastName);
	        requestbody.put("userContactNumber",userContactNumber);
	        requestbody.put("userEmailId",userEmailId);
	        
	    	 ObjectNode address = mapper.createObjectNode();
	    	 address.put("plotNumber",plotNumber);
	    	 address.put("street",street);
	    	 address.put("state",state);
	    	 address.put("country",country);
	    	 address.put("zipCode",zipCode);
	    	 
	    	 requestbody.set("userAddress", address);
	    	 
	    	 postrequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestbody);
	         System.out.println(postrequest);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
		
	@Given("User creates  the POST User Api request with valid values from {int} for every field in the json")
	public void user_creates_the_post_user_api_request_with_valid_values_from_for_every_field_in_the_json(int rownumber) throws IOException {
		setvaluesforfield(rownumber);
		requestbodywithallfields();
		requesturl = baseurl + endpoint;
		System.out.println(requesturl);
	}
	
	@When("POST User Api request is sent")
	public void post_user_api_request_is_sent() {
		response = given().
						auth().preemptive().basic(username, password).
						contentType("application/json").            
						body(postrequest).
					when().post(""+requesturl+"");
	}

	@Then("Success message is displayed and all values in the {int} matches to the values in the response")
	public void success_message_is_displayed_and_all_values_in_the_matches_to_the_values_in_the_response(Integer int1) {
			response.
					then().statusCode(201).log().body();
	}


}
