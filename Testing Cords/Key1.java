import java.util.Scanner;

public class Key1{
	public static void main(String args[]){
		Scanner kavi = new Scanner(System.in);
		System.out.print("Enter your name :");
		String name=kavi.next();
		System.out.print("Enter your age :");
		int age=kavi.nextInt();
		System.out.print("Enter your salary :");
		float salary = kavi.nextFloat();
		
		System.out.print("Hello "+name+" ,Your age is "+age+" and your Salary is "+salary+" now.");
		
	}
}