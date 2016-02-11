package practice.ctci.ds;

public class PermuteCheck {
	
	public boolean isEmpty(int[] arr){
		for(int i=0;i<arr.length;i++)
			if(arr[i]!=0) return false;
		return true;
	}
	
	public boolean checkIsPermute(String a,String b){
		char[] c = a.toCharArray();
		int x[] = new int [26];
		
		for(int i=0;i<c.length;i++)
			x[c[i]-'a']++;
		
		c = b.toCharArray();
		
		for(int i=0;i<c.length;i++)
			x[c[i]-'a']--;
		
		return isEmpty(x);
	}
	
	public static void main(String[] args){
		System.out.println(new PermuteCheck().checkIsPermute("ab","ba"));
	}
}
