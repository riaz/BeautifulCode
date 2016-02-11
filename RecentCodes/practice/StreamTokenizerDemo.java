package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class StreamTokenizerDemo {
	public static void main(String[] args) throws IOException{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		
//		while(st.nextToken() != st.TT_EOF){
//			switch(st.ttype){
//				
//			case st.TT_NUMBER:
//				System.out.println("Number" + st.nval);
//			case st.TT_WORD:
//				System.out.println("Number" + st.sval);
//			case st.TT_EOL:
//				System.out.println("End of line");
//			default:
//				System.out.println("unrecognized characters");
//				break;
//			}
//		}
		
	}
}
