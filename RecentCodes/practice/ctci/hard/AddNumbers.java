package practice.ctci.hard;

//program to add two numbers without using '+'

public class AddNumbers {
	
	public int addNumbers(int n1,int n2){		
		if(n2==0) return n1;
		
		int p = n1 ^ n2; //sum without carry
		int q = (n1 & n2) << 1;        //carry
	
		
		return addNumbers(p,q);		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new AddNumbers().addNumbers(2,9));

	}

}
