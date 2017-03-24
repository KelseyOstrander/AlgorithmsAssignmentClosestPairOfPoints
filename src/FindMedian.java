package Algorithms;

public class FindMedian {
	
	static int findMedian(int array[]){
		int median = 0; 
		int i; 
	
		for (i = 0; i < array.length; i++)
		{
			int middle = array.length/2; 
			if (array.length%2 == 1) {
				median = array[middle]; 
			}
			else{
				median = (array[middle-1] + array[middle])/2; 
			}
		
		}
		return median; 
}
}
