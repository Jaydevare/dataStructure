package dataStructure;

public class StudNode
{
	private Student data;
	private StudNode next;
	
	public StudNode()
	{
		data = null;
		next = null;
	}
	
	public StudNode(Student s)
	{
		data = s;
		next = null;
	}
	
	public void setData(Student s)
	{
		data = s;
	}
	
	public Student getData()
	{
		return data;
	}
	public void setNext(StudNode sn)
	{
		next = sn;
	}
	public StudNode getNext()
	{
		return next;
	}
}
