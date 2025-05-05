package dataStructure;

import java.util.Scanner;

public class CiricularLinkedList
{
	private IntNode last;
	
	public CiricularLinkedList()
	{
		last = null;
	}


	public void setLast(IntNode last)
	{
		this.last = last;
	}
	
	public IntNode getLast()
	{
		return last;
	}
	
	public void insertFirs(int d)
	{
		IntNode new_node = new IntNode(d);
		if(last == null)
		{
			last = new_node;
			last.setNext(new_node);
			return;
		}
		new_node.setNext(last.getNext());
		last.setNext(new_node);
		return;
	}
	
	public void insertLast(int d)
	{
		IntNode new_node = new IntNode(d);
		if(last == null)
		{
			last =  new_node;
			last.setNext(new_node);
			return;
		}
		new_node.setNext(last.getNext());
		last.setNext(new_node);
		last = new_node;
	}
	
	public void insertByPos(int d, int pos)
	{
		IntNode new_node = new IntNode(d);
		if(last == null)
		{
			last = new_node;
			last.setNext(new_node);
			return;
		}
		if(pos == 1)
		{
			new_node.setNext(last.getNext());
			last.setNext(new_node);
			return;
		}
		IntNode iter = last.getNext();
		
		for(int i =1;i<pos-1 && iter.getNext()!=last.getNext();i++)
			iter = iter.getNext();
		
		if(iter.getNext()==last.getNext())
		{
			new_node.setNext(last.getNext());
			last.setNext(new_node);
			last = new_node;
			return;
		}
		new_node.setNext(iter.getNext());
		iter.setNext(new_node);
		return;
	}
	
	public int deleteFirst()
	{
		int d = -999;
		if(last == null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(last.getNext()==last)
		{
			d = last.getData();
			last.setNext(null);
			last = null;
			return d;
		}
		d = last.getNext().getData();
		last.setNext(last.getNext().getNext());
		return d;
	}
	
	public int deleteLast()
	{
		int d = -999;
		if(last == null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(last.getNext()==last)
		{
			d = last.getData();
			last.setNext(null);
			last = null;
			return d;
		}
		IntNode iter = last.getNext();
		
		do
		{
			iter = iter.getNext();
		}while(iter.getNext()!=last);
		
		d = iter.getNext().getData();
		iter.setNext(last.getNext());
		last.setNext(null);
		last = iter;
		return d;
	}

	public int deleteByPos(int pos)
	{
		int d = -999;
		if(last == null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(last.getNext()==last)
		{
			d = last.getData();
			last.setNext(null);
			last = null;
			return d;
		}
		if(pos == 1)
		{
			d = last.getNext().getData();
			last.setNext(last.getNext().getNext());
			return d;
		}
		
		IntNode iter = last.getNext();
		
		for(int i =1;i<pos-1 && iter.getNext()!=last.getNext();i++)
			iter = iter.getNext();
		
		if(iter.getNext()==last.getNext())
		{
			System.out.println("Enter position is wrong");
			return d;
		};
		
		if(iter.getNext()==last)
		{
			d = iter.getNext().getData();
			iter.setNext(last.getNext());
			last.setNext(null);
			last = iter;
			return d;
		}
		
		d = iter.getNext().getData();
		iter.setNext(iter.getNext().getNext());
		return d;
	}
	
	public void display()
	{
		if(last==null)
		{
			System.out.println("List Is Empty");
			return;
		}
		IntNode iter = last.getNext();
		
//		do
//		{
//			System.out.println(iter.getData()+"->");
//			iter = iter.getNext();
//		}while(iter!=last.getNext());
		
		while(true)
		{
			System.out.println(iter.getData()+"->");
			if(iter.getNext()== last.getNext())
				return;
			
			iter = iter.getNext();
		}
	}
	
	public static void main(String[] args)
	{
		CiricularLinkedList CirLL = new CiricularLinkedList();
		Scanner sc = new Scanner(System.in);
		int ch;
		do 
		{
			System.out.println("8.Enter Your choice");
			System.out.println("1.Insert First");
			System.out.println("2.Insert Last");
			System.out.println("3.Insert By Position");
			System.out.println("4.Delete First");
			System.out.println("5.Delete Last");
			System.out.println("6.Delete By Position");
			System.out.println("7.Display List");
			
			System.out.println("8.Exit");
			ch = sc.nextInt();
			
			switch (ch)
			{
			case 1:
					System.out.println("Enetr Element to Insert");
					int j = sc.nextInt();
					CirLL.insertFirs(j);
					break;
			case 2:
					System.out.println("Enetr Element to Insert");
					j = sc.nextInt();
					CirLL.insertLast(j);
					break;
			case 3:
					System.out.println("Enetr Element to Insert and position");
					j = sc.nextInt();
					int k = sc.nextInt();
					CirLL.insertByPos(j,k);
					break;
			case 4:
					CirLL.deleteFirst();
					break;
			case 5:
					CirLL.deleteLast();
					break;
			case 6:
					System.out.println("Enter Position to Delete");
					k = sc.nextInt();
					CirLL.deleteByPos(k);
					break;
			case 7:
					CirLL.display();
					break;
			case 8:
				 return;
			default :
				System.out.println("Enter Valid Choice");
				
			}
				
		}while(ch!=8);
		
		
//		CirLL.insertFirs(10);
//		CirLL.insertFirs(20);
//		CirLL.insertLast(50);
//		CirLL.insertLast(70);
//		CirLL.insertByPos(10, 5);
//		CirLL.insertByPos(20, 1);
//		CirLL.insertByPos(30, 6);
//		CirLL.insertByPos(70, 20);
//		CirLL.insertByPos(40, 3);
//		CirLL.display();
//		System.out.println("====================");
//		CirLL.deleteFirst();
//		CirLL.deleteLast();
//		CirLL.display();
//		CirLL.deleteByPos(1);
//		CirLL.deleteByPos(3);
//		CirLL.deleteByPos(4);
//		CirLL.display();
		
		
		
	}
	
}
