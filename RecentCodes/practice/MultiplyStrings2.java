package practice;

public class MultiplyStrings2 {

	public String multiply(String num1, String num2){
		char[] x,y;
		if(num1.length() > num2.length()){
			x =   new StringBuilder(num1).reverse().toString().toCharArray(); //larger
			y =   new StringBuilder(num2).reverse().toString().toCharArray(); //smaller		
		}
		else{
			x =   new StringBuilder(num2).reverse().toString().toCharArray(); //larger
			y =   new StringBuilder(num1).reverse().toString().toCharArray(); //smaller
	
		}
		
		int l1 = x.length,l2 = y.length;
		
		int res[][] = new int[l2+1][l1+l2+1];
		
		int carry = 0;
		int i=0;
		for(i=0;i<l2;i++){
			int num = y[i]-'0';
			int j = 0;
			for(;j<l1;j++){
				res[i][j+i] = num * (x[j]-'0') + carry;
				carry = res[i][j+i]/10; res[i][j] = res[i][j]%10;
			}
			if(carry>0)
				res[i][j] = carry;
		}
		
		//summing up
		carry = 0;
		int j=0;
		for(;j<l1+l2+1;j++){
			for(int k=0;k<l2;k++){
				res[i][j] += res[k][j];
			}
			res[i][j] += carry;
			carry = res[i][j]/10; res[i][j] = res[i][j]%10;			
		}
		
		StringBuilder out= new StringBuilder();
		
		boolean flag = true;
		for(j=l1+l2;j>=0 ;j--){
			if(res[i][j] != 0 )
				flag = false;
			if(!flag)
				out.append(res[i][j]);
		}
		
		return out.toString();
	}
	
	public static void main(String[] args) {
			System.out.println(new MultiplyStrings2().multiply("99999999999999999999999999999999999999999999999999999", "100000000000000000000000"));
	}
}
