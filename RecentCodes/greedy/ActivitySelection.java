package greedy;

public class ActivitySelection {

	public static void main(String[] args) {
		int[] start =  {1, 3, 0, 5, 8, 5};
		int[] finish = {2, 4, 6, 7, 9, 9};

		
		if(start.length != 0 || start.length != finish.length){
			
			//sorting by finish times
			for(int i=0;i<finish.length-1;i++){
				for(int j=i;j<finish.length;j++){
					if(finish[i] > finish[j]){//swap
						finish[i] = finish[i] + finish[j];
						finish[j] = finish[i] - finish[j];
						finish[i] = finish[i] - finish[j];
						
						start[i] = start[i] + start[j];
						start[j] = start[i] - start[j];
						start[i] = start[i] - start[j];					
					}
				}
			}
			
			//we will have both start and finish times swapped based on above
			//we need to run the greedy algorithm now
			
			int fin = -1;
			for(int i=0;i<finish.length;i++){
				if(start[i] > fin){
					System.out.println(i);
					fin  = finish[i];
				}
			}
			
		}
		else{
			System.out.println("Please provide with a valid activity schedule");
		}
	}

}
