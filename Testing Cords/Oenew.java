import java.util.Scanner;

public class Oenew{
	public static void main(String args[]){
		
		Scanner oe = new Scanner(System.in);
		
		int even=0;
		int odd=0;
		
		for(int x=0;x<10;x++){
		
		System.out.print("\nEnter the number");
		int num = oe.nextInt();
		
		if(num%2==0){
			System.out.print("This is Even number\n");
			even = even+1;
		}

		
		else{
			System.out.print("This is Odd number\n");
			odd = odd+1;	
		}

		}
		
		System.out.println("\nEven numbers = "+even);
		System.out.println("Even numbers = "+odd);
	}
}