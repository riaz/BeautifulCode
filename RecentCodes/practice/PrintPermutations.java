package practice;

public class PrintPermutations {
		StringBuilder sb;
		
		PrintPermutations(){
			sb = new StringBuilder();
		}
		
		public void getPermutations(String str){
			for(int i=0;i<str.length();i++){
				sb.append(str.charAt(i));
				String temp = str.substring(0,i) + str.substring(i+1,str.length());
				permute(temp);
				String x = sb.substring(0,sb.length()-1);
				sb = new StringBuilder();
				sb.append(x);
			}
		}
		
		public void permute(String s){
			if(s.length() == 1){
				sb.append(s);
				System.out.println(sb);
				String x = sb.substring(0,sb.length()-1);
				sb = new StringBuilder();
				sb.append(x);
			}
			else{
				for(int i=0;i<s.length();i++){
					sb.append(s.charAt(i));
					String temp = s.substring(0,i) + s.substring(i+1,s.length());
					permute(temp);
					String x = sb.substring(0,sb.length()-1);
					sb = new StringBuilder();
					sb.append(x);
				}
			}
		}
		
		public static void main(String[] args){
			String input = "abcd";
			new PrintPermutations().getPermutations(input);
		}
		
}
