package practice;

import java.util.Arrays;
import java.util.Vector;

public class TestVectors {
	public static void main(String[] args){
		Vector v = new Vector(5);
		
		for(int i=0;i<10;i++){
			v.add(i);
		}
		
		for(int i=0;i<10;i++){
			System.out.print(i+" ");			
		}
		
		//Arrays.asList works as a bridge between 
		//array and collection apis
		
		Integer[] a = {1,2,3};
		Vector<Integer> x = new Vector<Integer>(Arrays.asList(a));
		
		System.out.println(x);
		
		x.add(2);
		x.add(50);
		
		System.out.println(x);
		
		/*
		 * Insert at specific index
		 * public void add(int index, Object element)
		   public void insertElementAt(Object element, int index)
		 * */
		
		x.insertElementAt(99,2);
		x.insertElementAt(999,0);
		x.add(0,1000);
		
		System.out.println(x);
		
		
		/* Adding two vectors*/
		
		Vector v1 = new Vector(5);
		for(int i=0;i<5;i++)
			v1.add(i*5);
		
		System.out.println("v1 : " + v1);
		
		Vector v2 = new Vector(5);
		for(int i=0;i<5;i++)
			v2.add(0,i*7);
		
		System.out.println("v2 : " + v2);
		
		//Adding one vector onto another vector
		v1.addAll(v2);
		
		System.out.println(v1);
		
		//removing all the elements from the vector v1, which doesnt change the capacity
		
		v1.clear();
		System.out.println(v1);
		System.out.println("Capacity of v1 : " + v1.capacity());
		v1.ensureCapacity(12);
		System.out.println("Capacity of v1 : " + v1.capacity());
		
		Integer p[] = {1,2,7,14};
		v1.addAll(new Vector<Integer>(Arrays.asList(p)));
		
		v1.removeAll(v2); //7 and 14 get removed
		
		System.out.println(v1);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
