package practice;

/*
 * Program to find the area under a rectangle
 * we provide the bottom-left and the top right corners
 * a,b,c,d -> area = Math.mode(c-a) * Math.mod(d-b);
 * also take care of the overlap condition
 */

public class RectangleArea {
	
	public int computeArea(int a,int b,int c,int d,int e, int f,int g, int h){
		//checking overlap or not 
		if(d < f || h < b)
			return (c-a) * (d-b) + (g-e) *(h-f);
		
		if(c < e || g < a)
			return (c-a) * (d-b) + (g-e) *(h-f);
		
		int left = Math.max(e, a);
		int top  = Math.min(d, h);
		int right = Math.min(c, g);
		int down = Math.max(f, b);
		
		
		return (c-a) * (d-b) + (g-e) *(h-f) - ((right-left)*( top - down));
	}
	
	//client program
	public static void main(String[] args) {
		
		RectangleArea ra = new RectangleArea();
		
		//out: 200
		System.out.println(ra.computeArea(0, 0, 10, 10, 10, 10, 20, 20));
		
		//out: 200
		System.out.println(ra.computeArea(10, 10, 20, 20, 0, 0, 10, 10));
		
		//out: 175
		System.out.println(ra.computeArea(0, 0, 10, 10, 5, 5, 15, 15));
				
		//out: 175
		System.out.println(ra.computeArea(5, 5, 15, 15, 0, 0, 10, 10));
				
		
	}

}
