
public class Question2 {

	public static void main(String[] args) {
		
		Employee em = new Employee();
		em.displayNetSalary();
		
		Employee em1 = new Employee(111,"Ravishka",071410610,20000,5,100);
		em1.displayNetSalary();
		
		Employee em2 = new Manager(004, "sss", 074456245, 5000, 1000, 2000);
		em2.displayNetSalary();
		
		Employee em3 = new Director(005, "boo", 0713512654, 50000, 10000, 2000, 1000, 2500);
		em3.displayNetSalary();
		
		Manager m1 = new Manager(001,"aaa",6373636,50000,10000,5000);
		m1.displayNetSalary();
		
		Director d1 = new Director(002,"Pravini",071524654,60000,10000,5000,1000,2000);
		d1.displayNetSalary();
	}

}
