package com.Reqres.User;


import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.Reqres.User.object.GetUserResponse;

public class TestSingleUser {
	
	@Test
	public void testSingleUser() {
		
		RestResponse response = RestReqres.user().getUser("2");
		GetUserResponse data = response.mapJSONToObject(GetUserResponse.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getData().getId() == 2, "Validating correct ID");
		TestReporter.assertTrue(data.getData().getFirstName().equals("Janet"), "Validating correct ID");
		TestReporter.assertTrue(data.getData().getLastName().equals("Weaver"), "Validating correct ID");
		TestReporter.assertTrue(data.getData().getAvatar().equals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"),"Validating correct ID");
	}
}
