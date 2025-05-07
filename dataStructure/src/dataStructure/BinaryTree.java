package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree 
{
	private BTNode root;
	
	public void setRoot(BTNode r)
	{
		root = r;
	}
	
	public BTNode getRoot()
	{
		return root;
	}
	
	public BTNode createNode(int d)
	{
		BTNode new_node = new BTNode(d);
//		root = new_node;
		return new_node;
	}
	
	public void preorder()
	{
		visit_preorder(root);
	}
	
	private void visit_preorder(BTNode root)
	{
		if(root == null)
			return;
		
		System.out.print(root.getData()+" ");
		visit_preorder(root.getLeft());
		visit_preorder(root.getRight());
	}
	
	public void inOrder()
	{
		visit_inorder(root);
	}
	
	private void visit_inorder(BTNode root)
	{
		if(root == null)
			return;
		
		visit_inorder(root.getLeft());
		System.out.print(root.getData()+" ");
		visit_inorder(root.getRight());
	}

	public void post_Order()
	{
		visit_post_order(root);
	}
	
	private void visit_post_order(BTNode root)
	{
		if (root == null)
			return;
		
		visit_post_order(root.getLeft());
		visit_post_order(root.getRight());
		System.out.print(root.getData()+" ");
	}
	
	public void insert_Levelwise(int d)
	{
		BTNode new_node =  new BTNode(d);
		if(root == null)
		{
			root = new_node;
			return;
		}
		
		BTNode iter;
		Queue<BTNode> q = new LinkedList<BTNode>();
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

	public int find_height() 
	{
		if(root == null)
			return 0;
		BTNode d = new BTNode(-999);
		BTNode iter;
		int cnt = 0;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		q.add(d);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			if(iter.getData()==-999)
			{
				cnt = cnt+1;
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
	
	public void display_Levelwise()
	{
		if(root == null)
		{
			System.out.println("Tree is Empty");
			return;
		}
		BTNode iter;
		
		Queue<BTNode> q = new LinkedList<BTNode>();
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			iter = q.remove();
			System.out.print(iter.getData()+" ");
			
			if(iter.getLeft()!=null)
				q.add(iter.getLeft());
			if(iter.getRight()!=null)
				q.add(iter.getRight());
		}
	}
	
	public static void main(String[] args) 
	{
		BinaryTree bt1 = new BinaryTree();
		BinaryTree bt2 = new BinaryTree();
//		bt.setRoot(bt.createNode(10));
//		bt.getRoot().setLeft(bt.createNode(20));
//		bt.getRoot().setRight(bt.createNode(30));
//		bt.getRoot().getLeft().setLeft(bt.createNode(40));
//		bt.getRoot().getLeft().setRight(bt.createNode(50));
//		bt.getRoot().getRight().setLeft(bt.createNode(60));
//		bt.getRoot().getRight().setRight(bt.createNode(70));
		bt1.insert_Levelwise(22);
		bt1.insert_Levelwise(16);
		bt1.insert_Levelwise(19);
		bt1.insert_Levelwise(40);
		bt1.insert_Levelwise(10);
		bt1.insert_Levelwise(2);
		bt1.insert_Levelwise(25);
		
		bt2.insert_Levelwise(22);
		bt2.insert_Levelwise(16);
		bt2.insert_Levelwise(19);
		bt2.insert_Levelwise(40);
		bt2.insert_Levelwise(10);
		bt2.insert_Levelwise(2);
		bt2.insert_Levelwise(25);
		
		bt1.display_Levelwise();
		System.out.println();
		System.out.print("Pre-order:");
		bt1.preorder();
		System.out.println();
		System.out.print("Inorder:");
		bt1.inOrder();
		System.out.println();
		System.out.print("Post-order:");
		bt1.post_Order();
		System.out.println();
		System.out.println("Height of Tree:"+bt1.find_height());
		System.out.println(isIdentical(bt1,bt2));;
	}
}
