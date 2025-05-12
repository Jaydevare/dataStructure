package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree
{
	private BTNode root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public void insert_nonrec(int d)
	{
		BTNode new_node = new BTNode(d);
		if(root == null)
		{
			root = new_node;
			return;
		}
		BTNode iter = root;
		
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
					iter = iter.getLeft();
			}
			else if(d>iter.getData())
			{
				if(iter.getRight()==null)
				{
					iter.setRight(new_node);
					return;
				}
				else
					iter = iter.getRight();
			}
			else
			{
				System.out.println("Data is duplicate");
			}
		}
	}
	
	public void insert_parent(int d)
	{
		BTNode new_node= new BTNode(d);
		if(root == null)
		{
			root = new_node;
			return;
		}
		BTNode iter = root;
		BTNode  par=  null;
		
		while(iter!=null)
		{
			par = iter;
			if(d<iter.getData())
			{
				iter = iter.getLeft();
			}
			else if(d>iter.getData())
			{
				iter = iter.getRight();
			}
			else
			{
				System.out.println("Data is duplicate");
				return;
			}
		}
		if(d<par.getData())
			par.setLeft(new_node);
		else 
			par.setRight(new_node);
		
		return;
			
	}
	
	public void inorder()
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
	
	public void postorder()
	{
		visit_postorder(root);
	}
	private void visit_postorder(BTNode root)
	{
		if(root == null)
			return;
		
		visit_postorder(root.getLeft());
		visit_postorder(root.getRight());
		System.out.print(root.getData()+" ");
	}
	
	public void insert(int d)
	{
		root = insert_rec(root, d);
	}
	private BTNode insert_rec(BTNode root,int d)
	{
		if(root == null)
		{
			BTNode new_node = new BTNode(d);
			return new_node;
		}
		if(d<root.getData())
			root.setLeft(insert_rec(root.getLeft(), d));
		else if(d>root.getData())
			root.setRight(insert_rec(root.getRight(), d));
		else
			System.out.println("Duplicate data");
		
		return root;
	}
	
	public void delete(int d)
	{
		root = del_rec(root, d);
	}
	
	public BTNode del_rec(BTNode root, int d)
	{
		BTNode succ;
		if(root == null)
		{
			System.out.println("Tree is Empty");
			return null;
		}
		
		if(d<root.getData())
			root.setLeft(del_rec(root.getLeft(), d));
		else if(d>root.getData())
			root.setRight(del_rec(root.getRight(), d));
		else
		{
			if((root.getLeft()!=null)&&(root.getRight()!=null))
			{
				succ = root.getRight();
				while(succ.getLeft()!=null)
					succ = root.getLeft();
				
				root.setData(succ.getData());
				root.setRight(del_rec(root.getRight(), succ.getData()));
			}
			else
			{
				if(root.getLeft()!=null)
					root = root.getLeft();
				else if(root.getRight()!=null)
					root = root.getRight();
				else
					root = null;
			}
		}
		return root;
	}
	
	public boolean search(int d)
	{
		return search_rec(root, d);
		
	}
	private boolean search_rec(BTNode root, int d)
	{
		if(root == null)
		{
			return false;
		}
		if(d<root.getData())
			return search_rec(root.getLeft(), d);
		else if(d>root.getData())
			return search_rec(root.getRight(), d);
		else
			return true;
	}
	
	public void display()
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
		BinarySearchTree bst = new BinarySearchTree();
//		bst.insert_nonrec(20);
//		bst.insert_nonrec(30);
//		bst.insert_nonrec(40);
//		bst.insert_nonrec(50);
//		bst.insert_nonrec(60);
//		bst.insert_parent(10);
//		bst.insert_parent(6);
//		bst.insert_parent(19);
//		bst.insert_parent(3);
//		bst.insert_parent(25);
//		bst.insert_parent(17);
		bst.insert(10);
		bst.insert(5);
		bst.insert(45);
		bst.insert(36);
		bst.insert(13);
		bst.display();
		System.out.println();
		bst.inorder();
		System.out.println();
		bst.postorder();
		System.out.println();
		bst.preorder();
		bst.delete(45);
		System.out.println();
		bst.display();
		System.out.println(bst.search(10));
		
	}
}
