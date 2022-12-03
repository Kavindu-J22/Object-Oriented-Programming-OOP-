
public class Manager extends Employee{
	protected double allowance;
	protected double deduction;
	
	public Manager(int Empno, String name, long telephone, double basicsalary,double allowance, double deduction) {
		super(Empno,name,telephone,basicsalary);
		this.allowance = allowance;
		this.deduction = deduction;
	}
	
	public double getAllowance() {
		return allowance;
	}
	
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	
	public double getDeduction() {
		return deduction;
	}
	
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	
	public double calcNetSalary() {
		return basicsalary + allowance - deduction;
	}
}
