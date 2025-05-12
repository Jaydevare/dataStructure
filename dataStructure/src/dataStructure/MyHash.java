	package dataStructure;

class record_info
{
	record_type status;
	Student ref;
}

enum record_type{EMPTY, OCCUPIED, DELETED}


public class MyHash
{
	private record_info table[];
	
	public MyHash()
	{
		table = new record_info[100];
		for(int i=0; i<100;i++)
		{	
			table[i] = new record_info();
			table[i].status = record_type.EMPTY;
		}
	}
	
	public MyHash(int d)
	{
		table = new record_info[d];
		for(int i=0; i<100;i++)
		{
			table[i] = new record_info();
			table[i].status = record_type.EMPTY;
		}
	}
	
	public int hash(int rno)
	{
		return rno%100;
	}
	
	public void insert(Student s)
	{
		int key;
		key = hash(s.getRno());
		
		if((table[key].status==record_type.EMPTY)||table[key].status == record_type.DELETED)
		{
			table[key].ref = s;
			table[key].status = record_type.OCCUPIED;
			return;
		}
		if(table[key].ref.getRno()==s.getRno())
		{
			System.out.println("Student Already Present");
			return;
		}
		for(int i=key;i<table.length;i++)
		{
			if(table[i].status == record_type.EMPTY||table[key].status == record_type.DELETED)
			{
				table[i].ref = s;
				table[i].status = record_type.OCCUPIED;
				return;
			}
		}
	}
	
	public int search(int rno)
	{
		int pos = hash(rno);
		if(table[pos].status==record_type.EMPTY)
		{
			System.out.println("Student Record Not Present");
			return -1;
		}
		if(table[pos].status == record_type.DELETED)
		{
			for(int i=0;i<table.length-1;i++)
			{
				if(table[i].ref.getRno()==rno)
				{
					return i;
				}
			}
			return -1;
		}
		if(table[pos].status == record_type.OCCUPIED)
		{
			if(table[pos].ref.getRno() == rno)
				return pos;
			for(int i=pos+1;i<table.length-1;i++)
			{
				if(table[pos].ref.getRno() == rno)
				{
					return i;
				}
			}
		
		}
		return pos;
	}
	
	public void delete(int rno)
	{
		int loc = search(rno);
		if(loc == -1)
		{
			System.out.println("Student not Present");
		}
		else
		{
			table[loc].status = record_type.DELETED;
		}
	}
	
	public void display()
	{
		for(int i =0; i<table.length;i++)
		{
			if(table[i].status == record_type.OCCUPIED)
			{
				System.out.println("OCCUPIED  RNO : "+table[i].ref.getRno()+" NAME : "+table[i].ref.getName());
			}
			else if(table[i].status == record_type.DELETED)
			{
				System.out.println("DELETED");
			}
//			else
//			{
//				System.out.println("Empty");
//			}
		}
	}
	
	public static void main(String[] args)
	{
		MyHash h = new MyHash();
		h.insert(new Student(16,"Jyotie", 99, 98, 97));
		h.insert(new Student(19,"Jyoti", 99, 98, 97));
		h.insert(new Student(25,"Jay", 96, 95, 94));
		h.insert(new Student(125,"Jay", 96, 95, 94));
		h.insert(new Student(33,"Mayur",80,20,30));
		h.insert(new Student(16,"Jyotie", 99, 98, 97));
		System.out.println(h.search(19));
		System.out.println(h.search(125));
		System.out.println(h.search(25));
		h.delete(125);
		h.search(69);
		h.display();
	}
	
}

