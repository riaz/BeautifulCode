package practice;

public class MatrixMul {
	public static void main(String[] args){
		int[][] a  = {
						{1,2,3},
						{4,5,6},
						{7,8,9}
				 	};
		
		int[][] b  = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		 	};
		
		
		//Program to multiply a and b
		
		//displaying a and b
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[0].length;j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		
		if(a[0].length != b.length){
			System.out.println("The two matrices are incompatible for multiplication");
		}
		else{
			int[][] c  = new int[a.length][b[0].length];
			int p = a.length;
			int q  = a[0].length; //or b.length
			int r  = b[0].length;
			
			//c[p][r] + = a[p][q]*b[q][r] 
			
			for(int i=0;i<p;i++)
			{
				for(int j=0;j<r;j++){
					
					for(int k=0; k<q; k++){
						
						c[i][j] += a[i][k]*b[k][j];
						
					}
				}
			}	
			
			//Resultant matrix
			System.out.println("Resultant Matrix");
			for(int i=0;i<c.length;i++){
				for(int j=0;j<c[0].length;j++){
					System.out.printf("%3d   ", c[i][j]);
				}
				System.out.println();
			}			
		}

	}
}
