import java.util.scanner;

public class Oddevenmain{
	
	public static void main(String args[]){
		
		OddEven oe1 = new OddEven();
		Scanner ob = new Scanner(System.in);
		
		System.out.println("enter ");
		int var = ob.nextInt();
		
		boolean result = oe1.findoddeven(var);
		
		if(result==true)
			System.out.println("even");
		
		else
			System.out.println("odd");
		
	}
	
}