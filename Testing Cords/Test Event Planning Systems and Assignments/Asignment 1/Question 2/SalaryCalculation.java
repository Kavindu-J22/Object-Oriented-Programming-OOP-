import java.util.Scanner;

public class SalaryCalculation{
    public static void main(String[] args) {
        Employee Dushan = new Employee(1,"A.B.C.Dushan", 7181988, 1000.0, 500.0, 10.0);
        Employee Dulakshan = new Employee(2,"A.B.C.Dulakshan",7737910, 1000.0, 500.0, 10.0);
        Employee Dilshan = new Employee(3,"A.B.C.Dilshan",7707147, 1000.0, 500.0, 10.0);

        Manager Yasith = new Manager(4,"A.B.C.Yasith",7707147, 2000.0, 500.0, 100.0);
        Manager Chanika = new Manager(5,"A.B.C.Chamika",7707147, 2000.0, 500.0, 100.0);

        Director Sithum = new Director(6,"A.B.C.Sithum",7707147, 3000.0, 500.0, 100.0,400.0,400.0);

        System.out.println("______________________EMPLOYEES__________________________");
        System.out.println(Dushan.Empno);
        System.out.println(Dushan.name);
        System.out.println(Dushan.telephone);
        Dushan.displayNetSalary();
        System.out.println("_________________________________________________________");
        System.out.println(Dulakshan.Empno);
        System.out.println(Dulakshan.name);
        System.out.println(Dulakshan.telephone);
        Dulakshan.displayNetSalary();
        System.out.println("_________________________________________________________");
        System.out.println(Dilshan.Empno);
        System.out.println(Dilshan.name);
        System.out.println(Dilshan.telephone);
        Dilshan.displayNetSalary();
        System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println("________________________Managers_________________________");
        System.out.println(Yasith.Empno);
        System.out.println(Yasith.name);
        System.out.println(Yasith.telephone);
        Yasith.displayNetSalary();
        System.out.println("_________________________________________________________");
        System.out.println(Chanika.Empno);
        System.out.println(Chanika.name);
        System.out.println(Chanika.telephone);
        Chanika.displayNetSalary();
        System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println("________________________Director_________________________");
        System.out.println(Sithum.Empno);
        System.out.println(Sithum.name);
        System.out.println(Sithum.telephone);
        Sithum.displayNetSalary();
        System.out.println("_________________________________________________________");

        



    }
}
