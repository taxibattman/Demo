package com.Reqres.Login;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Login.object.LoginRequest;
import com.Reqres.Login.object.LoginResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestLogin {
	
	@Test
	public void testLogin() {
		
	
	String email = "peter@klaven";
	String password = "cityslicka";
	
	LoginRequest request = new LoginRequest();
	request.setEmail(email);
	request.setPassword(password);
	
	RestResponse response = RestReqres.login().createLogin(request);
	LoginResponse data = response.mapJSONToObject(LoginResponse.class);
	
	TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);
	
	TestReporter.assertTrue(data.getToken().equals("QpwL5tke4Pnpja7X"), "Verify correct token");
	}
}
