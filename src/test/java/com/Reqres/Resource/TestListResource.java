package com.Reqres.Resource;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Resource.object.GetResourceList;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestListResource {
	@Test
	public void testListResource() {
		
		RestResponse response = RestReqres.resource().getResourceData();
		GetResourceList data = response.mapJSONToObject(GetResourceList.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getPage() == 1,"Verify page");
		TestReporter.assertTrue(data.getPerPage() == 3,"Verify per page");
		TestReporter.assertTrue(data.getTotal() == 12,"Verify total");
		TestReporter.assertTrue(data.getTotalPages() == 4,"Verify total pages");
		TestReporter.assertTrue(data.getData().size() ==3,"Verify data list contains 3 results");
	}
}
