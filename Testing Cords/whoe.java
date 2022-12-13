import java.util.Scanner;

public class whoe{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int eve = 0;
		int odd = 0;
		int x = 0;
		int num;
		
		do{
			System.out.println("Enter number do you want : ");	
			num = sc.nextInt();
			
			if(num%2==0){
				eve +=1;
				System.out.print(num+" is Even number.\n");
				}
			else{
				odd +=1;
				System.out.print(num+" is Odd number.\n");
				}
				
				x++;
		}while(x < 10);
			
			System.out.println("Even numbers : "+eve);
			System.out.println("Odd numbers : "+odd);
		}
		
		
	}