package com.Reqres.Patch;

import com.Reqres.RestReqres;
import com.Reqres.Patch.object.PatchRequest;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class Patch {
	private RestService restService = new RestService();
	private String path = RestReqres.baseUrl + "/api/users";
	
	public RestResponse patchData(PatchRequest request) {
		return restService.sendPatchRequest(path + "/2", HeaderType.JSON, restService.getJsonFromObject(request));
	}
}
