package dataStructure;

public class BTNode
{
	private int data;
	private BTNode left, right;
	
	public BTNode()
	{
		data = 0;
		left = right = null;
	}
	public BTNode(int d)
	{
		data = d;
		left = right = null;
	}
	
	public void setData(int d)
	{
		data = d;
	}
	public int getData()
	{
		return data;
	}
	public void setLeft(BTNode l)
	{
		left = l;
	}
	public BTNode getLeft()
	{
		return left;
	}
	public void setRight(BTNode r)
	{
		right = r;
	}
	public BTNode getRight()
	{
		return right;
	}
}
