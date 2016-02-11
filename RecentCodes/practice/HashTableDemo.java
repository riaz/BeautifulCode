package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Student{
	private int id;
	private String name;
	
	Student(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
}

public class HashTableDemo {
	public HashMap<Integer,Student> buildMap(Student[] s){
		HashMap<Integer,Student> hm = new HashMap<Integer,Student>();
		for(Student st : s){
			hm.put(st.getId(), st);
		}		
		return hm;
	}
	
	public static void main(String[] args) throws IOException{
		
		ArrayList<Student> s = new ArrayList<Student>();	
		BufferedReader br = new BufferedReader(new FileReader("src/practice/students.dat"));
		String line;
		
		while((line = br.readLine())!= null){			
			String[] str = line.trim().split(" ");
			s.add(new Student(Integer.parseInt(str[0]),str[1]));			
		}		
		
		Student st[] = new Student[s.size()];
		s.toArray(st);
		
		for(Map.Entry<Integer,Student> x: new HashTableDemo().buildMap(st).entrySet()){
			System.out.println("Id : " + x.getKey());
			System.out.println("Student : " + x.getValue().getName());
			
		}
	}
}
