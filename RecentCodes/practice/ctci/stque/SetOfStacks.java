package practice.ctci.stque;

public class SetOfStacks {
	int bins;
	int cap;
	int top;
	int start;
	
	Stack[] rack;
	
	SetOfStacks(int bins,int cap)
	{
		this.bins = bins;
		this.cap = cap;
		this.start = 0;
		rack = new Stack[bins];
	}
	
	
	public static void main(String[] args) {
		

	}

}
