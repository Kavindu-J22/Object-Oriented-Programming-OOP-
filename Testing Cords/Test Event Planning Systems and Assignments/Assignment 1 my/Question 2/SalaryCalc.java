public class SalaryCalc{
	
	
	public static void main(String args[]){
		
		
		
		Employee emvinod = new Employee(1235,"K.V. vinod",71291521,60000,1000,200);
		emvinod.displayNetSalary();
		System.out.println();
		
		Employee emakalanka = new Employee(5678,"A.M. akalanka",723454612, 40000, 3500, 350);
		emakalanka.displayNetSalary();
		System.out.println();
		
		Manager MaKasthuri = new Manager(111,"W.D. Kasthuri",743214356, 145000, 5000, 2000);
		MaKasthuri.displayNetSalary();
		System.out.println();
		
		Employee MaKumara = new Manager(121,"L.M. Kumara",76543751, 120000, 5000, 2500);
		MaKumara.displayNetSalary();
		System.out.println();
		
		Director DiShakila = new Director(110,"P.K. Shakila",77549864,350000,15000,5000,1000,1000);
		DiShakila.displayNetSalary();
		System.out.println();
		
		Director DiPraveen = new Director(120,"B.Y. Praveen",7182015,365000,15000,4500,2500,5000);
		DiPraveen.displayNetSalary();
		System.out.println();
		
		
	}
	
	
}