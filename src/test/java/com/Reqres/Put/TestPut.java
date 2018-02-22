package com.Reqres.Put;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Put.object.PutRequest;
import com.Reqres.Put.object.PutResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestPut {
	
	@Test
	public void testPut() {
		String name = "morpheus";
		String job = "zion resident";
		
		PutRequest request = new PutRequest();
		request.setName(name);
		request.setJob(job);
		
		RestResponse response = RestReqres.put().putData(request);
		PutResponse data = response.mapJSONToObject(PutResponse.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);
		//TODO
		//debug
		TestReporter.assertTrue(data.getName().equals("morpheus"), "Verify correct name");
		
		TestReporter.assertTrue(data.getJob().equals("zion resident"), "Verify correct job");
		TestReporter.assertTrue(data.getUpdatedAt().contains("2018"), "Verify correct timestamp");		
	}
}
