package com.Reqres.Login;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Login.object.LoginRequest;
import com.Reqres.Login.object.LoginResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestLoginFail {

	@Test
	public void testLoginFail() {
		String email = "peter@klaven";

		LoginRequest request = new LoginRequest();
		request.setEmail(email);

		RestResponse response = RestReqres.login().createLogin(request);
		LoginResponse data = response.mapJSONToObject(LoginResponse.class);
		
		TestReporter.logAPI(response.getStatusCode() == 400, "Validating correct response", response);
		
		TestReporter.assertTrue(data.getError().equals("Missing password"), "Verify correct error");
	}
}
