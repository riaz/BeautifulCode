package graphs;

import java.util.LinkedList;

class Graph {
	int vertices;
	LinkedList<Integer>[] adj;
	
	Graph(int vertices){
		this.vertices  = vertices;
		adj = new LinkedList[vertices];
		
		for(int i=0;i<adj.length;i++){
			adj[i] = new LinkedList();					
		}
	}
	
	public void addNeighbour(int idx,int data){
		adj[idx].add(data);
	}
	
	public int getNeighbourCount(int idx){
		return adj[idx].size();
	}
	
	public LinkedList<Integer> getNeighbours(int idx){
		return adj[idx];
	}
	
}
