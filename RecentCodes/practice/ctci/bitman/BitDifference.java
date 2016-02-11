package practice.ctci.bitman;

public class BitDifference {
	public int getBitDifference(int a,int b){
		String x = getRevBinary(a);
		String y = getRevBinary(b);
		
		int len1 = x.length();
		int len2 = y.length();
		
		int max,min;
				
		if(len1 > len2){
			max = len1;
			min = len2;
		}
		else
		{
			max = len2;
			min = len1;
		}
		
		int diff = max - min;
				
		for(int i=0;i<min;i++){
			if(x.charAt(i) != y.charAt(i))
				diff++;
		}
			return diff;
		
	}
	
	String getRevBinary(int a){
		StringBuilder s = new StringBuilder();
		while(a>1){
			s.append(a%2);
			a = a/2;
		}
		s.append(1);		
		return s.toString();
	}
	
	public static void main(String[] args) {		
		System.out.println(new BitDifference().getBitDifference(31,14));
	}

}
