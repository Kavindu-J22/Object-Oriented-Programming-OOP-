import java.util.Scanner;

public class final1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*****Rectangle Calculator*****\n");
		System.out.println("Enter length of Rectangle : ");
		double length = sc.nextDouble();
		System.out.println("Enter width of Rectangle : ");
		double width = sc.nextDouble();
		
		double ans = length * width;
		
		System.out.print("Perimeter of Rectangle is : "+ans);
		
		
	}
}