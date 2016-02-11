package practice;

public class ReverseString {
	public static void main(String[] args){
		String str = "This is a sample text";
		int len = str.length();
		
		StringBuilder s = new StringBuilder(str);
		for(int i=0,j=len-1;i<len/2;i++,j--){
			char temp = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, temp);
		}
		
		System.out.println(s.toString());
	}
}
