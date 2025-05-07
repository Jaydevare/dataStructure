package dataStructure;

public class CircularDoublyLinkedList
{

	private DLLNode last;
	
	public CircularDoublyLinkedList()
	{
		last = null;
	}
	
	public void inserFirst(int d)
	{
		DLLNode new_node = new DLLNode(d);
		if(last == null)
		{
			
			new_node.setNext(new_node);
			new_node.setPrev(new_node);
			last = new_node;
			return;
		}
		new_node.setNext(last.getNext());
		new_node.setPrev(last);
		last.getNext().setPrev(new_node);
		last.setNext(new_node);
	}
	
	public void display()
	{
		if(last == null)
		{
			System.out.println("List is Empty");
			return;
		}
		DLLNode iter = last;
		do
		{
			System.out.println(iter.getData()+"->");
			iter = iter.getNext();
		}while(iter.getNext()!=last.getNext());
	}
	
	public static void main(String[] args)
	{
		CircularDoublyLinkedList CDll = new CircularDoublyLinkedList();
		CDll.inserFirst(20);
		CDll.inserFirst(30);
		CDll.inserFirst(40);
		CDll.inserFirst(10);
		CDll.display();
	}

}
