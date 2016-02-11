package practice;

public class Exponent {
	//calculates a^b
	public double getExponent(int a,int b){
		if(b == 0) return 1;
		else if(b<0) return (1/getExponent(a,(-1)*b));
		else{
			double res = getExponent(a,b/2);
			if(b%2 == 0)
				return res*res;
			else
				return res*res*a;
		}
	}
	
	public static void main(String[] args){
		System.out.println(new Exponent().getExponent(1,5));
	}
}	
