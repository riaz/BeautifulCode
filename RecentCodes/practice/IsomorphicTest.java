package practice;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicTest {	
	
	//this method wont work for the case: aba bba -> fails the testcase
//	public boolean isIsomorphic(String s, String t) {
//	    if(s==null || t==null)
//	        return false;
//	 
//	    if(s.length() != t.length())
//	        return false;
//	 
//	    if(s.length()==0 && t.length()==0)
//	        return true;
//	 
//	    HashSet<Character> x = new HashSet<Character>();
//	    
//	    for(int i=0;i<s.length();i++){
//	    	char p = s.charAt(i);
//	    	if(!x.contains(p))
//	    		x.add(p);
//	    }
//	    
//	    int sx = x.size(); 
//	    
//	    x = new HashSet<Character>();
//	    
//	    for(int i=0;i<t.length();i++){
//	    	char p = t.charAt(i);
//	    	if(!x.contains(p))
//	    		x.add(p);
//	    }
//	    
//	    int sy = x.size();
//	    
//	    
//	    if(sx != sy) return false;
//	    
//	    return true;
//	}
	
	public boolean isIsomorphic(String s, String t) {
	    if(s==null || t==null)
	        return false;
	 
	    if(s.length() != t.length())
	        return false;
	 
	    if(s.length()==0 && t.length()==0)
	        return true;
	 
	    HashMap<Character,Character> map = new HashMap<Character,Character>();

	    for(int i=0;i<s.length();i++){
	    	char x = s.charAt(i);
	    	char y = t.charAt(i);
	    	
	    	if(map.containsKey(x)){
	    		if(map.get(x) != y)
	    			return false;
	    	}
	    	else
	    		map.put(x, y);	    
	    }
	    	
	    return true;
	}

	 
	
	public static void main(String[] args) {
		
		System.out.println(new IsomorphicTest().isIsomorphic("abc","bcd")); //yes
		System.out.println(new IsomorphicTest().isIsomorphic("abc","def")); //yes
		System.out.println(new IsomorphicTest().isIsomorphic("abb","cdd")); //yes
		System.out.println(new IsomorphicTest().isIsomorphic("aba","bcd")); //no
		System.out.println(new IsomorphicTest().isIsomorphic("aba","bba")); //actually no, but returns true 
		

	
	}

}
