package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;

import com.Reqres.User.object.CreateUserData;
import com.Reqres.User.object.CreateUserResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestCreateUser {
	@Test
	public void testCreateUser() {
		String name = "morpheus";
		String job = "leader";
		
		CreateUserData create = new CreateUserData();
		create.setName(name);
		create.setJob(job);
		
		RestResponse response = RestReqres.user().createNewUser(create);
		CreateUserResponse data = response.mapJSONToObject(CreateUserResponse.class);
		
		TestReporter.logAPI(response.getStatusCode() == 201, "Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getName().equals("morpheus"), "Verify correct name");
		TestReporter.assertTrue(data.getJob().equals("leader"), "Verify correct job");
		//TODO
		//debug
		TestReporter.assertTrue(Integer.parseInt(data.getId()) > 0, "Verify correct id");
		//TODO
		//debug
		TestReporter.assertTrue(data.getCreatedAt().contains("2018"), "Verify correct timestamp");
	}
}
