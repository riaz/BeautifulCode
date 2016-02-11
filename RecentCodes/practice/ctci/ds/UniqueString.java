package practice.ctci.ds;

/* Without using any data structures , checking that the string has all unique digits*/
public class UniqueString {
	public static void main(String[] args){
		String s = "abcda";
		boolean uniq = true;
		for(int i = 0;i<s.length()-1;i++){
			for(int j=i+1;j<s.length();j++){
				if((s.charAt(i) ^ s.charAt(j)) == 0){
					uniq = false;
				}
			}
		}
		System.out.println(uniq);
	}
}
