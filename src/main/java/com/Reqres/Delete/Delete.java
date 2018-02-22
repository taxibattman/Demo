package com.Reqres.Delete;

import com.Reqres.RestReqres;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

public class Delete {
//TODO
	private RestService restService = new RestService();
	private String path = RestReqres.baseUrl + "/api/users";
	
	public RestResponse deleteData() {
		return restService.sendDeleteRequest(path + "/2");
	}
}
