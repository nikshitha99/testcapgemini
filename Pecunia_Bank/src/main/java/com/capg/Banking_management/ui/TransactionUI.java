package com.capg.Banking_management.ui;
import com.capg.Banking_management.dao.TransactionUsingChequeDAO;
import com.capg.Banking_management.dao.TransactionUsingChequeDAOImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class TransactionUI {
	static TransactionUsingChequeDAO transactionService=new TransactionUsingChequeDAOImpl();
	static Scanner in=new Scanner(System.in);
	public static void main(String []args) throws ParseException{
		 
		for(;;){
			int choice;
			System.out.println("Enter your choice");
			System.out.println("1-Credit Using Cheque");
			System.out.println("2-Debit Using Cheque");
			System.out.println("3-Exit");
			choice=in.nextInt();                               
			switch(choice){
			case 1:
				creditUsingChequeInfo();
				break;
			case 2:
				debitUsingChequeInfo();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			
			}
		}
	}
 	private static void creditUsingChequeInfo() throws ParseException {
		 System.out.println("Enter payeeAccountNumber ");
		 String payeeAccountNumber = in.next();
		 
		 System.out.println("Enter account number");
		 String accountNumber=in.next();
		 System.out.println("Enter cheque number");
		 String chequeNumber=in.next();
		 System.out.println("Enter  cheque IFSC code");
		 
		 String chequeIFSC=in.next();
		 System.out.println("Enter amount to be credited");
		 int amount=in.nextInt();
		 System.out.println("Enter Bank name");
		 String chequeBankName=in.next();
		 System.out.println("Enter Date");
		 String date=in.next();
		 Date chequeIssueDate=new SimpleDateFormat("dd-MM-yyyy").parse(date);

		 if(transactionService.creditUsingCheque(accountNumber,payeeAccountNumber, chequeNumber, chequeBankName, chequeIFSC, chequeIssueDate, amount)){
			 System.out.println("Amount deposited Successfully");
		
		 }
		 
	}
 	private static void debitUsingChequeInfo() throws ParseException {
		 System.out.println("Enter payeeAccountNumber ");
		 String payeeAccountNumber = in.next();
		 System.out.println("Enter account number");
		 String accountNumber=in.next();
		 System.out.println("Enter cheque number");
		 String chequeNumber=in.next();
		 System.out.println("Enter  cheque IFSC code");
		 String chequeIFSC=in.next();
		 System.out.println("Enter amount to be credited");
		 int amount=in.nextInt();
		 System.out.println("Enter Bank name");
		 String chequeBankName=in.next();
		 System.out.println("Enter Date");
		 String date=in.next()+in.nextLine();
		 Date chequeIssueDate=new SimpleDateFormat("dd-mm-yyyy").parse(date);
		 
	
		if(transactionService.debitUsingCheque(accountNumber,payeeAccountNumber, chequeNumber,chequeBankName,chequeIFSC,chequeIssueDate,amount)){
			 System.out.println("Amount withdrawn Successfully");
		 }
		 
	}

 
}
//     123456789012     100000000001      123456     SBIN123456  pecunia   07-07-1998

 