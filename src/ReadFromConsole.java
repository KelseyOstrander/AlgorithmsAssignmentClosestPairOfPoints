package Algorithms;

import java.io.*;

import stdlib.*;

public class ReadFromConsole
{
	
	public static String readFromConsole() throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StdOut.print("Enter String filename you want to read: ");
        String consoleString = br.readLine();
        System.out.print("reading " + consoleString);
        try{
        	return consoleString; 
        }
        catch(Exception exception){
        	System.err.println("Try again");
		}	
        
        return null; 

}}
