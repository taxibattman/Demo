package com.Reqres.Resource;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Resource.object.GetResourceData;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleResource {

	@Test
	public void testSingleResource() {
		
		RestResponse response = RestReqres.resource().getResource("2");
		GetResourceData data = response.mapJSONToObject(GetResourceData.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getData().getId() == 2, "Validate Correct ID");
		TestReporter.assertTrue(data.getData().getName().equals("fuchsia rose"), "Validate Correct Name");
		TestReporter.assertTrue(data.getData().getYear() == 2001, "Validate Correct Year");
		TestReporter.assertTrue(data.getData().getColor().equals("#C74375"), "Validate Correct Color");
		TestReporter.assertTrue(data.getData().getPantoneValue().equals("17-2031"), "Validate Correct Pantone Value");
	}
}
