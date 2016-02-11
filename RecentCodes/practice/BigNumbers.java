package practice;

class BigNumber{
	String num;
	
	BigNumber(String num){
		this.num = num;
	}
	
	public BigNumber multiply(BigNumber a){
		return new BigNumber("");
	}
	
	public BigNumber add(BigNumber a){
		char[] x = this.reverse().toString().toCharArray();
		char[] y = a.reverse().toString().toCharArray();
		
				
		int lx = x.length;
		int ly = y.length;
		boolean bx = true;
		
		int mx,mn;
		
		if(lx > ly){
			mx = lx;mn = ly;
		}else{
			mx = ly;mn = lx;
			bx = false;
		}
		
		char[] res = new char[mx+1];
		
		int carry = 0;
		int p;
		int i = 0;
		for(i = 0;i<mn;i++){
			p = ( x[i]-'0') + (y[i]-'0') + carry;
			carry = p/10; 
			res[i] = (char)((int)'0' + p%10);			
		}
		
		
		
		while(i<mx)
		{
			int num = x[i]-'0' + carry;
			
			if(bx)
				res[i] = (char)('0' + num%10);
			else
				res[i] = (char)('0' + num%10);
			
			carry = num/10;
			i++;
		}
		
		//System.out.println(new String(res));
		BigNumber k = new BigNumber(new String(res));
		System.out.println(k.reverse());
		
		System.out.println(k.reverse().toString());
		if(carry>0)
			res[i] = (char)carry;	
		
		return new BigNumber(new String(res)).reverse();
	
	}
	
	public BigNumber subtract(){
		return new BigNumber("");
	}	
	
	public BigNumber reverse(){
		char s[] = this.num.toCharArray();
		int len = num.length()-1;
		for(int i=0;i<len/2;i++)
		{
			char tmp = s[i];
			s[i] = s[len-i];
			s[len-i] = tmp;
		}		
		return new BigNumber(new String(s));		
	}
	
	public char[] toCharArray(){
		return this.num.toCharArray();
	}
	
	public String toString(){
		return this.num;
	}
}

public class BigNumbers {

	public static void main(String[] args) {
		
		BigNumber x = new BigNumber("100");
		BigNumber y = new BigNumber("11");
		
		System.out.println(x.add(y));
	}

}
