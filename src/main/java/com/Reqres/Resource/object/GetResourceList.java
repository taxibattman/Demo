package com.Reqres.Resource.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetResourceList {
	private Long page;
	@JsonProperty("per_page")
	private Long perPage;
	private Long total;
	@JsonProperty("total_pages")
	private Long totalPages;
	private List<Datum> data = null;

	public Long getPage() {
	return page;
	}

	public void setPage(Long page) {
	this.page = page;
	}

	public Long getPerPage() {
	return perPage;
	}

	public void setPerPage(Long perPage) {
	this.perPage = perPage;
	}

	public Long getTotal() {
	return total;
	}

	public void setTotal(Long total) {
	this.total = total;
	}

	public Long getTotalPages() {
	return totalPages;
	}

	public void setTotalPages(Long totalPages) {
	this.totalPages = totalPages;
	}

	public List<Datum> getData() {
	return data;
	}

	public void setData(List<Datum> data) {
	this.data = data;
	}
}
