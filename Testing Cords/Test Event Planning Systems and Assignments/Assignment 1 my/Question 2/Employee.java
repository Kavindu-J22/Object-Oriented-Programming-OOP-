
public class Employee {
	protected int Empno;
	protected String name;
	protected long telephone;
	protected double basicsalary;
	
	private double othrs;
	private double otrate;
	
public Employee(int Empno, String name, long telephone, double basicsalary){
		
        this.Empno=Empno;
        this.name=name;
        this.telephone=telephone;
        this.basicsalary=basicsalary;
		
    }
	
	

    public Employee(int Empno, String name, long telephone, double basicsalary, double othrs, double otrate){
		
        this.Empno=Empno;
        this.name=name;
        this.telephone=telephone;
        this.basicsalary=basicsalary;
        this.othrs=othrs;
        this.otrate=otrate;
    }
	
	
	public void displayNetSalary(){
        
		System.out.println("Employee No :- "+this.name);
		System.out.println("Employee No :- "+this.Empno);
        System.out.println(calcNetSalary());
    }
	

    public double calcNetSalary(){
       return this.basicsalary + (this.othrs * this.otrate);
       
	 
    }
}
