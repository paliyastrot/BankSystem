

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class MiniStatement implements IMiniStatement
{
	ArrayList<String> info = new  ArrayList<String>();
	ArrayList<Integer> amount = new ArrayList<Integer>();
	Date date = new Date();
	
	@Override
	public void addTransactionDetails(String info, int amount)
	{
		if(this.info.size()>5)
		{
			this.info.remove(0);
			this.amount.remove(0);
		}
		else
		{
			this.info.add(info);
			this.amount.add(amount);
		}
	}
	@Override
	public void getMiniStatement()
	{
		Iterator<String> itrinfo = info.iterator();
		Iterator<Integer> itramount = amount.iterator();
		while(itrinfo.hasNext()&&itramount.hasNext())
			System.out.println("Account " + itrinfo.next()+ " with "+ itramount.next() + " on "+ this.date);
	}
	

}
