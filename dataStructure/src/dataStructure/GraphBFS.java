package dataStructure;

import java.util.Scanner;

public class GraphBFS
{
	private int adj[][];
	private int n;
	
	public GraphBFS(int d)
	{
		n = d;
		adj = new int[n][n];
	}
	
	public void createGraph()
	{
		int max_edges,origin,destination;
		Scanner sc = new Scanner(System.in);
		max_edges = n*(n-1);
		
		for(int i=0;i<=max_edges;i++)
		{
			System.out.println("Enter origin and destination(-1,-1)");
			origin = sc.nextInt();
			destination = sc.nextInt();
			if((origin == -1) && (destination == -1))
				break;
			if((origin<0)||(destination<0)||(origin>=n)||(destination>=n))
			{
				System.out.println("invalid edges please enter again");
				i--;
			}
			else
				adj[origin][destination] = 1;
		}
	}
	
	public void inserEdges(int origin,int destination)
	{
		if((origin<0)||(origin>=n))
		{
			System.out.println("origin vertex does not exist");
			return;
		}
		if((destination<0)||(destination>=n))
		{
			System.out.println("Destination vertex does not exist");
			return;
		}
		adj[origin][destination] = 1;
	}
	
	public void delEdge(int origin,int destination)
	{
		if((origin<0)||(destination<0)||(origin>=n)||(destination>=n)||(adj[origin][destination] == 0))
		{
			System.out.println("Edge does not exist");
			return;
		}
		adj[origin][destination] = 0;
	}
	
	public void display()
	{
		System.out.print(" ");
		for(int i =0 ;i<n;i++)	
			System.out.print("  "+i);
		System.out.println();
		for(int i =0;i<n;i++)
		{
			System.out.println(i);
			for(int j =0;j<n;j++)
				System.out.print(" "+ adj[i][j]);
			System.out.print("\n");
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
	
	public static void main(String[] args) 
	{
		GraphBFS gbf = new GraphBFS(12);
		gbf.inserEdges(0, 1);
		gbf.inserEdges(0, 3);
		gbf.inserEdges(0, 4);
		gbf.inserEdges(1, 2);
		gbf.inserEdges(2, 4);
		gbf.inserEdges(3, 4);
		gbf.inserEdges(3, 6);
		gbf.inserEdges(4, 5);
		gbf.inserEdges(4, 7);
		gbf.inserEdges(6, 4);
		gbf.inserEdges(6, 7);
		gbf.inserEdges(7, 5);
		gbf.inserEdges(7, 8);
		gbf.BF_Traversal(1);
		
	}
}
