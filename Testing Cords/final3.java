import java.util.Scanner;

public class final3{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int a[] = {0,0,0,0,0,0,0,0,0,0};
		
		System.out.println("*****Wellcome to ODD & EVEN Finder*****");
		
		for(int x = 0; x<10 ; x++){
			System.out.print("Enter Number "+(x+1)+" here : ");
			a[x] = sc.nextInt();
		}
		
		int even = 0;
		int odd = 0;
		
		for(int y =0; y<10 ; y++){
			if(a[y]%2==0)
				even +=1;
			else
				odd +=1;	
		}
		
		System.out.println("Even numbers : "+even);
		System.out.println("Odd numbers : "+odd);
	}
}