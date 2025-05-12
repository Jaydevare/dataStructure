package dataStructure;

import java.util.Scanner;

public class Graph 
{
	private int adj[][];
	private int n;
	private int status[];
	
	public Graph(int d)
	{
		n = d;
		adj = new int[n][n];
		status = new int[n];
		for(int i=0;i<n-1;i++)
			status[i]=0;
	}
	
	public void createGraph()
	{
		int max_edge,origin,destination;
		Scanner sc = new Scanner(System.in);
		max_edge = n*(n-1);
		
		for(int i=0;i<max_edge-1;i++)
		{
			System.out.println("Enter origin and dest(-1,-1) to exit");
			origin = sc.nextInt();
			destination = sc.nextInt();
			
			if((origin==-1)&&(destination==-1))
				break;
			
			if((origin<0)||(destination<0)||(origin>=n)||(destination>=n))
			{
				System.out.println("Invalid Edge");
				i--;
			}
			else
			{
				adj[origin][destination] = 1;
			}
		}
	}
	
	public void insertEdge(int origin, int destination)
	{
		if((origin<0)||(origin>=n))
		{
			System.out.println("vertex does not exist");
			return;
		}
		if((destination<0)||(destination>=n))
		{
			System.out.println("destination does not exist");
			return;
		}
		adj[origin][destination] = 1;
	}
	
	public void delEdge(int org, int dest)
	{
		if((org<0)||(dest<0)||(org>=n)||(dest>=n)||adj[org][dest]==0)
		{
			System.out.println("edge dont exist");
			return;
		}
		adj[org][dest] = 0;
	}
	
	public void display()
	{
		int i,j;
		System.out.print(" ");
		for(i=0; i<n; i++)
		   System.out.print("   "+i);
		System.out.println();
		for(i=0; i<n; i++)
		{
			System.out.print(i);
			for(j=0; j<n; j++)
				System.out.print("   "+adj[i][j]);
			System.out.print("\n");
		}
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
	
	
	
	public static void main(String[] args)
	{
		Graph g = new Graph(12);
//		g.createGraph();
		g.insertEdge(0, 1);
		g.insertEdge(0, 3);
		g.insertEdge(1, 2);
		g.insertEdge(1, 5);
		g.insertEdge(1, 4);
		g.insertEdge(2, 3);
		g.insertEdge(2, 5);
		g.insertEdge(3, 6);
		g.insertEdge(4, 7);
		g.insertEdge(5, 7);
		g.insertEdge(5, 6);
		g.insertEdge(5, 8);
		g.insertEdge(6, 9);
		g.insertEdge(8, 9);
		g.insertEdge(7, 8);
		g.display();
		g.DF_Traversal(8);
	}
}
