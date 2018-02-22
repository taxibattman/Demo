package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.User.object.GetUserList;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestListUser {
	@Test
	public void testListUser() {
		RestResponse response = RestReqres.user().getUserData("2");
		GetUserList data = response.mapJSONToObject(GetUserList.class);
	
		TestReporter.logAPI(response.getStatusCode()==200, "Validating correct response", response);
		
		TestReporter.assertTrue(data.getPage() == 2, "Verify correct page");
		TestReporter.assertTrue(data.getPerPage() == 3, "Verify per page");
		TestReporter.assertTrue(data.getTotal() == 12, "Verify total");
		TestReporter.assertTrue(data.getTotalPages() == 4, "Verify total pages");
		TestReporter.assertTrue(data.getData().size() == 3, "Verify data list has 3 entries");

	}
}
