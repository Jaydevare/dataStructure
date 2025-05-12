package dataStructure;

public class CircularQueue 
{
	private int arr[];
	private int front, rear;
	
	public CircularQueue()
	{
		arr = new int[10];
		front = rear = -1;
	}
	public CircularQueue(int s)
	{
		arr = new int[s];
		front = rear = -1;
	}
	
	public boolean isFull()
	{
		if((front==0)&&(rear==arr.length-1)||(front - rear ==1))
			return true;
		else
			return false;
	}
	
	public boolean isEmpty()
	{
		if(front == -1)
			return true;
		else
			return false;
	}
	
	public void insert(int d)
	{
		if(isFull())
		{
			System.out.println("Queue i Full");
		}
		if(front == -1)
		{
			front = 0;
		}
		if(rear == arr.length-1)
		{
			rear =0;
		}
		else 
		{
			rear = rear+1;
		}
		
		arr[rear] = d;
		return;
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return -1;
		}
		return arr[front];
	}
	
	public int remove()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty");
			return -1;
		}
		int d = arr[front];
		if(front == rear)
			front =  rear = -1;
		else if(front == arr.length-1)
			front = 0;
		else
			front = front +1;
		
		return d;
	}
	
	public void display()
	{
		for(int i = 0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String args[])
	{
		CircularQueue cq = new CircularQueue(5);
		cq.insert(10);
		cq.insert(20);
		cq.insert(30);
		cq.insert(40);
		cq.insert(50);
		System.out.println(cq.remove());
		cq.insert(11);
		cq.display();
		
		
	}
}

