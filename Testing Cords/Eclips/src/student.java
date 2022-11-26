
public class student {
	
	private String name;
	private int age;
	private double marks;
	
	public student(String name,int age,double marks) {
		this.name = name;
		this.age = age;
		this.marks = marks;
		
	}
	
	//setter
	
	public void setName(String name) {
		
		this.name = name;	
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public void setMark(double marks) {
		
		this.marks = marks;
	}
	
	//getter
	
	public String getName() {
		
		return this.name;
	}
	
	public int getAge() {
		
		return this.age;
	}
		
	public double getMarks() {
		
		return this.marks;
	}
		
		
	
	public void show() {
		
		System.out.println("Your name is : "+name);
		System.out.println("Your age is : "+age);
		System.out.println("Your marks is : "+marks);
		
	}

}