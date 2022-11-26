
public class  Resept{
	private int ID;
	private String name;
	private String tpno;
	
	
	
	public boolean checkroomavl(int roomno){
		return roomno == 5|| roomno == 6;
	}
	public double genbill(int cal){
	
		return cal*2;
	}
	
}