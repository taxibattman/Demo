package com.Reqres.Resource;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Resource.object.GetResourceData;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestResourceNotFound {
	@Test
	public void testResourceNotFound() {
		RestResponse response = RestReqres.resource().getResource("23");
		GetResourceData data = response.mapJSONToObject(GetResourceData.class);
		
		TestReporter.logAPI(response.getStatusCode() == 404, "Validating the Correct Response", response);
		
		TestReporter.assertTrue(response.getStatusCode() == 404, "Verify correct response");
	}
}
