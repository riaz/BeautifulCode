package practice;

import java.util.HashMap;

public class AnagramTest {
	public static void main(String[] args){
		String s = "aaabbbcc";
		String b = "ababcabc";
		//both s and b are anagrams
		
		//checking anagram using a HashMap
		
		HashMap<Character,Integer> dict = new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(dict.containsKey(c)){
				dict.put(c, dict.get(c)+1);
			}
			else{
				dict.put(c, 1);
			}
		}
		
		boolean isAnagram = true;
		
		for(int i=0;i<b.length();i++){
			char c = b.charAt(i);
			if(dict.containsKey(c)){
				dict.put(c, dict.get(c)-1);
			}
			else{
				isAnagram = false;
				break;				
			}
		}
		
		if(isAnagram){
			for(Integer x: dict.values()){
				if(x != 0){
					isAnagram = false;
					break;
				}
			}
		}
		
		if(isAnagram)
			System.out.println("The two strings are anagrams");
		else
			System.out.println("The two strings are not anagrams");		
	}
}
