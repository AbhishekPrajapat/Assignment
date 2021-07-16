package com.company.assignment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.company.assignment.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {
	
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/getUserAmount")
	public Map<String,Double> getTransactionAmount(@RequestParam Integer userId,@RequestParam(required = false) String txnType) throws IOException {
		if(txnType!=null && !(txnType.equalsIgnoreCase("credit") || txnType.equalsIgnoreCase("debit"))) {
			throw new IOException("txnType must be either credit or debit");
		}
		Map<String,Double> map = new HashMap();
		Double amount = transactionService.getUserTransaction(userId, txnType);
		map.put("totalAmount", amount);
		return map;
	}
}
