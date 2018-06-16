

public interface IAccountService 
{
	
	public void getAccountDetails();
	public double getBalance();               //Method used to check the balance of account
	public void withdrawAmount(int amount) throws Exception;     //Method used to withdraw amount
	public void depositAmount(int amount) throws NegativeAmount;       //Method used to deposit amount
	public void getMiniStatement();           //Method used to get mini statement
}