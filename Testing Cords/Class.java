import java.util.Scanner;

public class Class{
	public static void main(String args[]){
		Scanner db = new Scanner(System.in);
		
		
		for(int y=0;y<10;y++){
			System.out.println();
			System.out.print("Do you want to use this program(Yes/no) : ");
			String yn = db.nextLine();
			
			if(yn.equals("no")){
				System.out.println();
				System.out.println("Ok,bye..");
				System.exit(0);
			}
			else {
				System.out.println();
				System.out.println("WELLCOME...!");
			}
			
			for(int x=1;x<=15;x++){
				System.out.print("Enter your name : ");
				String nm =db.nextLine();
				System.out.println("Hello.."+nm+" This is your time..");
				System.out.println();
				System.out.println("number of times using this program : ("+x+")");
				System.out.println("The number of times left to use this : ("+(15-x)+")");
				System.out.println();
				System.out.println("****Multiplication table List****");
				System.out.println();
				
				int k=2;
				
				do{
					System.out.println("Multiplication table : "+k);
					
					k++;	
				}while(k<=10);
				
					System.out.println("(*)Or any......");
				 		
				for(int z=1;z<=1;z++){
					System.out.println();
					System.out.println("(System) Validation Step : "+z);
					System.out.print("Enter multiplication table do you want :- ");
					int mu = db.nextInt();
					System.out.println();			
					System.out.println("This is number "+mu+" Multiplication table");
								
							for(int p=1;p<=12;p++){
								int outp = mu*p;
								System.out.println(mu + " * " +p+ " = " +outp);
									
							}
				}
				
			}
		}
	}
}