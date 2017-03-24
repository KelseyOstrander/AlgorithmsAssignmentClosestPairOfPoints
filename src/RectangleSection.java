package Algorithms;

import java.util.HashMap;

import stdlib.StdOut;

public class RectangleSection {
	
	public static int ClosestPoints(int xValues[], HashMap<Integer, Integer> map, double smallest){
	
			int medianx = FindMedian.findMedian(xValues);
			int rectangle[] = new int[8]; //TODO: kelsey: he spoke about 8 points in class but this seems like a bit of a magic number, I want to know where it came from 
			int j = 0; 
			for (int i = 0; i < rectangle.length; i++)
			{
				if ((xValues[i] - medianx) < smallest){
					rectangle[j] = xValues[i];  j++; 
				}
			}
			
			//WHAT ARE THE CLOSEST POINT IN THAT RECTANGLE
			 
			int smallestInRectangle = FindClosest.findClosest(rectangle, map); 
			return smallestInRectangle; 
			
			//ARE THE CLOSEST POINTS IN THE RECTANGLE THE CLOSEST POINTS?
			//RETURN THE SMALLEST
			//StdOut.println("The closest points are of distance" + smallest); 
			//return (int) Math.min(smallest, smallestInRectangle);
	}
}