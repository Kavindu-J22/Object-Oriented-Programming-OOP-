import java.util.*;

public class Resmain{
	public static void main(String args[]){
		Scanner r = new Scanner(System.in);
		
		System.out.println("Enter room number : ");
		int room = r.nextInt();
		
		Resept r1 = new Resept();
		boolean anw = r1.checkroomavl(room);
		
		
		if(anw == true){
			System.out.println("This room is available ");
		}
		else{
			System.out.println("This room is not available");
		}
		
		int sum;
		sum = 0;
		if(anw == true){
			sum=800;
		}
		else{
		   sum = 0;
		}
		
		double tot = r1.genbill(sum);
		System.out.println("your bill amount is : "+tot);
		
		
	}
}