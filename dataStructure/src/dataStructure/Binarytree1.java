package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Binarytree1 
{
	private Btnode1 root;

	public Binarytree1(Btnode1 root) 
	{
		this.root = root;
	}

	public Btnode1 getRoot() {
		return root;
	}

	public void setRoot(Btnode1 root) {
		this.root = root;
	}
	
	public void insert(int d)
	{
		Btnode1 new_node = new Btnode1(d);
		if(root == null)
		{
			root = new_node;
			return;
		}
		
		Btnode1 iter;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getLeft()==null)
			{
				iter.setLeft(new_node);
				return;
			}
			else
				q.add(iter.getLeft());
			if(iter.getRight()==null)
			{
				iter.setRight(new_node);
				return;
			}
			else
				q.add(iter.getRight());
		}
		
	}
	
	public void insertBST(int d)
	{
		Btnode1 new_node = new Btnode1(d);
		if(root == null)
		{
			root = new_node;
			return;
		}
		Btnode1 iter = root;
		while(true)
		{
			if(d<iter.getData())
			{
				if(iter.getLeft()==null)
				{
					iter.setLeft(new_node);
					return;
				}
				else
					iter.getLeft();
			}
			else if(d>iter.getData())
			{
				if(iter.getRight()==null)
				{
					iter.setLeft(new_node);
					return;
				}
				else
					iter.getRight();
			}
			else
				System.out.println("Data is duplictae");
		}
	}
	
	public int fin_ht()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -11;
		}
		Btnode1 d = new Btnode1(-999);
		Btnode1 iter;
		int cnt = 0;
		
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		q.add(d);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getData()==-999)
			{
				cnt++;
				q.add(d);
				iter = q.remove();
			}
			
			if(iter.getLeft()!=null)
				q.add(iter.getLeft());
			if(iter.getRight()!=null)
				q.add(iter.getRight());
		}
		return cnt;
	}
	
	public int rec_height(Btnode1 root)
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -1;
		}
		
		int leftht = rec_height(root.getLeft());
		int rightht = rec_height(root.getRight());
		
		if(leftht>rightht)
			return leftht+1;
		else 
			return rightht+1;
	}
	
	public int sumAllNode()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -1;
		}
		
		int sum = 0;
		Btnode1 iter;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			
			sum = sum + iter.getData();
			if(iter.getLeft()!=null)
				q.add(iter.getLeft());
			if(iter.getRight()!=null)
				q.add(iter.getRight());
		}
		
		return sum;
	}
	
	public int allNonLeaf()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -1;
		}
		
		int sum = 0;
		Btnode1 iter;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getLeft()!=null && iter.getRight()!=null)
				sum = sum+iter.getData();
			
			if(iter.getLeft()!=null);
				q.add(iter.getLeft());
			if(iter.getRight()!=null);
				q.add(iter.getRight());
		}
		return sum;
	}
	
	
	
	
	public int allLeaf()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -1;
		}
		
		int sum = 0;
		Btnode1 iter;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getLeft()==null && iter.getRight()==null)
				sum = sum+iter.getData();
			
			if(iter.getLeft()!=null);
				q.add(iter.getLeft());
			if(iter.getRight()!=null);
				q.add(iter.getRight());
		}
		return sum;
	}
	
	
	public int min_node()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -1;
		}
		
		int min = root.getData();
		Btnode1 iter;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getData()<min)
				min = iter.getData();
			
			if(iter.getLeft()!=null);
				q.add(iter.getLeft());
			if(iter.getRight()!=null);
				q.add(iter.getRight());
		}
		return min;
	}
	
	public int max_node()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
			return -1;
		}
		
		int max = root.getData();
		Btnode1 iter;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getData()>max)
				max = iter.getData();
			
			if(iter.getLeft()!=null);
				q.add(iter.getLeft());
			if(iter.getRight()!=null);
				q.add(iter.getRight());
		}
		return max;
	}
	
	public void DF_Traversal(int v)
	{
		IntStack st = new IntStack(50);
		int i;
		st.push(v);
		while(!st.isEmpty())
		{
			v = st.pop();
			if(status[v]==0)
			{
				System.out.print("  "+v);
				status[v]=1;
			}
			for(i=n-1; i>=0; i--)
			{
				if(adj[v][i]==1 && status[i]==0)
					st.push(i);
			}
		}
	 }
	
	public void BF_Traversal(int v)
	{
		Scanner sc = new Scanner(System.in);
		int state[];
		state = new int[n];
		for(int i = 0; i<n;i++)
			state[i]=1;
		Queue q = new Queue(12);
		q.insert(v);
		state[v] = 2;
		
		while(!q.isEmpty())
		{
			v = q.remove( );
			System.out.print("  "+v);
			state[v] = 3;
			
			for(int i=0; i<n; i++)
			{
				
				if(adj[v][i] == 1 && state[i] == 1) 
				{
					q.insert(i);
					state[i] = 2;
				}
			}
		}
	}
	
	public int binarySearch(int arr[],int key)
	{
		int low = 0;
		int high = arr.length-1;
		int mid = (low+high)/2;
		
		while(arr[mid] !=key && low<high)
		{
			if(key<arr[mid])
				high = mid -1;
			else
				low = mid+1;
			
			mid = (low+high)/2;
		}
		if(arr[mid]==key)
			return mid;
		else
			return -1;
	}
	
	public static boolean isIdentical(BinaryTree b1,BinaryTree b2)
	{
		BTNode iter1, iter2;
		if((b1.getRoot()== null)||(b2.getRoot()== null))
			return false;
		
		Queue<BTNode> q1 = new LinkedList<BTNode>();
		Queue<BTNode> q2 = new LinkedList<BTNode>();
		
		q1.add(b1.getRoot());
		q2.add(b2.getRoot());
		
		while(!q1.isEmpty()||!q2.isEmpty())
		{
			iter1 = q1.remove();
			iter2 = q2.remove();
			
			if(iter1.getData()!=iter2.getData())
				return false;
			
			if(iter1.getLeft()!=null)
				q1.add(iter1.getLeft());
			if(iter1.getRight()!=null)
				q1.add(iter1.getRight());
			if(iter2.getLeft()!=null)
				q2.add(iter2.getLeft());
			if(iter2.getRight()!=null)
				q2.add(iter2.getRight());
		}
		
		if(q1.isEmpty() && q2.isEmpty())
			return true;
		else
			return false;
	}
	
	public void mir_img()
	{
		if(root == null)
		{
			System.out.println("tree is empty");
		}
		
		Btnode1 iter;
		Btnode1 temp;
		Queue<Btnode1> q = new LinkedList<Btnode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			
			temp = iter.getLeft();
			iter.setLeft(iter.getRight());
			iter.setRight(iter.getLeft());
			
			if(iter.getLeft()!=null)
				q.add(iter.getLeft());
			if(iter.getRight()!=null)
				q.add(iter.getRight());
		}
	}
	
	public void mir_rec(Btnode1 root)
	{
		Btnode1 temp;
		if(root == null)
		{
			System.out.println("tree is empty");
		}
		
		temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(root.getLeft());
		
		mir_rec(root.getLeft());
		mir_rec(root.getRight());
	}
	
	public boolean areIdentical(node root1, node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.data == root2.data) &&
               areIdentical(root1.left, root2.left) &&
               areIdentical(root1.right, root2.right);
    }

    // Function to check if second BST is a subtree of first BST
    public boolean isSubtree(node mainTree, node subTree) {
        if (subTree == null) return true;  // Empty subtree is always a subtree
        if (mainTree == null) return false; // If main tree is empty, it can't contain subtree

        if (areIdentical(mainTree, subTree)) return true;

        return isSubtree(mainTree.left, subTree) || isSubtree(mainTree.right, subTree);
    }
}
