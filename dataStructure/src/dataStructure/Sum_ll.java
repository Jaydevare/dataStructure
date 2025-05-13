package dataStructure;

public class Sum_ll
{
	private IntNode head;
	
	public Sum_ll()
	{
		head = null;
	}

	public IntNode getHead() {
		return head;
	}

	public void setHead(IntNode head) {
		this.head = head;
	}
	
	public void insertFirst(int d)
	{
		IntNode new_node = new IntNode(d);
		new_node.setNext(head);
		head = new_node;
	}
	
	public void insertLast(int d)
	{
		IntNode new_node = new IntNode(d);
		if(head == null)
		{
			head = new_node;
			return;
		}
		IntNode iter = head;
		while(iter.getNext()!=null)
			iter = iter.getNext();
		
		iter.setNext(new_node);
		return;
	}
	
	public static void sum(Sum_ll Ll1,Sum_ll Ll2,Sum_ll res)
	{
		int num1=0;
		int num2=0; 
		int num3=0; 
		int a;
		
		IntNode iter1 = Ll1.getHead();
		IntNode iter2 = Ll2.getHead();
		IntNode iter3 = res.getHead();
		
		while(iter1!=null)
		{
			num1 =(num1*10)+iter1.getData();
			iter1 = iter1.getNext();
		}
		
		while(iter2!=null)
		{
			num2 =(num2*10)+iter2.getData();
			iter2 = iter2.getNext();
		}
		
		num3 = num1+num2;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		while(num3!=0)
		{
			a = num3%10;
			res.insertFirst(a);
			num3 = num3/10;
		}
	}
	
	public void even_odd(Sum_ll Ll2)
	{
		Sum_ll even = new Sum_ll();
		Sum_ll odd = new Sum_ll();
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		IntNode iter1 = Ll2.getHead();
		while(iter1!=null)
		{
			if(iter1.getData()%2==0)
			{
				int x = iter1.getData();
				even.insertLast(x);
			}
			if(iter1.getData()%2!=0)
			{
				int x = iter1.getData();
				odd.insertLast(x);
			}
			iter1 = iter1.getNext();
		}
		IntNode iter3 = even.getHead();
		while(iter3!=null)
		{
			System.out.print(iter3.getData()+" ");
			iter3 = iter3.getNext();
		}
		System.out.println("");
		IntNode iter4 = odd.getHead();
		while(iter4!=null)
		{
			System.out.print(iter4.getData()+" ");
			iter4 = iter4.getNext();
		}
		
		Sum_ll res = new Sum_ll();
		
		IntNode iter5 = even.getHead();
		while(iter5!=null)
		{
			res.insertLast(iter5.getData());
			iter5 = iter5.getNext();
		}
		IntNode iter6 = odd.getHead();
		while(iter6!=null)
		{
			res.insertLast(iter6.getData());
			iter6 = iter6.getNext();
		}
		
		IntNode iter7 = res.getHead();
		while(iter7!=null)
		{
			System.out.println(iter7.getData());
			iter7 = iter7.getNext();
		}

		
	
	}
	
//	public void alternate(Sum_ll Ll2, Sum_ll res)
//	{
//		if(Ll2.getHead() == null)
//		{
//			System.out.println("List is Empty");
//			return;
//		}
//		
//		IntNode iter1 = Ll2.getHead();
//		IntNode iter2 = Ll2.getHead();
//		
//		while(iter1!=null && iter1.getData()%2!=0)
//		{
//			iter1 = iter1.getNext();
//		}
//		while(iter2!=null && iter2.getData()%2==0)
//		{
//			iter2 = iter2.getNext();
//		}
//		
//		while(iter1!=null||iter2!=null)
//		{
//			if(iter1!=null)
//			{
//				System.out.println(iter1.getData()+" ");
//				res.insertLast(iter1.getData());
//				while(iter1!=null && iter1.getData()%2!=0);
//					iter1 = iter1.getNext();
//			}
//			if(iter2!=null)
//			{
//				System.out.println(iter2.getData()+" ");
//				res.insertLast(iter2.getData());
//				while(iter2!=null && iter2.getData()%2==0);
//					iter2 = iter2.getNext();
//			}
//		}
//	}
	
	public Sum_ll concat(Sum_ll Ll2)
	{
		Sum_ll res = new Sum_ll();
		
		IntNode iter1 = head;
		while(iter1!=null)
		{
			res.insertLast(iter1.getData());
			iter1 =  iter1.getNext(); 
		}
		IntNode iter2 = Ll2.getHead();
		while(iter2!=null)
		{
			res.insertLast(iter2.getData());
			iter2 =  iter2.getNext(); 
		}
		return res;
	}
	
