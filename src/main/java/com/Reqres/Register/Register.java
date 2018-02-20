package com.Reqres.Register;

import com.Reqres.RestReqres;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.Reqres.Register.object.Request;

public class Register {
	
	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/register";
	public RestResponse createRegister(Request request) {
		return restService.sendPostRequest(Path, HeaderType.JSON, RestService.getJsonFromObject(request));
	}
	
}
