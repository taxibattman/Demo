package com.Reqres.Resource.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {
	private Long id;
	private String name;
	private Long year;
	private String color;
	@JsonProperty("pantone_value")
	private String pantoneValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPantoneValue() {
		return pantoneValue;
	}

	public void setPantoneValue(String pantoneValue) {
		this.pantoneValue = pantoneValue;
	}

}

