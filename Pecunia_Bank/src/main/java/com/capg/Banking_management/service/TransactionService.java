package com.capg.Banking_management.service;

import java.util.Date;

import com.capg.Banking_management.model.TransactionModel;

public interface TransactionService {
	public boolean creditUsingCheque( String accountNumber,String payeeAccountNumber,  String chequeNumber,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, int amount);
	public boolean debitUsingCheque(String accountNumber,String payeeAccountNumber,  String chequeNumber,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, int amount);
	
}
