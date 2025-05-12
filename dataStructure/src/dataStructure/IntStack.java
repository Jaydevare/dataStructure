package dataStructure;
import java.util.Scanner;

public class IntStack {
	protected int arr[];
	private int top;
	
	public IntStack() 
	{
		arr = new int[10];
		top = -1;
	}

	public IntStack(int s)
	{
		arr = new int[s];
		top = -1;
	}
	
	public void push(int d)
	{
		if(top==arr.length-1)
		{
			System.out.println("Stack OverFlow...");
			return;
		}
		top = top+1;
		arr[top]=d;
		return;
	}
	
	public int pop()
	{
		//System.out.println("thstrh");
		int d = 0;
		if(top == -1)
		{
			System.out.println("Stack is Empty");
			return d;
		}
		d = arr[top];
		top = top-1;
		return d;
	}
	
	public int peek()
	{
		int d = 0;
		if(top==-1)
		{
			System.out.println("Stack is Empty");
			return d;
		}
		return arr[top];
	}
	
	public boolean isFull()
	{
		if(top==arr.length-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		if(top==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		IntStack s1 = new IntStack(6);
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("=====Menu=====");
			System.out.println("1.Push\n2.Pop\n3.Peek\n4.Exit");
			System.out.println("Enter your choice 1 to 4");
			
			ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("no ");
				int d = sc.nextInt();
				s1.push(d);
				break;
				
			case 2:
				System.out.println(s1.pop());
				break;
			
			case 3:
				System.out.println(s1.peek());
				break;
				
			}
			
		}while(ch!=4);
	}
	
}

		
		
		


