
import java.io.Writer;
import java.util.*;
public class ClassMain 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("<<<<<<<Welcome to Banking System>>>>>>");
		System.out.println("Enter account Holder's Name");
		String name = scan.nextLine();
		AccountServiceImplementation customerObject = new AccountServiceImplementation(1234567, name);
		while(true)
		{
			System.out.println("\n\n1.Account Details\n2.Withdraw Money\n3.Deposit Money\n4.Mini Statement\n5.Exit\n\n");
			System.out.println("Enter your Choice:");
			int ch = scan.nextInt();
			switch(ch)
			{	
			case 1: 
				customerObject.getAccountDetails();
				break;
			case 2:
				System.out.println("Enter the amount to be withdraw:");
				int amount=scan.nextInt();
				try
				{
					customerObject.withdrawAmount(amount);
					
				}
				catch( BalanceLessThanZero ex)
				{
					System.out.println("Withdrawal Failed..!!!!");
					System.out.println("Exception Occured: "+ ex);
				}
				catch( NegativeAmount ex)
				{
					System.out.println("Withdrawal Failed..!!!");
					System.out.println("Exception Occured : "+ ex);
				}
				catch(MaxAmount ex)
				{
					System.out.println("Withdrawal Failed..!!!");
					System.out.println("Exception Occured : "+ ex);
				}
				catch (Exception e)
				{
					System.out.println("Unknown Exception Occurred..!!!!");
				} 
				break;
			case 3:
				System.out.println("Enter the amount to be Deposited: ");
				int amnt=scan.nextInt();
				try
				{
					customerObject.depositAmount(amnt);
				}
				catch(NegativeAmount ex)
				{
					System.out.println("Deposit Failed...!!!!!");
					System.out.println("Exception Occurred is : "+ ex);
				}
					break;
			case 4:
				customerObject.getMiniStatement();
				break;
			case 5:
				System.out.println("<<Exiting>>");
				System.exit(0);
				break;
			}
		}
	}
}
