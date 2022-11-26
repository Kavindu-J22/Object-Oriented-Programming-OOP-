//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.oi.IOException;

import java.io.*;

public class L2ex4{
	public static void main(String args[])throws IOException{	
	
	//InputStreamReader isr = new InputStreamReader(System.in);
	//BufferedReader bsr = new BufferedReader(isr);
	
	BufferedReader bisr = new BufferedReader(new InputStreamReader(System.in));
	
		double length=0;
		float width=0;
		float height=0;
		double volume;
		
		System.out.print("Enter the length of Cube : ");
		length = Double.parseDouble(bisr.readLine());
		
		System.out.print("Enter the width of cube : ");
		width = Float.parseFloat(bisr.readLine());
		
		System.out.print("Enter the height of the cube : ");
		height = Float.parseFloat(bisr.readLine());
		
		volume = length*width*height;
		
		System.out.print("Volume of the cube = "+volume);
		
	} 
}