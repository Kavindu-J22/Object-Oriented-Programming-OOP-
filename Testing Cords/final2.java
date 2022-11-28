import java.util.Scanner;

public class final2{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int x;
		int y[] = {0,0,0};
	
			System.out.println("****Enter three intigers****");
			
			
		for(x =0; x <3 ;x++){
			System.out.print("ente the "+(x+1)+" number : ");
			y[x] = sc.nextInt();
			}
		
		int max = y[1];
		int min = y[1];
		
		for(int z = 0; z <3; z++){	
			if(max < y[z])
				max = y[z];
			
			if(min > y[z])
				min = y[z];
		}
		
		System.out.println("\nMaximum number is : "+max);
		System.out.println("Minimum number is : "+min);
			
			
		}
	}
