public class L2ex2{
	public  static  void main(String args[]){
		
		System.out.println("Student ID : "+args[0]);
		System.out.println("Student Name : "+args[1]);
		System.out.println("District : "+args[2]);
		System.out.println("Course : "+args[3]);
		
		String num = args[4];
		System.out.println("Module : "+num);
		
		int num1 =Integer.parseInt(args[5]);
		System.out.println("new num is : "+num1*5);
	}
}