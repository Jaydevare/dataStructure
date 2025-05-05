package dataStructure;

public class DLLNode
{
	private int data;
	private DLLNode prev , next;
	
	public DLLNode()
	{
		data = 0;
		prev = next = null;
	}

	public DLLNode(int data) 
	{
		this.data = data;
		prev = next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "DLLNode [data=" + data + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
	
}
