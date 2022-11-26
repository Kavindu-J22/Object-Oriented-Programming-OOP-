import java.util.Scanner;

public class EoMain{
	public static void main(String args[]){
		
		Evenodd ex = new Evenodd();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number : ");
		int no  = sc.nextInt();
		
		boolean Fresult = ex.FindEvenOdd(no);
		
		if(Fresult== true){
			System.out.println(no+" Is Even number");
		}
		else{
			System.out.println(no+" is Odd number");
		}
		
	}
}