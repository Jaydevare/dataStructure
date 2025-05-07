package dataStructure;

public class recurrsionArray
{
//	public static void display(int a[],int i)
//	{
//		if(i>9)
//			return;
//		System.out.print(a[i]+" ");
//		display(a,i+1);
//		System.out.print(a[i]+" ");
//	}
	
//	public static int sum(int a[],int i)
//	{
//		if(i>9)
//			return 0;
//		
//		System.out.print(a[i]+" ");
//		return a[i]+sum(a,i+1);
//	}
	
//	public static int cnt(int n)
//	{
//		if(n/10 == 0)
//			return 1;
//		return 1+cnt(n/10);
//	}
//	
//	public static int sum_digit(int n)
//	{
//		if(n/10 == 0)
//			return n; 
//		return n%10+ sum_digit(n/10);
//	}
	
//	public static void display(int n)
//	{
//		if(n/10==0)
//		{
//			System.out.println(n);
//			return ;
//		}
//		
//		System.out.println(n%10);
//		display(n/10);
//	}
	
//	public static int power(int a, int p)
//	{
//		if(p==0)
//			return 1;
//		return a * power(a,p-1);
//	}
	
//	public static int factorial(int n)
//	{
//		if(n<2)
//			return 1;
//		else
//			return n * factorial(n-1);
//	}
	
	public static void fun2(int n)
	{
		System.out.println("Fun2 " + n);
		if(n>25)
			return;
		fun1(n+1);
	}
	
	public static void fun1(int n)
	{
		System.out.println("Fun1 " + n);
		if(n>25)
			return;
		fun2(n+1);
	}
	
	public static void main(String[] args)
	{
		int arr[] = new int[] {10,20,30,40,50,60,70,80,90,100};
//		display(arr,0);
//		System.out.println("\n"+"sum ="+sum(arr,0));
//		System.out.println("count = " + cnt(56789));
//		System.out.println("SUM = " + sum_digit(56789));
//		display(456789);
//		System.out.println("result = "+power(2,6));
//		System.out.println("FActorial ="+factorial(7));
		fun1(0);
	}
}

