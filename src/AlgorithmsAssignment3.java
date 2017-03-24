package Algorithms;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.text.ChangedCharSetException;

import stdlib.*; 

public class AlgorithmsAssignment3 {
/*
Implement the algorithm for the closest pair of points (Section 33.4 in 
the textbook page 1043). Your algorithm should input the coordinates of the points in
the point-set from a text file whose format matches the test files uploaded
on D2L, and output (1) the coordinates of a closest pair in the point-set,
and (2) the distance between the two points in the closest pair.

-----PSEUDO CODE-----
1) Let YL [1...Y.length] and YR [1...Y.length] be new arrays
2) YL.length = YR.length = 0
3) for i = 1 to Y.length
4) if Y[i] in PL then
5 )YL.length = YL.length + 1
6) YL[YL.length]= Y[i]
7) else YR.length = YR.length + 1
8) YR[YR.length] = Y[i]
	
*/

public static int setUp() { //kelsey: the throws is for ReadFromConsole look into this
	

			//----------DECLARE VARIABLES------------//
			int i; 
			int j = 0; 

			String filename = "10points.txt";
			
			try {
				filename = ReadFromConsole.readFromConsole();
			} catch (IOException exception ) {
				System.err.println("Try again.improper format");
			} 
			
			StdIn.fromFile(filename);//TODO: 
			String reader = StdIn.readAll();  //ALL TEXT FROM FILE
			
		    String[] readerArray = reader.split("\n"); //ARRAY OF PAIRS, X/Y UNSEPERATED
		    
		    int numValues = readerArray.length * 2; 
		    int numPairs = readerArray.length; 
		    
		    String[] xyPairs = new String[1]; //ARRAY USED TO SPLIT X,Y VALUES AT EACH INDEX OF READER
		    String xy; //REPRESENTS EACH UNSEPERATED X,Y VALUE
		    String[] allValues = new String[numValues];//ARRAY OF ALL TEXT FROM FILE
		    int[] xValues = new int[numPairs]; //ARRAY OF ALL X VALUES ONLY
		    int[] yValues = new int[numPairs]; //ARRAY OF ALL Y VALUES ONLY
			HashMap<Integer, Integer> xToY = new HashMap<Integer, Integer>();//DICTIONARY xvalue:yvalue
			
			
			//------------DOCUMENT THE DATA FROM THE FILE GIVEN-----------//
			
			//ENTER THE INFORMATION INTO MULTIPLE USEFUL ARRAYS
				//TODO: Determine which of these are not being used and remove

			for (i = 0, j = 0; i < numValues; i = i + 2, j++){
		    	
				   	xy = readerArray[j]; //grab the xypair
				   	xyPairs = xy.split(" "); //split the pair into an array of 2 values
				  	allValues[i] = xyPairs[0]; 
				  	if (i < numValues -1 ) {allValues[i+1] = xyPairs[1]; } 
				  	
				  	xyPairs[0] = xyPairs[0].replaceAll("\\s+",""); 
				  	xyPairs[1] = xyPairs[1].replaceAll("\\s+",""); 
				   	xValues[j] = Integer.valueOf(xyPairs[0]);
				   	yValues[j] = Integer.valueOf(xyPairs[1]); 
				   	  		   		
			}
		    
			//ENTER THE INFORMATION INTO USEFUL HASHMAPS  
			
			for ( i = 0; i + 1 < numValues; i = i + 2){
				allValues[i] = allValues[i].replaceAll("\r","");
				allValues[i+1] = allValues[i+1].replaceAll("\r","");
			   	xToY.put(Integer.valueOf(allValues[i]), Integer.valueOf(allValues[i+1])); 
			}
			   	
//			   	//TEST LINES
//			   	StdOut.print(xToY.get("1574")); 
//			   	StdOut.print(xToY.get("7156"));
//			   	StdOut.print(xToY.get("511"));
//			   	StdOut.print(xToY.get("815"));
//			   	StdOut.print(xToY.get("1267"));
//			   	StdOut.print(xToY.get("666"));
//			   	StdOut.print(xToY.get("1184"));
//			   	StdOut.print(xToY.get("2560"));
//			   	StdOut.print(xToY.get("337"));
			
			
			/*---------START A NEW CLASS HERE-------------*/
			//SORT THE ARRAY OF X VALUES
				xValues = MergeSort.mergeSort(xValues);
				yValues = MergeSort.mergeSort(yValues); 
						
				int smallestLeftRight = FindClosest.findClosest(xValues, xToY); 
				int smallestRectanlge = RectangleSection.ClosestPoints(xValues, xToY, smallestLeftRight); 
				
				return smallestRectanlge; 
			

			
			
			
			
}

	public static void main(String[] args){
		//1:47 in lecture 5
		int closest = setUp(); 	
		StdOut.print(closest); 
	}
	
}

/*	

	for (int i = 1; i < Y.length; i ++ ){
		if (Y[i] == delta) { 
			YL.length = YL.length + 1; 
			YL[YL.length] = YR.length + 1; 
		}
		else{
		YR.length = YR.length + 1; 
		YR[YR.length] = Y[i]; 
		}
			
	}
		
}
	
}

//			//FIND THE MEDIAN X VALUE //TODO: DELETE, I DON'T NEED THIS
//			//TODO: put this in a seperate class like I did for MergeSort
//			int medianx = FindMedian.findMedian(xValues); 
//			int mediany = FindMedian.findMedian(yValues);
			
			
//			//PARTITION THE ARRAYS INTO LEFT AND RIGHT
//			int[] leftPlaneX = Partition.partition(xValues, medianx, -1); 
//			int[] rightPlaneX = Partition.partition(xValues, medianx, 1); 
//			int[] leftPlaneY = Partition.partition(yValues, mediany, -1); //DON'T USE THIS IT IS TOP/BOTTOM
//			int[] rightPlaneY = Partition.partition(yValues, mediany, 1); //DON'T USE THIS IT IS TOP/BOTTOM
			
				
			//TODO: I AM WORKING HERE CALLING FINDCLOSEST CLASS: 2:39AM
				
//			//-----TESTING----//
//			StdOut.print("Testing the Array List of Points on the Right side of the plane, displayed by x values"); 
//			for (i = 0; i < rightPlaneX.length; i ++){
//				StdOut.print(rightPlaneX[i] + ", "); 
//			}

*/





