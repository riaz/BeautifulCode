package threads;

public class SleepMessages {
	public static void main(String[] args) throws InterruptedException{
		String[] impInfo =
			{
					"Mares eat oats",
					"Does eat oats",
					"Little lambs eat ivy",
					"A kid will eat ivy too"
			};
		
		for(int i=0;i<impInfo.length;i++){			
			System.out.println(impInfo[i]);
			Thread.sleep(2000); //2 milliseconds
		}
		
		  
	}
}
