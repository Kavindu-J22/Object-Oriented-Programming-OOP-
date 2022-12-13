import java.util.Scanner;

public class L2ex3{
	public static void main(String args[]){	
	Scanner vo = new Scanner(System.in);
	
		float length=0;
		float width=0;
		float height=0;
		double volume;
		
		System.out.print("Enter the length of Cube : ");
		length = vo.nextFloat();
		
		System.out.print("Enter the width of cube : ");
		width = vo.nextFloat();
		
		System.out.print("Enter the height of the cube : ");
		height = vo.nextFloat();
		
		volume = length*width*height;
		
		System.out.print("Volume of the cube = "+volume);
	}
}