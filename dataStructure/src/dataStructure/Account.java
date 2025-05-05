package dataStructure;

public class Account
{
	private int accountNo;
	private String name;
	private float balance;
	
	
	
	public Account(int accountNo, String name, float balance)
	{
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public void depoite(float a)
	{
		balance += a;
		System.out.println("Balance ="+balance);
	}
	
	public void withdraw(float a)
	{
		balance -= a;
		System.out.println("Balance ="+balance);
	}
	
	public void transferFunds(Account toAccount, float amountToTransfer)
	{
		this.withdraw(amountToTransfer);
		toAccount.depoite(amountToTransfer);
	}
	
	public static void main(String[] args)
	{
		Account a1 = new Account(101,"Jay",100000);
		Account a2 = new Account(102,"Mayur",50000);
		
		a1.transferFunds(a2, 25000);
	}
	
}


