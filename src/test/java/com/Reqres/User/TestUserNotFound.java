package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.User.object.GetUserResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestUserNotFound {
	
	@Test
	public void testUserNotFound() {
		RestResponse response = RestReqres.user().getUser("23");
		GetUserResponse data = response.mapJSONToObject(GetUserResponse.class);
		
		TestReporter.logAPI(response.getStatusCode() == 404, "Validating the Correct Response", response);
		
		TestReporter.assertTrue(response.getStatusCode() == 404, "Verify correct response");
	}
}
