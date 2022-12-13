public class Employee {
	
	private double othrs;
	private double otrate;
	
	protected int Empno;
	protected String name;
	protected int telephone;
	protected double basicsalary;
	
	
    public Employee(int Empno, String name, int telephone, double basicsalary){
		
        this.Empno=Empno;
        this.name=name;
        this.telephone=telephone;
        this.basicsalary=basicsalary;
    }
	
	

    public Employee(int Empno, String name, int telephone, double basicsalary, double othrs, double otrate){
		
        this.Empno=Empno;
        this.name=name;
        this.telephone=telephone;
        this.basicsalary=basicsalary;
        this.othrs=othrs;
        this.otrate=otrate;
    }
	
	
	public void displayNetSalary(){
        
		System.out.println("Name - "+this.name);
		System.out.println("Emp No - "+this.Empno);
		System.out.println("Tele-phone - "+this.telephone);
        System.out.println(calcNetSalary());
    }
	

    public double calcNetSalary(){
       return this.basicsalary + (this.othrs * this.otrate);
       
	 
    } 
	
	
}