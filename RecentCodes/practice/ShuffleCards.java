package practice;


public class ShuffleCards {
	char[] face  = {'H','D','S','C'};
	char[] values = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
	//Program to shuffle a deck of playing cards
	
	//heart 2-3-4-...A
	//diamond 2-3-4-...A
	//spade 2-3-4-...A
	//club 2-3-4-...A
	
	public int[] shuffle(){
		int x[] = new int[52];
		boolean y[] = new boolean[52];
		int p;
		int i=0;
		while(i<52){
			p = 0 + (int)(Math.random()*52);
			if(!y[p]){	
				x[i++] = p;
				y[p] = true;
			}			
		}
		return x;		
	}
	
	public void display(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(face[a[i]/13] + " ");
		}
		System.out.println();
		for(int i=0;i<a.length;i++){			
			System.out.print(values[a[i]%13] + " ");
		}
	}
	
	public static void main(String[] args) {
		new ShuffleCards().display(new ShuffleCards().shuffle());
	}

}

