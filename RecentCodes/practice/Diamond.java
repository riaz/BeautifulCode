package practice;

public class Diamond {
	//display unit 10 diamonds as 1-2-3-4 portions
	
	public void firstQuad(int size,boolean melt,boolean yes,int level){
		int i = level;
		
		do{
			for(int j=0;j<size-i-1;j++)System.out.print(" ");
			for(int j=0;j<=i;j++)
				System.out.print("*");
			if(!melt)
				System.out.println();
			else{
				if(yes)
					System.out.println();				
			}
			i++;
		}while(!melt && i<size);		
	}
	
	public void secondQuad(int size,boolean melt,boolean yes,int level){
		int i = level;
		
		do{
			for(int j=0;j<=i;j++)
				System.out.print("*");
			if(!melt)
				System.out.println();
			else{
				if(yes)
					System.out.println();				
			}
			i++;
		}while(!melt && i<size);
		
	}
	
	public void thirdQuad(int size,boolean melt,boolean yes,int level){
		int i = level;
		
		do{
			for(int j=0;j<size-i;j++)System.out.print(" ");
			for(int j=0;j<i;j++)
				System.out.print("*");
			if(!melt)
				System.out.println();
			else{
				if(yes)
					System.out.println();				
			}
			i--;
		}while(!melt && i> 0);		
	}
	
	public void fourthQuad(int size,boolean melt,boolean yes,int level){
		int i = level;		
		do{
			for(int j=0;j<i;j++)
				System.out.print("*");
			if(!melt)
				System.out.println();
			else{
				if(yes)
					System.out.println();				
			}
			i--;
		}while(!melt && i> 0);			
	}
	
	public void diamond(int size){
		
		for(int i=0;i<size;i++){
			new Diamond().firstQuad(size,true,false,i);
			new Diamond().secondQuad(size,true,true,i);
		}
		
		for(int i=size-1;i>0;i--){
			new Diamond().thirdQuad(size,true,false,i);
			new Diamond().fourthQuad(size,true,true,i);
		}		
	}
	
	public static void main(String[] args){
		
		new Diamond().firstQuad(10,false,false,0);
		new Diamond().secondQuad(10,false,false,0);		
		new Diamond().thirdQuad(10,false,false,0);
		new Diamond().fourthQuad(10,false,false,0);
//		
		
		new Diamond().diamond(10);
		
	}
}
