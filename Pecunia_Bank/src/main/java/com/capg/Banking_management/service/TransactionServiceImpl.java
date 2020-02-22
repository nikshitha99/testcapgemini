package com.capg.Banking_management.service;

import java.util.Date;

import com.capg.Banking_management.dao.TransactionUsingChequeDAO;
import com.capg.Banking_management.dao.TransactionUsingChequeDAOImpl;
import com.capg.Banking_management.model.TransactionModel;

public class TransactionServiceImpl implements TransactionService{
	TransactionUsingChequeDAO transactionDAO=new TransactionUsingChequeDAOImpl();
	public boolean creditUsingCheque(String accountNumber,String payeeAccountNumber, String chequeNumber,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, int amount) {

		return transactionDAO.creditUsingCheque(accountNumber,payeeAccountNumber,chequeNumber,chequeBankName,chequeIFSC,chequeIssueDate, amount) ;
	}

	public boolean debitUsingCheque(String accountNumber,String payeeAccountNumber, String chequeNumber,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, int amount) {

		return transactionDAO.debitUsingCheque(accountNumber,payeeAccountNumber,chequeNumber,chequeBankName,chequeIFSC,chequeIssueDate, amount);
	}
	 

}