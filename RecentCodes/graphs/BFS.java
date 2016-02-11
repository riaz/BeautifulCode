package graphs;

import java.util.LinkedList;

class nGraph{
	protected int V;
	protected LinkedList<Integer> adj[];
	
	nGraph(int v){
		V = v;
		adj = new LinkedList[v];
		
		/*initializing the adjacency lists*/
		
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v,int w){
		adj[v].add(w);
	}
	
	//print the breath first traversal from a given source
	void BFS(int s){
		boolean[] visited = new boolean[V];
		
		//for BFS we use a queue,as the queue becomes empty 
		//BFS stops
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(Integer i: adj[s])
			queue.add(i);
		
		visited[s] = true;
		
		System.out.println(s);
				
		while(!queue.isEmpty()){
			Integer currVtx = queue.poll();
			System.out.println(currVtx);			
				visited[currVtx] = true;
				for(Integer i: adj[currVtx]){
					if(!visited[i])
						queue.add(i);
				}
		}		
	}
	
}

public class BFS {
	public static void main(String[] args){
		int vertices = 4;
		nGraph g = new nGraph(vertices);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		//set the vertex to start the BFS
		int start = 2;
		
		//displaying the BFS traversal , starting from start
		g.BFS(start);		
	}
}
