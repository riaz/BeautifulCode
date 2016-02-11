package practice.ctci.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompress {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sting to get it in a compressed form: ");
		String s = br.readLine();
		int len = s.length();
		
		StringBuilder sb = new StringBuilder();
		char x = ' ';
		int count = 0;
		if(len>0){
			x = s.charAt(0);
			sb.append(x);			
			count++;
		}
		
		for(int i=1;i<len;i++){
			char t =  s.charAt(i);
			if(t == x)
				count++;
			else{
				sb.append(count);
				x = t;
				sb.append(x);
				count = 1;
			}
		}
		sb.append(count);
		
		if(sb.length() < len)
			System.out.println(sb);		
		else
			System.out.println(s);		
	}
}
