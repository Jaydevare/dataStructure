package dataStructure;

public class Queue
{
	private int arr[];
	private int front, rear;
	
	public Queue()
	{
		arr = new int[10];
		front = rear = -1;
	}
	public Queue(int s)
	{
		arr = new int[s];
		front = rear = -1;
	}
	
	public boolean isEmpty()
	{
		if((front == -1)||(rear-front == 1))
			return true;
		else 
			return false;
	}
	
	public boolean isFull()
	{
		if(rear == arr.length-1)
			return true;
		else
			return false;
	}
	
	public void insert(int d)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		if(front == -1)
		{
			front = 0;
		}
		
		rear = rear+1;
		arr[rear] = d;
		return;
	}
	
	public int remove()
	{
		int d = -999;
		if(isEmpty())
		{
			System.out.println("Queue id empty");
			return d;
		}
		d = arr[front];
		front = front+1;
		return d;
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1 ;
		}
		return arr[front];
	}
	
	public void display()
	{
		if(rear == -1)
		{
			System.out.println("Queue is Empty");
		}
		for(int i =0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args)
	{
		Queue q = new Queue(5);
		
		
	}
}
