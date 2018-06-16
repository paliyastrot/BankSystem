
import java.lang.*;
import java.util.*;

public class AccountServiceImplementation implements IAccountService
{
	HashMap<Integer, String> info = new HashMap<Integer, String>();
	private int accountNo ;
	double balance;    
	MiniStatement statement = new MiniStatement();          //class used for storing the details of last five transactions    		                       	
	
	
	public AccountServiceImplementation(int accountNo, String name)
	{
		this.info.put(accountNo, name);
		this.balance=0.00;
		this.accountNo = accountNo;
		
	}
	
	@Override
	public void getAccountDetails()
	{
		System.out.println("<<<<Account Details>>>>");
		System.out.println("Account Holder Name : "+ this.info.get(1234567));
		System.out.println("Account Number : "+ this.accountNo);
		System.out.println("Balance :  "+ this.balance);
	}
	
	@Override
	public double getBalance()
	{
		return this.balance;
		
	}
	
	@Override
	public void withdrawAmount(int amount) throws Exception          //Method for Withdrawing amount
	{
		if(this.balance==0)
			throw new BalanceLessThanZero("Account Balance is  : 0.00$ \nWithdrawal Unsuccessfull....!!!!");  //throwing customized exception
		if(amount<0)
			throw new NegativeAmount("Amount can not be Negative...!!!!");      //throwing customized exception
		if(amount>30000)
			throw new MaxAmount("Maximum Amount Limit Exceeded.  Amount should be less than 30,000");         //throwing customized exception
		else 
		{
			this.balance-=amount;
			System.out.println("Withdrawal Successful..!!!!");
			System.out.println("Remaining Balance is : "+ this.balance);
			this.statement.addTransactionDetails("Withdrawal", amount);
		}
	}
	
	@Override
	public void depositAmount(int amount) throws NegativeAmount      //Method for Depositing Amount
	{
		if(amount<0)
			throw new NegativeAmount("Amount Deposited Cannnot be Negative....!!!!");
		System.out.println("Deposit Successfull");
		this.balance+=amount;
		System.out.println("Balance is : "+ this.balance);
		this.statement.addTransactionDetails("Deposited", amount);
	}
	
	@Override
	public void getMiniStatement()     //Method for Mini Statement 
	{
		this.statement.getMiniStatement();
	}
}
