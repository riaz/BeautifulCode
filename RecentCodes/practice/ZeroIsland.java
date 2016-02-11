package practice;

public class ZeroIsland {
	static int X = 0;
	static int Y = 0;
	
	public int  getNumberOfIslands(int[][] a){
		int count=0;
		boolean[][] b = new boolean[a.length][a[0].length];
		
		while(getNext(a,b))
		{
			visitCell(a,b,X,Y,0);
			count++;
		}
		return count;
		
	}

	/**
	 * 
	 * start from init(0,0)
	 * if init[] is 1 and visited false, inc count
	 * if right of init is 1 , go else do nothing 
	 * if down of init is 1  , go else do nothing
	 * if left of init is 1  , go else do nothing 
	 * if top of init is 1   , go else do nothing
	 * visited = true 
	 * 
	 * @param a
	 */
	
	
	public int visitCell(int[][] a,boolean [][] b,int x,int y,int count){
			b[x][y] = true;
			count = count+1;
			
			//right			
			if(y+1 < a[0].length && a[x][y+1] == 1 && !b[x][y+1])
				count += visitCell(a,b,x,y+1,count);

			//down
			else if(x+1 < a.length && a[x+1][y] == 1 && !b[x+1][y])
				count += visitCell(a,b,x+1,y,count);
			
			//left
			else if(y-1 >= 0  && a[x][y-1] == 1 && !b[x][y-1])
				count += visitCell(a,b,x,y-1,count);
			
			//top
			else if(x-1 >= 0 && a[x-1][y] == 1 && !b[x-1][y])
				count += visitCell(a,b,x-1,y,count);
				
			
			return count;
	}
	
	
	public boolean getNext(int[][] a,boolean[][] b){
		boolean res = true;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(!b[i][j] && a[i][j] == 1){
					X = i;
					Y  = j;
					return res;
				}
			}
		}
		return !res;
	}
	
	//display the island
	public void display(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();	
		}
	}
	
	public static void main(String[] args){
		int a[][] = {
				{1,1,0,0,0},
				{0,1,0,0,1},
				{1,0,0,1,1},
				{0,0,0,0,0},
				{1,0,1,0,1}};
		
		ZeroIsland i = new ZeroIsland();
		System.out.println("Number of islands : " + i.getNumberOfIslands(a));
		
	}
}