	public void alternate(Sum_ll Ll2, Sum_ll res) {
	    if (Ll2.getHead() == null) {
	        System.out.println("List is Empty");
	        return;
	    }

	    IntNode even = Ll2.getHead();
	    IntNode odd = Ll2.getHead();

	    // Move even pointer to first even number
	    while (even != null && even.getData() % 2 != 0) {
	        even = even.getNext();
	    }

	    // Move odd pointer to first odd number
	    while (odd != null && odd.getData() % 2 == 0) {
	        odd = odd.getNext();
	    }

	    // Alternate insertion
	    while (even != null || odd != null) {
	        if (even != null) {
	            System.out.print(even.getData() + " ");
	            res.insertLast(even.getData());
	            even = even.getNext();
	            while (even != null && even.getData() % 2 != 0) {
	                even = even.getNext();
	            }
	        }

	        if (odd != null) {
	            System.out.print(odd.getData() + " ");
	            res.insertLast(odd.getData());
	            odd = odd.getNext();
	            while (odd != null && odd.getData() % 2 == 0) {
	                odd = odd.getNext();
	            }
	        }
	    }
	}
	
	public void display()
	{
		if(head==null)
		{
			System.out.println("List is Empty");
			return;
		}
	
		IntNode iter = head;
		
		while(iter!=null)
		{
			System.out.println(iter.getData()+"->");
			iter = iter.getNext();
		}
			
	}
	
	public void sum_of_nodes()
	{
		int sum =0;
		if(head == null)
		{
			System.out.println("list is empty");
			return;
		}
		
		IntNode iter = head;
		while(iter!=null)
		{
			sum = sum +(iter.getData());
			iter = iter.getNext();
		}
		
		System.out.println(sum);
	}
	
	public void deleteMiddle() {
	    if (head == null || head.next == null) {
	        head = null;
	        return;
	    }

	    // Step 1: Count the total nodes
	    int count = 0;
	    IntNode temp = head;
	    while (temp != null) {
	        count++;
	        temp = temp.getNext();
	    }

	    int mid = count / 2;

	    // Step 2: Traverse to the node before middle
	    IntNode prev = head;
	    for (int i = 1; i < mid; i++) {
	        prev = prev.getNext();
	    }

	    // Step 3: Delete middle node
	    prev.setNext(prev.getNext().getNext());
	}

	
	public static void main(String[] args)
	{
		Sum_ll Ll1 = new Sum_ll();
		Sum_ll Ll2 = new Sum_ll();
		Sum_ll res = new Sum_ll();
		
		Ll1.insertLast(1);
		Ll1.insertLast(5);
		Ll1.insertLast(6);
		Ll1.insertLast(7);
		Ll1.insertLast(8);
		
		Ll1.insertLast(2);
		Ll1.insertLast(5);
		Ll1.insertLast(6);
		Ll1.insertLast(9);
		Ll1.insertLast(4);
//		Ll2.insertLast(7);
//		Ll2.insertLast(3);
//		Ll2.insertLast(3);
//		Ll2.insertLast(1);
//		Ll2.insertLast(8);
		
//		sum(Ll1, Ll2, res);
//		IntNode iter = res.getHead();
//		while(iter!=null)
//		{
//			System.out.print(iter.getData()+"->");
//			iter = iter.getNext();
//		}
		
//		Ll2.even_odd(Ll2);
//		Ll2.alternate(Ll2, res);
//		IntNode Luffy = Ll2.getHead();
//		while(Luffy!=null)
//		{
//			System.out.println(Luffy.getData());
//		}
		
//		Sum_ll res1 = Ll1.concat(Ll2);
//		res1.display();
		
		Ll1.sum_of_nodes();
		
	}
}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListSplit {
    Node head;

    // Function to split the list
    public void splitList() {
        if (head == null || head.next == null) {
            System.out.println("Cannot split. List too small.");
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // First half: head to prev
        // Second half: slow to end
        prev.next = null;

        System.out.println("First half:");
        printList(head);

        System.out.println("Second half:");
        printList(slow);
    }

    // Helper to add node
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    // Helper to print list
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListSplit list = new LinkedListSplit();
        for (int i = 1; i <= 7; i++) list.add(i);
        list.splitList();
    }
}


