package practice;

//check if a number is power of 2 without the mod operator

public class PowerTwoTest {
	
	public boolean isPowerOfTwo(int n){
		if(n<=0)
			return false;
		
		while(n > 2){
			int t = n >> 1;
			int c = t << 1;
			
			if((n - c)!=0)
				return false;
			
			n = n >> 1;
		}		
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(new PowerTwoTest().isPowerOfTwo(2));
		System.out.println(new PowerTwoTest().isPowerOfTwo(4));
		System.out.println(new PowerTwoTest().isPowerOfTwo(19));
		
		System.out.println((2&1)==0);
		System.out.println((4&3)==0);
		System.out.println((19&18)==0);		
		
	}
}
