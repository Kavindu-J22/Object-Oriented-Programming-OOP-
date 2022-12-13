import java.util.Scanner;

public class kavya{
	public static void main(String args[]){
		Scanner kavi = new Scanner(System.in);
			System.out.println("Enter the number :");
			int val = kavi.nextInt();
			System.out.println();
			
			
			for(int x= 1;x<=val;x++){
				
				for(int y =1;y<=val;y++){
					
					System.out.print("*");
				}
				System.out.println();
			}
	}
}