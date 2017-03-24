package Algorithms;

import java.awt.RenderingHints;

import stdlib.StdOut;

public class Partition {
	static int[] partition (int array[], int median, int side){
		int i = 0; 
		
		int numPointsRight = array.length/2; //for the array 337 511 666 815 819 this should be 2
		int numPointsLeft = array.length%2 + array.length/2; //for the same array above this should be 3
		
		int[] rightPlane = new int[numPointsRight]; 
		int[] leftPlane = new int[numPointsLeft]; 
		int rightPlaneIndex = 0;
		int leftPlaneIndex = 0; 
		
		//ITERATE THROUGH ARRAY TO PARTITION
		for (i = 0; i < array.length; i++){
			
			if (array[i] > median) 
			{
				
				rightPlane[rightPlaneIndex] = array[i]; 
				rightPlaneIndex++;
				 
			}
			else if (array[i] <= median)
			{
				leftPlane[leftPlaneIndex] = array[i]; 
				leftPlaneIndex++;  
			} 
			else{
				StdOut.print("Hey you missed 1");
			}
		
		}
		
		if (side > 0) {return rightPlane; }
		else{return leftPlane; }
	}

}
