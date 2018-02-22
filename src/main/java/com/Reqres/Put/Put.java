package com.Reqres.Put;

import com.Reqres.RestReqres;
import com.Reqres.Put.object.PutRequest;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;

public class Put {
	private RestService restService = new RestService();
	private String path = RestReqres.baseUrl + "/api/users";
	
	public RestResponse putData(PutRequest request) {
		return restService.sendPutRequest(path + "/2", HeaderType.JSON, RestService.getJsonFromObject(request));
	}
}
