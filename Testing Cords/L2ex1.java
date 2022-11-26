import java.util.Scanner;
public class L2ex1{
	public  static  void main(String args[]){
		Scanner mr = new Scanner(System.in); 
		
		int miles;
		int yards;
		double km;
		
		System.out.print("Enter the miles :");
		miles = mr.nextInt();
		
		System.out.print("Enter the yards :");
		yards = mr.nextInt();
		
		km=((yards/1760.0+miles)*1.609);
		System.out.println(miles+" Miles and "+yards+" yards := "+km+" Kilometers");
	}
}