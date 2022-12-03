
public class Director extends Manager{
	private double bonus;
	private double enterAllowance;
	
	public Director(int Empno, String name, long telephone, double basicsalary,double allowance, double deduction, double bonus, double enterAllowance) {
		super(Empno, name, telephone, basicsalary, allowance, deduction);
		this.bonus = bonus;
		this.enterAllowance = enterAllowance;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getEnterAllowance() {
		return enterAllowance;
	}

	public void setEnterAllowance(double enterAllowance) {
		this.enterAllowance = enterAllowance;
	}
	
	public double calcNetSalary() {
		return basicsalary + allowance + bonus + enterAllowance - deduction;
	}
}
