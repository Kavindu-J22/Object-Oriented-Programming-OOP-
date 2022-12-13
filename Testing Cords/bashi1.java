import java.util.Scanner;

public class bashi1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int tot = 0;
		
		
		System.out.println("\n*****Wellcome to prime number finder*****\n");
		
		System.out.print("Enter the number you want : ");
		int num = sc.nextInt();
		
		if(num==2 || num == 3)
			System.out.println(num+" is Prime number");
		
		else{
			
		for(int n = 1; n<=100;n++){
			
			if(num == (6*n+1) || num == (6*n-1))
				tot +=1;		
			}	
		
		
		if(tot==1)
			System.out.println(num+" is Prime number");
		
		else
			System.out.println(num+" is not Prime number");
		
		}
		
			
	}
	
}