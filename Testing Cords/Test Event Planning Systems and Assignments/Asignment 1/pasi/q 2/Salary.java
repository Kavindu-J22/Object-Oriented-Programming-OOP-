public class Salary{
	
	
	public static void main(String args[]){
		
		
		
		Employee emp1 = new Employee(12,"Sachith",76123654,20000,5,100);
		emp1.displayNetSalary();
		
		Employee emp2 = new Manager(13,"amila",77894561, 150000, 2000, 4000);
		emp2.displayNetSalary();
		
		Employee emp3 = new Director(15,"chamara",75623014, 250000, 10000, 2500, 1500, 2200);
		emp3.displayNetSalary();
		
		Employee emp4 = new Manager(11,"kusum",77123654, 95000, 2000, 1000);
		emp4.displayNetSalary();
		
		Manager man1 = new Manager(23,"Nimal",7123656,150000,10000,5000);
		man1.displayNetSalary();
		
		Director direc1 = new Director(112,"Prasadi",717896543,260000,10000,5000,2000,4000);
		direc1.displayNetSalary();
	
		
		
	}
	
	
}