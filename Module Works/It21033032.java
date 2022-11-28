class InvalidITNumberException extends Exception{
	public InvalidITNumberException(){
		super("Invalid IT number");
	}
	
}

class Student{
	private String StudentId;
	private String StudentName;

	public Student(String id,String name){
		this.StudentId=id;
		this.StudentName=name;
	}

	public void display() throws InvalidITNumberException{

		if(this.StudentId.substring(0,2).equals("IT") && this.StudentId.length()==10){
			try{
				int a=Integer.valueOf(StudentId.substring(2,10));
				System.out.println("Student ID : "+this.StudentId);
				System.out.println("Student Name : "+this.StudentName);
			}
			catch(Exception ex){
				throw new InvalidITNumberException();
			}
		}
		else{
			throw new InvalidITNumberException();
		}
		
	}

}

class Demo{
	public static void main(String[] args) {
		Student student1=new Student("IT21033032","Pasindu nishshanka");
		try{
			student1.display();
		}
		catch(InvalidITNumberException ex){
			System.out.println(ex.getMessage());
		}
	}
}