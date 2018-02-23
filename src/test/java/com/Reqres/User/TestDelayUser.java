package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.User.object.GetUserDelay;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestDelayUser {
	@Test
	public void testDelayUser() {

		RestResponse response = RestReqres.user().createDelay();
		GetUserDelay data = response.mapJSONToObject(GetUserDelay.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);
		
		TestReporter.assertTrue(data.getPage() == 1, "Verify correct page");
		TestReporter.assertTrue(data.getPerPage() == 3, "Verify correct per page");
		TestReporter.assertTrue(data.getTotal() == 12, "Verify correct total");
		TestReporter.assertTrue(data.getTotalPages() == 4, "Verify correct page");
		TestReporter.assertTrue(data.getData().size() ==3, "Verify correct list size");
	}
}
