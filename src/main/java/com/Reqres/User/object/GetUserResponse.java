package com.Reqres.User.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"data"
})
public class GetUserResponse {

	@JsonProperty("data")
	private RootData data;

	@JsonProperty("data")
	public RootData getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(RootData data) {
		this.data = data;
	}

}