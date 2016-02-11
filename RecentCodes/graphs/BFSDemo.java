package graphs;

import java.util.HashSet;
import java.util.LinkedList;

//BFS doesn't involve any recursion

public class BFSDemo {
	HashSet<Integer> set = new HashSet<Integer>();
	LinkedList<Integer> queue = new LinkedList();
	
	public void BFS(Graph g,int root){
		set.add(root);
		queue.add(root);
		
		while(!queue.isEmpty()){
			int num = queue.poll();
		
			System.out.println(num);
			
			for(int i : g.getNeighbours(num)){
				if(!set.contains(i)){
					set.add(i);
					queue.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		
		graph.addNeighbour(0, 1);
		graph.addNeighbour(0, 4);
		graph.addNeighbour(0, 5);
		
		graph.addNeighbour(1, 3);
		graph.addNeighbour(1, 4);
		
		graph.addNeighbour(2, 1);
		
		graph.addNeighbour(3, 2);
		
		new BFSDemo().BFS(graph,0);  //this function does the BFS Traversal of the graph			
	}

}
