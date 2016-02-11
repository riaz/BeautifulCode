package practice;

public class SpiralMatrix {
	public static void main(String[] args){
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] mat2 = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
		//op: 1 2 3 6 9 8 7 4 5
		int row = 0;
		int col = 0;
				
		int width = mat[0].length;
		int height = mat.length;
		
		int xiter = 0;
		int yiter = width;
		int i=0;
		int count = width*height;
		
		int track = 0 ;
		
		do{
			//right
			row = xiter;
			for(i=xiter;i<width-xiter;i++){
				System.out.print(mat[row][i] + " ");
				track++;
			}
			
			if(track == count) break;
			
			//down
			col = yiter;
			for(i=row+1;i<height-xiter;i++){
				System.out.print(mat[i][col-1] + " ");
				track++;
			}
			
			//left
			row = i-1;
			
			for(i=col-2;i>=col-yiter;i--){
				System.out.print(mat[row][i] + " "); track++; }
			if(track == count) break;
			
			//up
			col = i+1;
			xiter++;
			for(i=row-1;i>=xiter;i--){
				System.out.print(mat[i][col] + " "); track++;
				}
			yiter++;
		}while(row!=xiter);
		
	}
}
