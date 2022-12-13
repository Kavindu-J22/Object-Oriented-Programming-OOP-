public class Manager extends Employee {
    
    double allowances;
    double deductions;
        
    
    public Manager(int no, String nam, int phon, double base, double allo, double deduc){
        super(no, nam, phon, base);
        allowances=allo;
        deductions=deduc;
        

    }
    public double calcNetSalary(){
        double netsalary = basicsalary + allowances -deductions;
        return netsalary;
    } 

   
    
    
    
    
}

