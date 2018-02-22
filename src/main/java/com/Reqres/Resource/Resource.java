package com.Reqres.Resource;

import com.Reqres.RestReqres;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

public class Resource {
	private RestService restService = new RestService();
	private String path = RestReqres.baseUrl + "/api/unknown";
	
	public RestResponse getResourceData() {
		return restService.sendGetRequest(path);
	}
	
	public RestResponse getResource(String id) {
		return restService.sendGetRequest(path + "/" + id);
	}
}
