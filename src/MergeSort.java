package Algorithms;

import java.util.Arrays;


public class MergeSort{
	
 static int[] mergeSort(int[] array) {

    	int length = array.length; 
        if (length > 1) {
            int halfArray = length/2;

            int[] leftArray = Arrays.copyOfRange(array, 0, halfArray); //okay to use this method?
            int[] rightArray = Arrays.copyOfRange(array,halfArray,length);

            //CONDUCT MERGESORT ON BOTH SIDES
            mergeSort(leftArray);
            mergeSort(rightArray);

            //COMBINE: MERGE
            merge(array,leftArray,rightArray);
        }
        
        return array; 
    
 }
    

	static int[] merge(int[] array, int[] leftArray, int[] rightArray) {
		//this part combines the two sides sorted
	
        int values = leftArray.length + rightArray.length;
        
        int index,leftIndex,rightIndex;
        
        index = leftIndex = rightIndex = 0;
        while ( index < values) 
        {
            if ((leftIndex < leftArray.length) && (rightIndex<rightArray.length)) 
            {
                if (leftArray[leftIndex] < rightArray[rightIndex]) 
                {
                    array[index] = leftArray[leftIndex];
                    index++;
                    leftIndex++;
                }
                else 
                {
                    array[index] = rightArray[rightIndex];
                    index++;
                    rightIndex++;
                }
            }
            else 
            {
                if (leftIndex >= leftArray.length) 
                {
                    while (rightIndex < rightArray.length) 
                    {
                        array[index] = rightArray[rightIndex];
                        index++;
                        rightIndex++;
                    }
                }
                if (rightIndex >= rightArray.length) 
                {
                    while (leftIndex < leftArray.length) 
                    {
                        array[index] = leftArray[leftIndex];
                        leftIndex++;
                        index++;
                    }
                }
            }
       
        }
       return array; 

    

}

}