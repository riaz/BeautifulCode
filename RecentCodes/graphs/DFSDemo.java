package graphs;

import java.util.HashSet;

//DFS involves recursion

public class DFSDemo {	
	HashSet<Integer> set = new HashSet<Integer>();
	
	public void DFS(Graph g,int root){
		set.add(root);
		System.out.println(root);		
		for(int i: g.getNeighbours(root)){
			if(!set.contains(i))
				DFS(g,i);
		}
	}
	
	public static void main(String[] args){
	Graph graph = new Graph(6);
		
		graph.addNeighbour(0, 1);
		graph.addNeighbour(0, 4);
		graph.addNeighbour(0, 5);
		
		graph.addNeighbour(1, 3);
		graph.addNeighbour(1, 4);
		
		graph.addNeighbour(2, 1);
		
		graph.addNeighbour(3, 2);
		
		new DFSDemo().DFS(graph,0);  //this function does the DFS Traversal of the graph	
	}
}
