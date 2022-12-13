public class Director extends Manager{
	
	private double entertainmentAllowance;
	private double bonus;
	
	
	public Director(int Empno, String name, long telephone, double basicsalary,double allowance, double deduction, double bonus, double entertainmentAllowance) {
		super(Empno, name, telephone, basicsalary, allowance, deduction);
		this.bonus = bonus;
		this.entertainmentAllowance = entertainmentAllowance;
	}
	
	public double getEntertainmentAllowance() {
		return this.entertainmentAllowance;
	}
	
	public void setEntertainmentAllowance(double entertainmentAllowance) {
		this.entertainmentAllowance = entertainmentAllowance;
	}
	

	public double getBonus() {
		return this.bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	
	public double calcNetSalary() {
		return basicsalary + allowance + bonus + entertainmentAllowance - deduction;
	}
	
	
}