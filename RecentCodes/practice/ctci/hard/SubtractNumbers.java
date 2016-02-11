package practice.ctci.hard;

public class SubtractNumbers {

	//subtract two numbers without using arithmetic operations
	
	public int minusNumber(int n1, int n2){
		if(n2 == 0) return n1;
		int borrow = (~n1)&n2;
		n1 = n1^n2;
		n2 = borrow << 1;
		
		System.out.println(n1);
		System.out.println(n2);
		
		return minusNumber(n1,n2);
	}
	
	public static void main(String[] args) {
		System.out.println(new SubtractNumbers().minusNumber(9, 2));
	}

}
