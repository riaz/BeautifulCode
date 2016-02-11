package practice;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	/*  private constructor to prevent any class for instantiating */
	private Singleton(){ }
	
	/*  static  instance method */
	private static Singleton getInstance(){
		return singleton;
	}
	
	protected static void demoMethod(){
		System.out.println("demoMethod of Singleton");
	}	
	
	public static void main(String[] args) {
		Singleton tmp = Singleton.getInstance();
		tmp.demoMethod();
//		Singleton.demoMethod();
	}

}
