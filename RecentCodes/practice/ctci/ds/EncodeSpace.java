package practice.ctci.ds;

public class EncodeSpace {
			
	public int getLast(char[] str){
		int x = str.length-1;
		while(str[x--]== ' ');
		return x+1;
	}
	
	public static void main(String[] args){
		String s = "Mr John Smith    ";
		//expected:"Mr%20John%20Smith"
		char[] str = s.toCharArray();
		
		for(int i=0;i<str.length;i++){			
			if(str[i] == ' '){				
				for(int j = new EncodeSpace().getLast(str); j > i ;j--){
					str[j+2] = str[j];					
				}
				str[i] = '%';
				str[i+1] = '2';
				str[i+2] = '0';			
			}
					
		}
		
		s = new String(str);
		System.out.println(s);
	}
}
