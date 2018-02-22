package com.Reqres.User;

import com.Reqres.RestReqres;
import com.Reqres.User.object.CreateUserData;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class User {
	
	private RestService restService = new RestService();
	private String path = RestReqres.baseUrl + "/api/users";
	
	public RestResponse getUserData(String page) {
		return restService.sendGetRequest(path + "?page=" + page);
	}
	
	public RestResponse getUser(String id) {
		return restService.sendGetRequest(path + "/" + id);
	}
	
	public RestResponse createNewUser(CreateUserData create) {
		return restService.sendPostRequest(path, HeaderType.JSON, RestService.getJsonFromObject(create));
	}
}
