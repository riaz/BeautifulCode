package reflection;

enum E{ A, B};

public class ClassDemo {

	public static void main(String[] args) {
		String s = "Reflection API";
		
		Class a = s.getClass();
		System.out.println(a.getName());
		
		byte[] x = new byte[20];
		System.out.println(x.getClass().getName());
		
		E y = E.A;
		System.out.println(y.getClass().getName());
		
		
	}

}
