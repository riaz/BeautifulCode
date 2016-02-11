package practice.ctci.ds;

public class ClearPath {
	
	public boolean isClearPath(int[][] a,int m,int n){
		boolean result = true;
		for(int i=0;i<a[0].length;i++){
			result = result & (a[m][i] == 0);
			if(!result) return false;
		}
		for(int i=0;i<a.length;i++){
			result = result & (a[i][n] == 0);
			if(!result) return false;
		}
		return true;
	}
	
	public boolean clear(int[][] a){
		boolean result = false;
		for(int i=0;i<a.length;i++){
			for(int j=0;j < a[0].length;j++){
				if(a[i][j] == 0)
				{
					result = result | isClearPath(a,i,j);
					if(!result)return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		int[][] a = {
				{1,0,3},
				{0,0,0},
				{7,0,9}
			};
		
		int[][] b = {
				{1,0,3},
				{4,5,6},
				{7,8,9}
			};
		
		System.out.println(new ClearPath().clear(a));
		System.out.println(new ClearPath().clear(b));
		
		
		
		
	}
}
