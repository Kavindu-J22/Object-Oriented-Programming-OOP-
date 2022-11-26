import java.util.Scanner;

public class Pasi{
	public static void main(String[] args){
		
		Scanner ob = new Scanner(System.in);
		
		
		System.out.println("enter the number ");
		float x = ob.nextFloat();
		
		System.out.println("enter process ");
		char p = ob.next().charAt(0);
		
		System.out.println("enter the number ");
		float y = ob.nextFloat();
		
		double answer=0;
		
		if(p=='+'){
			
			answer = x+y;
		}
		else if(p=='-'){
			
			answer = x-y;
		}
		else if(p=='*'){
			
			answer = x*y;
		}
		else if(p=='/'){
			
			answer = x/y;
		}
		else{
			System.out.println("Wrong process!!! ");
		}
		
		System.out.println("answer is "+answer);
		
	}
	
} 