package dataStructure;

public class IntNode
{
	private int data;
	private IntNode next;
	
	public  IntNode()
	{
		data = 0;
		next = null;
	}

	public IntNode(int d) 
	{
		data = d;
		next = null;
	}

	public int getData() 
	{
		return data;
	}

	public void setData(int d) 
	{
		data = d;
	}

	public IntNode getNext() 
	{
		return next;
	}

	public void setNext(IntNode n) 
	{
		next = n;
	}

	@Override
	public String toString() {
		return "IntNode [data=" + data + ", next=" + next + "]";
	}
	
	
	
	
	
}
