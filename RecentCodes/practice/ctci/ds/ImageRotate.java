package practice.ctci.ds;

/* rotate a square matrix by 90 degrees in-place */

enum DIR {LEFT,RIGHT};

public class ImageRotate {	
	
	//attempting matrix rotation ,inplace
	public void rotate(int[][] matrix,DIR dir) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	public void display2D(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j] + " ,");
			}
			System.out.println();
		}
		System.out.println("=================================");
	}
	
	public void rotateNaive(int[][] mat){
		if(mat == null || mat.length == 0)
			return;
		
		int n = mat.length; //n is square
		int res[][] = new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				res[j][n-i-1] = mat[i][j];
			}
		}
		
		display2D(res);
			
	}
	
	public static void main(String[] args){
		int[][] a = {
						{1,2,3,4},
						{4,5,6,5},
						{7,8,9,6},
						{9,1,2,5}						
					};
		
		new ImageRotate().rotateNaive(a);
		
		
		
		new ImageRotate().display2D(a);
		new ImageRotate().rotate2D(a);
		new ImageRotate().display2D(a);
		
		
		
		
	}
	
	public void rotate2D(int[][] arr){
		int n = arr.length;
		for(int i=0;i<n/2;i++){
			for(int j = 0; j< Math.ceil((double)n/2);j++){
				int temp = arr[i][j];
				arr[i][j] = arr[n-j-1][i];
				arr[n-j-1][i] = arr[n-i-1][n-j-1];
				arr[n-i-1][n-j-1] = arr[j][n-i-1];
				arr[j][n-i-1] = temp;				
			}
		}
	}
}
