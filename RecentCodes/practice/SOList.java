package practice;

import java.util.Iterator;

public class SOList<Type> implements Iterable<Type> {

	private Type[] arrayList;
	private int currentSize;
	
	public SOList(Type[] newArray){
		this.arrayList = newArray;
		this.currentSize = newArray.length;
	}
	
	@Override
	public Iterator<Type> iterator() {
		Iterator<Type> it = new Iterator<Type>(){
			int currentItem = 0;
			
			@Override
			public boolean hasNext(){
				return currentItem <  arrayList.length &&  arrayList[currentItem] != null;  
			}
			
			@Override
			public Type next(){
				return arrayList[currentItem++];
			}
			
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}			
		};		
		return it;
	}				
	
	
	public static void main(String[] args) {
		
		Integer[] number = new Integer[]{1,2,3,4,5};		
		
		String[] languages = new String[]{
				"C",
				"C++",
				"Java",
				"Python"
		};
		
		SOList<Integer> so = new SOList<Integer>(number);
		
		
		for(Integer x : so){
			System.out.print(x + " ");
		}
		System.out.println();
		
		so = null;
		SOList<String> si = new SOList<String>(languages);
		
		for(String x : si){
			System.out.println(x);
		}
		
		
		
	}
}
