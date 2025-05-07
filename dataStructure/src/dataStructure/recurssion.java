package dataStructure;

public class recurssion
{
	public static void fun(int n)
	{
		if(n>5)
			return;
		
		System.out.println(n);
		fun(n+1);
		System.out.println(n);
		
		return;
	}
	
	
	public static void main(String[] args) 
	{
		
		fun(1);
		System.out.println("End");
	}
}
