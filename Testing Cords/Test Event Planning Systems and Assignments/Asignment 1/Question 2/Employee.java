public class Employee {
    int Empno;
    String name;
    int telephone;
    double basicsalary;
    double others;
    double otrate;
    public Employee(int no, String nam, int phon, double base){
        Empno=no;
        name=nam;
        telephone=phon;
        basicsalary=base;
    }

    public Employee(int no, String nam, int phon, double base, double oth, double ot){
        Empno=no;
        name=nam;
        telephone=phon;
        basicsalary=base;
        others=oth;
        otrate=ot;
    }

    public double calcNetSalary(){
        double netsalary = basicsalary + (others * otrate);
        return netsalary;
    } 

    public void displayNetSalary(){
        
        System.out.println(calcNetSalary());
    }
}




