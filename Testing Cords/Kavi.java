import java.util.Scanner;
public class Kavi{
	public static void main(String args[]){
		
		Scanner fuck = new Scanner(System.in);
		
		System.out.print("Enter Frist number :");
		float p = fuck.nextFloat();
		
		System.out.print("Enter prosses do you want :");
		char q = fuck.next().charAt(0);
		
		System.out.print("Enter Secound Number :");
		float r = fuck.nextFloat();
		
		double A = 0;
		
		if(q == '+'){
			
			A = p+r;
		}
		else if(q == '-'){
			
			A = p-r;
		}
		else if(q == '*'){
			
			A = p*r;
		}
		else if(q == '/'){
			
			A =  p/r;
		}
		else{
			System.out.print("Wrong prosses..!");
		}
		
		System.out.print("Your answer is : "+A);
	}
}