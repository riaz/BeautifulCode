package practice;

import java.util.Arrays;

public class ArrayWarmup {

	public static void main(String[] args) {
		String a = "This is a String";
		char[] str = a.toCharArray();
		
		a.charAt(10);
		
		a.length();
		
		int x  = str.length;
		
		a.substring(2);
		a.substring(2,5);
		
		//Integer to String
		int q = Integer.valueOf("123");
		System.out.println(q);
		
		//String to Integer
		String p = String.valueOf(123);
		System.out.println(p);
		
		System.out.println(Arrays.toString(str));
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		
		char[] temp = Arrays.copyOf(str, str.length*2);
		
		System.out.println(temp.length);
		System.out.println(x);
		
		System.out.println(Arrays.toString(temp));
		
		//Using System.arrayCopy
		
		String msg = "He   ";
		String dst = "   He";
		
		
		System.arraycopy(msg, 0, dst, 0, 1); //He He
		
		System.out.println(dst);
		
		
		
		
	}

}
