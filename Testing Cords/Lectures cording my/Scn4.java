import java.util.Scanner;
//OR import java.util.*;

public class Scn4{
	
	public static void main(String args[]){
		
		Scanner ka = new Scanner(System.in);
		
		System.out.println("Enter your name : ");
		String name = ka.next();
		System.out.println("Enter your age : ");
		int age = ka.nextInt();
		System.out.println("Enter your mark : ");
		double mark = ka.nextDouble();
		
		float ans = age+10;
		
		System.out.println("Hi "+name+"..!\nAfter 10 Years become your age is "+ans+"\nNow your age "+age+"\nAnd your mark is "+mark);
		
	}
}