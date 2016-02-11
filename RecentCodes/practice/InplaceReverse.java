package practice;

public class InplaceReverse {
	char[] str;
	                                              //out: 
	public void reverse(char[] str){              // Worl Hello
		int len = str.length -1;
		for(int i=0;i<len/2;i++){
			char c = str[i];
			str[i] = str[len-i];
			str[len-i] = c;
		}	
		
		int idx = 0;
		while(idx<len){
			int count = 0;
			for(int i=idx;i <=len && str[i]!=' ' ;i++){
				count++;
			}
			for(int i=0;i<count/2;i++){
				char c = str[idx+i];
				str[idx+i] = str[idx+count-i-1];
				str[idx+count-i-1] = c;
			}
			idx += count+1;
		}
	}
	
	public void display(){
		reverse(str);
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]);
		}
		System.out.println();
	}
	
	InplaceReverse(){
		str = "My dog jumps over the fence".toCharArray();		
	}
	
	public static void main(String[] args) {		
		new InplaceReverse().display();		
	}
}
