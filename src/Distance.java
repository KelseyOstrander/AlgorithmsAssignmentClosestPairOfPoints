package Algorithms;
import java.util.HashMap;

public class Distance {
	static double findDistance(int point1XValue, int point2XValue, HashMap<Integer, Integer> map){
		
		//GET MATCHING Y COORDINATES
		int point1YValue = (int) map.get(point1XValue);
		int point2YValue = (int) map.get(point2XValue); 
		
		//TODO: I thinkkk I am supposed to return sqrt for distance here, double check
		return Math.sqrt(
				
				(point1XValue - point2XValue) * (point1XValue - point2XValue)
				+
				(point1YValue - point2YValue) * (point1YValue - point2YValue) 
				);
				
	}

}
