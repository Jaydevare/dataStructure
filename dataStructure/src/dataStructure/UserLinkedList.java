package dataStructure;

class SinglyLinkedList
{
	private IntNode head;

	public SinglyLinkedList() 
	{
		head = null;
	}
	
	public void insertFirst(int d)
	{
		IntNode new_node = new IntNode(d);
		if(head==null)
		{
			head = new_node;
			return;
		}
		new_node.setNext(head);
		head = new_node;
	}
	
	public void insertLast(int d)
	{
		IntNode new_node = new IntNode(d);
		
		if(head==null)
		{
			head = new_node;
			return;
		}
		
		IntNode iter = head;
		
		while(iter.getNext()!=null)
			iter = iter.getNext();
		
		iter.setNext(new_node);
		return;
	}
	
	public void insertByPosition(int d, int pos)
	{
		IntNode new_node = new IntNode(d);
		if(head==null)
		{
			head = new_node;
			return;
		}
		if(pos==1)
		{
			new_node.setNext(head);
			head = new_node;
		}
		IntNode iter = head;
		for(int i = 1;i<pos-1 && iter.getNext()!=null;i++)
			iter = iter.getNext();
		
		new_node.setNext(iter.getNext());
		iter.setNext(new_node);
		return;
	}
	
	public void insertBefore(int d, int key)
	{
		IntNode new_node = new IntNode(d);
		
		if(head==null)
		{
			head = new_node;
			return;
		}
		if(head.getData()==key)
		{
			new_node.setNext(head);
			head = new_node;
			return;
		}
		IntNode iter = head;
		
		while(iter.getNext()!=null && iter.getNext().getData()!=key)
			iter = iter.getNext();
		
		if(iter.getNext()==null)
		{
			System.out.println("Invalid Data");
			return;
		}
		new_node.setNext(iter.getNext());
		iter.setNext(new_node);
		return;
	}

	public void insertAfter(int d, int key)
	{
		IntNode new_node = new IntNode(d);
		if(head == null)
		{
			head = new_node;
			return;
		}
		IntNode iter = head;
		while(iter.getNext()!=null && iter.getData()!=key)
			iter = iter.getNext();
		
		if(iter.getNext()== null)
		{
			System.out.println("Invalid Data");
			return;
		}
		new_node.setNext(iter.getNext());
		iter.setNext(new_node);
		return;
		}
	
 	public int deleteFirst()
	{
		int d = -999;
		if(head==null)
		{
			System.out.println("List is Empty");
			return d;
		}
		
		d = head.getData();
		head = head.getNext();
		return d;
	}
	
	public int deleteLast()

	{
		int d = -999;
		if(head==null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(head.getNext()==null)
		{
			d = head.getData();
			head = null;
			return d;
		}
		IntNode iter = head;
		while(iter.getNext().getNext()!=null)
			iter = iter.getNext();
		
		d = iter.getData();
		iter.setNext(null);
		return d;
	}

	public int deleteByPosition(int pos)
	{
		int d = -999;
		if(head==null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(head.getNext()==null)
		{
			d = head.getData();
			head = null;
			return d;
		}
		if(pos==1)
		{
			d = head.getData();
			head = head.getNext();
			return d;
		}
		
		IntNode iter = head;
		
		for(int i =1; i<pos-1 && iter.getNext()!=null;i++)
			iter = iter.getNext();
		
		if(iter.getNext()!=null)
		{
			d = iter.getNext().getData();
			iter.setNext(iter.getNext().getNext());
		}
		return d;
	}

	public void display()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
	
		IntNode iter = head;
		
		while(iter!=null)
		{
			System.out.println(iter.getData()+"->");
			iter = iter.getNext();
		}
			
	}
	
	public void count()
	{
		int cnt=0;
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
	
		IntNode iter = head;
		
		while(iter!=null)
		{
			cnt++;
			iter = iter.getNext();
		}
		System.out.println(cnt);
			
	}

}

public class UserLinkedList{
	public static void main(String[] args)
	{
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertFirst(10);
		sll.insertLast(99);
		sll.insertByPosition(20, 2);
		sll.insertBefore(15, 20);
		sll.insertAfter(30, 10);
		sll.insertBefore(16, 30);
		sll.display();
		sll.count();
		sll.deleteFirst();
		sll.deleteLast();
		sll.deleteByPosition(4);
		sll.display();
		sll.count();
	}
}