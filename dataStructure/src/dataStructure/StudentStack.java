package dataStructure;
import java.util.Scanner;

public class StudentStack {


		protected Student arr[];
		private int top;
		
		public StudentStack() 
		{
			arr = new Student[10];
			top = -1;
		}

		public StudentStack(int s)
		{
			arr = new Student[s];
			top = -1;
		}
		
		public void push(Student d)
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
		
		public Student pop()
		{
			//System.out.println("thstrh");
			Student d = null;
			if(top == -1)
			{
				System.out.println("Stack is Empty");
				return d;
			}
			d = arr[top];
			top = top-1;
			return d;
		}
		
		public Student peek()
		{
			Student d = null;
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
			StudentStack s1 = new StudentStack(6);
			Student stud;
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
					System.out.println("Enter Roll No: ");
					int rno = sc.nextInt();
					System.out.println("Enter Name: ");
					String name = sc.next();
					System.out.println("Enter Marks of three subjects: ");
					float m1 = sc.nextFloat();
					float m2 = sc.nextFloat();
					float m3 = sc.nextFloat();
					stud = new Student(rno, name, m1, m2, m3);
					s1.push(stud);
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

		
		
		


