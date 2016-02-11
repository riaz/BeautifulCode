package practice;

import java.util.HashMap;

class TrieNode{
	char c;
	HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
	boolean isLeaf;
	
	TrieNode(char c){
		this.c = c;
	}
	
	TrieNode(){		
	}
}

public class Trie {
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	//this method add new words into the vocabulary
	public void insert(String word){
		HashMap<Character,TrieNode> children
		= root.children;		
		//if none of the children contains the char
		//we create a new TrieNode, incrementally 
		//starting from the prefix
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			TrieNode t;
			if(children.containsKey(c)){
				t = children.get(c);
			}else{
				t = new TrieNode(c);
				children.put(c, t);
			}			
			children = t.children;
			
			if(i == word.length()-1)
				t.isLeaf = true;
		}		
	}
	
	public boolean search(String word){
		TrieNode t = searchNode(word);
		
		if(t!= null && t.isLeaf)
			return true;
		else
			return false;
	}
	
	public boolean startsWith(String prefix){
		TrieNode t = searchNode(prefix);
		if(t != null) return true;
		else return false;
	}
	
	public TrieNode searchNode(String str){
		//return a TrieNode
		//we can use the leaf flag check
		//for word search
		
		//and just not null condition for startsWidth
		HashMap<Character,TrieNode> children = root.children;
		TrieNode t =null;
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			
			if(children.containsKey(c)){
				t = children.get(c);
				children = t.children;
			}
			else
				return null;
		}		
		return t;		
	}
	
	public static void main(String[] args){
		Trie trie = new Trie();
		
		trie.insert("to");
		trie.insert("tea");
		trie.insert("ted");
		trie.insert("ten");
		trie.insert("A");
		trie.insert("inn");
		
		//Prefix search
		System.out.println(trie.startsWith("te")); //true
		System.out.println(trie.startsWith("in")); //true
		System.out.println(trie.startsWith("mea")); //false
		System.out.println(trie.startsWith("ind")); //false
		System.out.println(trie.startsWith("t")); //true
						
	}

}
