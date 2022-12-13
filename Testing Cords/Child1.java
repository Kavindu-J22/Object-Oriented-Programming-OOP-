import java.util.*;

public class Child1 extends Parent1{
	private int age;
	private int salary;
	
	public void setDetails(String name,int age,int mark,int salary){
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.salary = salary;
		
	}
	
	public String getname(){
		return this.name;
	}
	
	public int getsalary(){
		return this.salary;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public int getMark(){
		return this.mark;
	}
	
	public void display(){
		System.out.println("Student "+this.name);
		System.out.println();
		System.out.println(this.age+"\n"+this.mark);
		System.out.println(this.salary+" is good");
	}
}