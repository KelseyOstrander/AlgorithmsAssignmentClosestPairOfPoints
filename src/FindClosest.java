package Algorithms;


import java.util.HashMap;

import javax.xml.ws.AsyncHandler;

import stdlib.StdOut;


public class FindClosest {
	//This function returns the closest on the left and the closest on the right
	
	static int findClosest(int xValues[], HashMap<Integer, Integer> map){ //kelsey: note I might not need the hashmap
		int numPairs = xValues.length; 
		
		//BASE CASE: use a brute force method to determine the smallest distance between points on the one side
		if (numPairs < 3) {		
			double smallest = 0;
			for (int i = 0; i < numPairs; ++i) //kelsey: iterate through the array of X VALUES that have been based in
			{
				for (int j = i+ 1; j <numPairs; ++ j)//TODO: COME BACK HERE SOMETHING PROBABLY WENT WRONG HERE
				{			
					//CALCULATE THE DISTANCE BETWEEN POINTS I AND J in XValues Array
					//IF THIS DISTANCE IS SMALLER THAN THE SMALLEST DISTANCE SO FAR, UPDATE SMALLEST VARIABLE
					//if (Distance.findDistance(xValues[i], xValues[j], map) < smallest)//note: remember in class he called this length delta
					//{
						smallest = Distance.findDistance(xValues[i], xValues[j], map);
						//IS THE SMALLEST SMALLER THAN THE SMALLEST IN THE RECTANGLE?
						return RectangleSection.ClosestPoints(xValues, map, smallest); 
					//}
					
				}
			}
			
		}  
		
		//CREATE A VERTICAL LINE
		int medianx = FindMedian.findMedian(xValues); 
		
		//CREATE AN ARRAY OF THE POiNTS ON the LEFT AND ON THE RIGHT
		//kelsey: these are the arrays of x values SORTED BY X VALUES (note that the mergeSort was done on x not y)
		int[] leftPlaneX = Partition.partition(xValues, medianx, -1);//THIS CALL WORKS 
		int[] rightPlaneX = Partition.partition(xValues, medianx, 1); //THIS CALL WORKS
		
		//GET THE COORDINATING Y VALUES
		//kelsey: these are the arrays of y values SORTED BY X VALUES
		int[] leftPlaneY = new int[leftPlaneX.length]; 
		int[] rightPlaneY = new int [rightPlaneX.length]; 
		
		
		//SINCE LEFT AND RIGHT PLANES MAY BE OF DIFFERENT LENGTHS, DO THIS SEPERATELY
		for (int i = 0; i < leftPlaneX.length; i ++)
		{
			leftPlaneY[i] = (int) map.get(leftPlaneX[i]);
		}
		
		for (int i = 0; i <rightPlaneX.length; i++)
		{
			rightPlaneY[i] = (int) map.get(rightPlaneX[i]); //5:50 am this is where I am getting an issue	
		}
		
		//CALCULATE THE CLOSEST PAIR OF POINTS ON EACH SIDE OF THE VERTICAL LINE
		//kelsey: To do this, recursively break up each side
		int closestLeft = findClosest(leftPlaneX, map);  //kelsey: note this will hit the base case and return the smallest distance
		int closestRight = findClosest(rightPlaneX, map); //kelsey: note this will hit the base case and return the smallest distance
		
		//DETERMINE WHICH POINT BETWEEN THE TWO IS CLOSER
		int smallest = Math.min(closestLeft, closestRight); 
		return smallest; 
		
	}
}
		
		//----------MIDDLE RECTANGLE SECTION--------------//
		//return Math.min(smallest, RectangleSection.ClosestPoints(xValues, map, smallest)); //TODO:DELETE
		//TODO: GO OVER THIS SECTION I DON'T KNOW IF I DID IT RIGHT
		
		//MAKE THE RECTANGLE --  I moved this to a new class instead
//		int rectangle[] = new int[8]; //TODO: kelsey: he spoke about 8 points in class but this seems like a bit of a magic number, I want to know where it came from 
//		int j = 0; 
//		for (int i = 0; i < rectangle.length; i++)
//		{
//			if ((xValues[i] - medianx) < smallest){
//				rectangle[j] = xValues[i];  j++; 
//			}
//		}
//		
//		//WHAT ARE THE CLOSEST POINT IN THAT RECTANGLE
//		int smallestInRectangle = findClosest(rectangle, map); 
//		
//		//ARE THE CLOSEST POINTS IN THE RECTANGLE THE CLOSEST POINTS?
//		//RETURN THE SMALLEST
//		return Math.min(smallest, smallestInRectangle); 	
//	}

//}
