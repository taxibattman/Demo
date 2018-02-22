package com.Reqres.User.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserResponse {
	private String name;
	private String job;
	@JsonProperty("id")
	private String id;
	@JsonProperty("createdAt")
	private String createdAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
