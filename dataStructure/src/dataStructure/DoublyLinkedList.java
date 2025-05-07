package dataStructure;

public class DoublyLinkedList
{
	private DLLNode head;
	
	public DoublyLinkedList()
	{
		head = null;
	}
	
	public void insertFirst(int d)
	{
		DLLNode	new_node = new DLLNode(d);
		if(head == null)
		{
			head = new_node;
			return;
		}
		new_node.setNext(head);
		head.setPrev(new_node);
		head = new_node;
		return;
	}
	
	public void insertLast(int d)
	{
		DLLNode new_node = new DLLNode(d);
		if(head == null)
		{
			head = new_node;
			return;
		}
		DLLNode iter = head;
		while(iter.getNext()!=null)
			iter = iter.getNext();
		
		new_node.setPrev(iter);
		iter.setNext(new_node);
		return;
	}
	
	public void insertByPos(int d, int pos)
	{
		DLLNode	new_node = new DLLNode(d);
		if(head == null)
		{
			head = new_node;
			return;
		}
		if(pos == 1)
		{
			new_node.setNext(head);
			head.setPrev(new_node);
			head = new_node;
			return;
		}
		DLLNode iter = head;
		
		for(int i =1; i<pos-1 && iter.getNext()!=null; i++)
			iter = iter.getNext();
		
		if(iter.getNext() == null)
		{
			new_node.setPrev(iter);
			iter.setNext(new_node);
			return;
		}
		new_node.setNext(iter.getNext());
		new_node.setPrev(iter.getNext().getPrev());
		iter.setNext(new_node);
		iter.getNext().setPrev(new_node);
		return;
	}
	
	public int deleteFirst()
	{
		int d = -999;
		if(head == null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(head.getNext()==null)
		{
			d = head.getData();
			head =null;
			return d;
		}
		d = head.getData();
		head = head.getNext();
		head.setPrev(null);
		return d;
	}
	
	public int deleteLast()
	{
		int d = -999;
		if(head == null)
		{
			System.out.println("List is Empty");
			return d;
		}
		if(head.getNext()==null)
		{
			d = head.getData();
			head =null;
			return d;
		}
		DLLNode iter = head;
		while(iter.getNext().getNext()!=null)
			iter = iter.getNext();
		d = iter.getNext().getData();
		iter.getNext().setPrev(null);
		iter.setNext(null);
		return d;
	}
	
	public int deleteByPos(int pos)
	{
		int d = -999;
		if(head == null)
		{
			System.out.println("List is Empty");
			return d;
		}
		
		if(pos == 1)
		{
			if(head.getNext()==null)
			{
				d = head.getData();
				head =null;
				return d;
			}
			d = head.getData();
			head = head.getNext();
			head.setPrev(null);
			return d;
		}
		DLLNode iter = head;
		for(int i =1; i<pos-1 && iter.getNext()!=null;i++)
			iter = iter.getNext();
		
		if(iter.getNext()== null)
		{
			d = iter.getNext().getData();
			iter.getNext().setPrev(null);
			iter.setNext(null);
			return d;
		}
		d = iter.getNext().getData();
		iter.setNext(iter.getNext().getNext());
		iter.getNext().setPrev(iter);
		return d;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("List is Empty");
		}
		DLLNode iter = head;
		while(iter!=null)
		{
			System.out.println(iter.getData()+"->");
			iter = iter.getNext();
		}
		return;
	}
	
	public static void main(String[] args)
	{
		DoublyLinkedList Dll = new DoublyLinkedList();
//		Dll.insertFirst(10);
//		Dll.insertFirst(20);
//		Dll.insertLast(25);
//		Dll.insertLast(35);
//		Dll.deleteFirst();
//		Dll.deleteFirst();
//		Dll.deleteLast();
//		Dll.deleteLast();
		Dll.insertByPos(10, 5);
		Dll.insertByPos(20, 2);
		Dll.insertByPos(30, 1);
		Dll.insertByPos(50, 4);
		Dll.insertByPos(55, 3);
		Dll.insertByPos(57, 100);
		Dll.deleteByPos(20);
//		Dll.deleteByPos(1);
		Dll.display();
	}
	
}
