package com.Reqres.Patch;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Patch.object.PatchRequest;
import com.Reqres.Patch.object.PatchResponse;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestPatch {
	@Test
	public void testPatch() {
		String name = "morpheus";
		String job = "zion resident";
		
		PatchRequest request = new PatchRequest();
		request.setName(name);
		request.setJob(job);
		
		RestResponse response = RestReqres.patch().patchData(request);
		PatchResponse data = response.mapJSONToObject(PatchResponse.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);
		//TODO
		//debug
		TestReporter.assertTrue(data.getName().equals(name), "Verify correct name");
		
		TestReporter.assertTrue(data.getJob().equals(job), "Verify correct job");
		TestReporter.assertTrue(data.getUpdatedAt().contains("2018"), "Verify correct timestamp");		
	}
}