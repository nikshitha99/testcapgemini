package corejava.G.bank;

interface BankService {
}
public class Bank_Service implements BankService {

	public String BankServiceImpl (String Accountno) {
		BankDAO bd=new BankDAO();bd.getAccountById(Accountno);
		
	}

}
