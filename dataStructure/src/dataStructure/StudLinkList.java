package dataStructure;

public class StudLinkList
{
	private StudNode head;
	
	public StudLinkList()
	{
		head = null;
	}
	
	public void setHead(StudNode head)
	{
		this.head = head;
	}
	
	public StudNode getHead()
	{
		return head;
	}
	
	public void insertFisrt(Student s)
	{
		StudNode new_node = new StudNode(s);
		if(head==null)
		{
			head = new_node;
			return;
		}
		if(head.getData().getRno() == s.getRno())
		{
			System.out.println("Student already present");
			return;
		}
		new_node.setNext(head);
		head = new_node;
		return;
	}
	
	public void insertLast(Student s)
	{
		StudNode new_node = new StudNode(s);
		if(head==null)
		{
			head = new_node;
			return;
		}
		if(head.getNext()==null)
		{
			if(head.getData().getRno()==s.getRno())
			{
				System.out.println("Student Already Present");
				return;
			}
			head.setNext(new_node);
			return;
		}
		
		StudNode iter = head;
		if(head.getData().getRno()==s.getRno())
		{
			System.out.println("Student Already Present");
			return;
		}
		while(iter.getNext()!=null)
		{
			if(iter.getData().getRno()==s.getRno())
			{
				System.out.println("Student Already Present");
				return;
			}
			iter = iter.getNext();
		}
		iter.setNext(new_node);
		return;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		if(head.getNext()==null)
		{
			System.out.println(head.getData());
			return;
		}
		StudNode iter = head;
		while(iter!=null)
		{
			System.out.println(iter.getData()+" ");
			iter = iter.getNext();
		}
		return;
	}
	
	public Student deleteFirst()
	{
		Student d = null;
		if(head == null)
		{
			System.out.println("list is Empty");
			return null;
		}
		if(head.getNext()==null)
		{
			d = head.getData();
			head = null;
			return d;
		}
		d = head.getData();
		head = head.getNext();
		return d;
	}
	
	public Student deleteLast()
	{
		Student d = null;
		if(head == null)
		{
			System.out.println("list is Empty");
			return null;
		}
		if(head.getNext()==null)
		{
			d = head.getData();
			head = null;
			return d;
		}
		StudNode iter = head;
		while(iter.getNext().getNext()!=null)
			iter = iter.getNext();
		
		d = iter.getNext().getData();
		iter.setNext(null);
		return d;
	}
	
	public static void main(String[] args) 
	{
		StudLinkList stud = new StudLinkList();
		stud.insertFisrt(new Student(11, "Jay", 80, 80, 80));
		stud.insertFisrt(new Student(12, "Jyotie", 90, 90, 90));
		stud.insertFisrt(new Student(13, "Sumedh", 100, 100, 100));
		stud.insertFisrt(new Student(16, "Sumedh", 100, 100, 100));
		stud.insertLast(new Student(15, "Mayur", 70, 70, 70));
		stud.insertLast(new Student(14, "Sumedh", 70, 70, 70));
		System.out.println(stud.deleteFirst());
		System.out.println();
		System.out.println(stud.deleteLast());
		System.out.println();
		stud.display();
		
	}
	
}
