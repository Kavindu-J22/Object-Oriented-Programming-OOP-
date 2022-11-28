class InvalidITNumberException extends Exception{
	
	public InvalidITNumberException(){
		super("Invalid IT number");
	}
	
}

class Student{
	private String StudentId;
	private String StudentName;

	public Student(String StudentId,String StudentName){
		this.StudentId=StudentId;
		this.StudentName=StudentName;
	}

	public void display() throws InvalidITNumberException{

		if(this.StudentId.substring(0,2).equals("IT")){
			if(this.StudentId.length()==10){
				System.out.println(StudentId);
				System.out.println(StudentName);
			}
			else{
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
		Student st1=new Student("IT21032806","Kavindu jayasinghe");
		try{
			st1.display();
		}
		catch(InvalidITNumberException invalidId){
			System.out.println(invalidId.getMessage());
		}

		Student st2=new Student("Test Id","Test Name");
		try{
			st2.display();
		}
		catch(InvalidITNumberException invalidId){
			System.out.println(invalidId.getMessage());
		}
	}
}