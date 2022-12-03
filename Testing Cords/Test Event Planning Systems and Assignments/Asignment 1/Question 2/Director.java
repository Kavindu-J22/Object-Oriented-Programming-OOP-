public class Director extends Manager{
    double bonus;
    double entertainmentAllowance;

    public Director(int no, String nam, int phon, double base, double allo, double deduc, double bon, double ent){
        super(no, nam, phon, base, allo, deduc);
        bonus=bon;
        entertainmentAllowance=ent;
    }

    public double calcNetSalary(){
        double netsalary = basicsalary + allowances -deductions +bonus+entertainmentAllowance;
        return netsalary;
    } 

    




}