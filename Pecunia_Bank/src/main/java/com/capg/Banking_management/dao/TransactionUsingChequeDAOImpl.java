package com.capg.Banking_management.dao;

import java.util.Date;
import java.awt.List;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capg.Banking_management.model.Transaction;
import com.capg.Banking_management.model.TransactionModel;



public class TransactionUsingChequeDAOImpl implements TransactionUsingChequeDAO{
	Map<String,TransactionModel> transactionModel=new HashMap<String,TransactionModel>();
	public TransactionUsingChequeDAOImpl(){
		addSomeAccountDetails();
	}
	public void addSomeAccountDetails(){
		TransactionModel t1=new TransactionModel("123456789012","Nikshitha",3000,
				Arrays.asList(new Transaction(100000000001L,LocalDate.now())));
		TransactionModel t2=new TransactionModel("123456789013","Akshitha",4000,
				Arrays.asList(new Transaction(100000000002L,LocalDate.now())));
		transactionModel.put(t1.getAccountNumber(),t1);
		transactionModel.put(t2.getAccountNumber(),t2);
		
	}

	public boolean addAccountDetails(TransactionModel accountDetails) {
		if(transactionModel.containsKey(accountDetails)) {
			return false;
		}
		transactionModel.put(accountDetails.getAccountNumber(), accountDetails);
		return true;
	
	}
    

	public int getBalanceByID(String accountNumber) {
		if(!transactionModel.containsKey(accountNumber)) {
			System.out.println("No Account Found");
			return 0;
		}
		TransactionModel bal=transactionModel.get(accountNumber);
		 return bal.getBalance();
		 

	}

	public boolean addAmount(String accountNumber,int amount) {
		if(!transactionModel.containsKey(accountNumber)) {
			return false;
		}
		TransactionModel acc=transactionModel.get(accountNumber);
		acc.setBalance(acc.getBalance()+amount);
		return true;
		
		
	}
	public boolean deductAmount(String accountNumber,int amount) {
		if(!transactionModel.containsKey(accountNumber)) {
			return false;
		}
		TransactionModel acc=transactionModel.get(accountNumber);
		acc.setBalance(acc.getBalance()-amount);
		return true;
		
		
	}
	 

		
	public boolean creditUsingCheque(String accountNumber, String payeeAccountNumber, String chequeNumber,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, int amount) {
		
		try{
			if(amount<=100 || amount>=100000){
				throw new amountLessException("insufficient");
			}
			else if(payeeAccountNumber.length()!=12){
					throw new Exception("Invalid payee account number");
			}
			else if((accountNumber).length()!=12){
					throw new Exception("Invalid account number");
			}
			else if(chequeNumber.length()!=6){
					throw new Exception("Invalid Cheque number");
			}

				else if(chequeIFSC.length()!=10){
					int charCount=0;
					int numCount=0;
					for(int i=0;i<chequeIFSC.length();i++){
						char ch=chequeIFSC.charAt(i);
						if(ch>='0' && ch<='9'){
							numCount++;
						}
						else if(ch>='A'&&ch<='Z'){
							charCount++;
						}
					}
						if(numCount<=0 || charCount<=0){
						
							throw new Exception("Invalid IFSC code");
						}
     				}
			 		 
				//updateAccountBalance(accountNumber);
				addAmount(accountNumber,amount);
			 System.out.println("Deposited "+amount+" .RS Successfully  ");		 
		}				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				 
				return true;
			
		
  	}

	public boolean debitUsingCheque(String accountNumber, String payeeAccountNumber, String chequeNumber,
			String chequeBankName, String chequeIFSC, Date chequeIssueDate, int amount) {
		try{
			if(amount<=100 && amount>=100000){
				throw new amountLessException("insufficient");
			}
			else if(payeeAccountNumber.length()!=12){
				throw new Exception("Invalid payee account number");
			}
			else if((accountNumber).length()!=12){
				throw new Exception("Invalid account number");
			}
			else if(chequeNumber.length()!=6){
				throw new Exception("Invalid Cheque number");
			}
			else if(chequeIFSC.length()!=10){
				int charCount=0;
				int numCount=0;
				for(int i=0;i<chequeIFSC.length();i++){
					char ch=chequeIFSC.charAt(i);
					if(ch>='0' && ch<='9'){
						numCount++;
					}
					else if(ch>='A'&&ch<='Z'){
						charCount++;
					}
				}
					if(numCount<=0 || charCount<=0){
					
						throw new Exception("Invalid IFSC code");
					}
 				}
			
			deductAmount(accountNumber,amount);
				System.out.println("withdrawn "+amount+" .RS Successfully ");
			
	}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			 

		return true;


 	}
 	  
	 
	 
  
	 
	
}

class amountLessException extends Exception{
	amountLessException(String msg){
		super(msg);

	}
}
class AccountException extends Exception{
	AccountException(String msg){
		super(msg);

	}
}


