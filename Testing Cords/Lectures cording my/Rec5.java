import java.util.Scanner;

public class Rec5{
	public static void main(String args[]){
		Scanner rc = new Scanner(System.in);
		
		System.out.print("Enter the length of Rectangle : ");
		double len = rc.nextDouble();
		System.out.print("Enter the Width of Rectangle : ");
		double wid = rc.nextDouble();
		
		double ans = len*wid;
		
		System.out.print("Perimeter of Rectangle : "+ans);
		
		
	}
}