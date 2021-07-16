package com.company.assignment.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.company.assignment.contants.Constant;
import com.company.assignment.controller.model.Transaction;
import com.company.assignment.controller.model.TransactionDetail;
import com.company.assignment.service.TransactionService;
import com.google.gson.Gson;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Double getUserTransaction(Integer uid, String txnType) {
	
		Integer page = 1;
		Double amount = (double) 0;
		TransactionDetail detail = getTransactionList(uid,page);
		List<Transaction> transactions = detail.getData();
		amount = amount + getAmount(transactions, txnType);
		while(page < detail.getTotal_pages()) {
			detail = getTransactionList(uid,++page);
			transactions = detail.getData();
			amount = amount + getAmount(transactions, txnType);
		}
		return amount;
	}
	
	 private HttpEntity<String> getHeader(){
	    	HttpHeaders headers = new HttpHeaders();
		    headers.set("Accept", "*/*");
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		    return entity;
	 }
	 
	 private Double getAmount(List<Transaction> transactions,String txnType) {
		 if(transactions == null || transactions.size() == 0)
			 return (double) 0;
		 if(txnType != null) {
			transactions = transactions.stream().filter(data -> data.getTxnType().toString().equalsIgnoreCase(txnType))
			 			 		.collect(Collectors.toList()); 
		 }
		 Double totalAmount = (double) 0;
		 for(Transaction transaction : transactions) {
			 System.out.println(transaction);
			totalAmount = totalAmount + Double.parseDouble(transaction.getAmount().replaceAll("[^\\d.]", ""));
		 }
		 return totalAmount;
	 }
	 
	 private TransactionDetail getTransactionList(Integer userId,Integer page){
		 ResponseEntity<String> response = restTemplate.exchange(Constant.TRANSACTION_URI, HttpMethod.GET, getHeader(), String.class,userId,page);
		 Gson gson = new Gson();
		 TransactionDetail detail = gson.fromJson(response.getBody(),TransactionDetail.class);
		 return detail;
	 }

}
