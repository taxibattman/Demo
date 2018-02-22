package com.Reqres.Login;

import com.Reqres.RestReqres;
import com.Reqres.Login.object.LoginRequest;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class Login {
	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/login";
	
	public RestResponse createLogin(LoginRequest request) {
		return restService.sendPostRequest(Path, HeaderType.JSON, RestService.getJsonFromObject(request));
	}
}
