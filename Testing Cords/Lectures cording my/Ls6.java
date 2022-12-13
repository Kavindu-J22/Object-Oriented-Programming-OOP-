import java.util.*;

public class Ls6{
	public static void main(String args[]){
		Scanner sl= new Scanner(System.in);
		
			System.out.println("Enter the number : ");
			int num = sl.nextInt();
			
			System.out.println("Enter the number : ");
			int num1 = sl.nextInt();
			
			System.out.println("Enter the number : ");
			int num2 = sl.nextInt();
			
			if(num<=num1 && num<=num2){
			System.out.println("\n The Smallest number is: "+num);
			}
			
			else if(num1<=num && num1<=num2){
			System.out.println("\n The Smallest number is: "+num1);
			}
			
			else{
			System.out.println("\n The Smallest number is: "+num2);
			}
			
			if(num>=num1 && num>=num2){
			System.out.println("\n The Largest number is: "+num);
			}
			
			else if(num1>=num && num1>=num2){
			System.out.println("\n The largest number is: "+num1);
			}
			
			else{
			System.out.println("\n The largest number is: "+num2);
			}

			
		
		
	}
}


