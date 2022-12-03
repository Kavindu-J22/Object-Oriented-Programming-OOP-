public class Manager extends Employee{

	
	protected double deduction;
	protected double allowance;
	
	public Manager(int Empno, String name, long telephone, double basicsalary,double allowance, double deduction) {
		
		super(Empno,name,telephone,basicsalary);
		this.deduction = deduction;
		this.allowance = allowance;
		
	}
	
	public double getDeduction() {
		return this.deduction;
	}
	
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	
	
	public double getAllowance() {
		return this.allowance;
	}
	
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	

	
	public double calcNetSalary() {
		return  basicsalary + allowance - deduction;
	
	}
	


}