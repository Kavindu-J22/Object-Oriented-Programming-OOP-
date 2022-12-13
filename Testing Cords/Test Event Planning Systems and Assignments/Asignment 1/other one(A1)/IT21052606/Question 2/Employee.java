
public class Employee {
	protected int Empno;
	protected String name;
	protected long telephone;
	protected double basicsalary;
	private int othrs;
	private double otrate;
	
	public Employee(int Empno, String name, long telephone, double basicsalary, int othrs, double otrate) {
		super();
		this.Empno = Empno;
		this.name = name;
		this.telephone = telephone;
		this.basicsalary = basicsalary;
		this.othrs = othrs;
		this.otrate = otrate;
	}
	
	public Employee(int Empno, String name, long telephone, double basicsalary) {
		super();
		this.Empno = Empno;
		this.name = name;
		this.telephone = telephone;
		this.basicsalary = basicsalary;
	}

	public Employee() {
		
	}

	public int getEmpno() {
		return Empno;
	}
	
	public void setEmpno(int empno) {
		Empno = empno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getTelephone() {
		return telephone;
	}
	
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	
	public double getBasicsalary() {
		return basicsalary;
	}
	
	public void setBasicsalary(double basicsalary) {
		this.basicsalary = basicsalary;
	}
	
	public int getOthrs() {
		return othrs;
	}
	
	public void setOthrs(int othrs) {
		this.othrs = othrs;
	}
	
	public double getOtrate() {
		return otrate;
	}
	
	public void setOtrate(double otrate) {
		this.otrate = otrate;
	}
	
	public double calcNetSalary() {
		return this.basicsalary+(this.othrs*this.otrate);
	}
	
	public void displayNetSalary() {
		System.out.println("Net Salary = "
				+ calcNetSalary());
	}
}
