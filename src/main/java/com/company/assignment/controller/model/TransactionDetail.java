package com.company.assignment.controller.model;

import java.util.*;

public class TransactionDetail {
	
	Integer page;
	
	Integer per_page;
	
	Integer total;
	
	Integer total_pages;
	
	List<Transaction> data;
	
	

	public TransactionDetail(Integer page, Integer per_page, Integer total, Integer total_pages,
			List<Transaction> data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<Transaction> getData() {
		return data;
	}

	public void setData(List<Transaction> data) {
		this.data = data;
	}
	
	

}
