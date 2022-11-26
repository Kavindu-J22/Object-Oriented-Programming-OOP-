import java.util.*;

public class Pemain8{
	public static void main(String args[]){
		Scanner k = new Scanner(System.in);
		
		person8 p = new person8();
			System.out.println("\n"+p.getname());
			
		person8 p1 = new person8("kavi",20);
			System.out.println("\n"+p1.getname()+"\n"+p1.getage());
			
		person8 p2 = new person8("kavinduJAYE",28,850000);
			//setter call
			p2.setname("kavindu_jayasinghe");
			
			System.out.println("\nHi Mr."+p2.getname());
			System.out.println("Then your age is "+p2.getage());
			System.out.println("Now your Salary "+p2.getsalary());
			System.out.println("After 2 years your age is "+(p2.getage()+2)+"\nAnd your Salary is "+(p2.getsalary()*2));
			
			
			
	
			
		System.out.println("\nEnter your name : ");
		String nm=k.next();
		
		System.out.println("Hi..! "+nm+" Enter your age : ");
		int ag=k.nextInt();
		
		System.out.println(nm+" Enter your Salary now : ");
		double sl=k.nextDouble();
		
		System.out.println("Enter your Company now a days working : ");
		String cm=k.next();
		
		person8 p3 = new person8(nm,ag,sl,cm);
		
		System.out.println("your name : "+p3.getname());
		System.out.println("your age : "+p3.getage());
		System.out.println("your Salary : "+p3.getsalary());
		System.out.println("your Company now a days working : "+p3.getcompany());
		
	}
}