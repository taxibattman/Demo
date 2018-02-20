package com.Reqres.Register;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Register.object.Request;
import com.Reqres.Register.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestRegister {
	
	@Test
	public void testRegister() {
		
		String email = "sydney@fife";
		String password = "pistol";
		
		Request request = new Request();
		request.setEmail(email);
		request.setPassword(password);
		
		RestResponse response = RestReqres.register().createRegister(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 201, "Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getError() == "", "Validating the Token ID");
	}
}
