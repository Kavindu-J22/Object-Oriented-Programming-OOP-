 public class person8{
	private String name;
	private int age;
	private double salary;
	private String Company;
	
	//getters
	
	public String getname(){
		return this.name;
	}
	
	public int getage(){
		return this.age;
	}

	public double getsalary(){
		return this.salary;
	}
	
	public String getcompany(){
		return this.Company;
	}
	
	// setters
	
	public void setname(String name){
		this.name = name;
	}
	
	public void setage(int age){
		this.age = age;
	}
	
	public void setsalery(double salary){
		this.salary = salary;
	}
	
	public void setcompany(String Company){
		this.Company = Company;
	}
	
	
	// Default Constrouctors.
	
	public person8(){
		
	}
/*	public person8(){
		name = null; or "kamal"
		age = 0; or 28
		salary = 0.0; or 50000;
		
	}*/
	
	// Constructors with paramiters.
	
	
	public person8(String pname,int page){
		name = pname;
		age = page;
	}
	
	public person8(String name,int age,double salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public person8(String name,int age,double salary,String Company){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.Company = Company;
	}
	
}