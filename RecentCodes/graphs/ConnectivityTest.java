package graphs;

class cGraph extends nGraph{
	cGraph(int v){
		super(v);
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);		
	}
	
	//a recursive function that uses the visited array
	//and parent to check if a graph has cycles
	
	public boolean isCyclic(int s, boolean[] visited, int parent){
		visited[s] = true;
		for(Integer i: adj[s]){
			if(!visited[i]){
				if(isCyclic(i,visited,parent))
					return true;
			}
			else if( i!= parent){
				return true;
			}
		}		
		return false;
	}
	
	public int size(){
		return V;
	}
	
}

public class ConnectivityTest {
	
	//cyclic graph test client
	public static void main(String[] args){
		cGraph g1  = new cGraph(5);
		boolean[] visited = new boolean[g1.size()];
		
		g1.addEdge(1,0);
	    g1.addEdge(0,2);
	    g1.addEdge(0,3);
	    g1.addEdge(3,4);
	    
	    int start = 0;
	    if(g1.isCyclic(0, visited, -1)){
	    	System.out.println("The graph g1 is cyclic");	    	
	    }else{
	    	System.out.println("The graph g1 is not cyclic");    	
	    	
	    }

	}	
}
