import java.util.Scanner;

public class oemain{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		oebool oe = new oebool();
		
		System.out.println("Enter the number here : ");
		int num = sc.nextInt();
		
		boolean ans = oe.findoddeve(num);
		
		if(ans== true)
			System.out.println("This is even number");
		else 
			System.out.println("This is odd number");
	}
}