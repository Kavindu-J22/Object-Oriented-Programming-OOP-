
public class Mymain {

	public static void main(String[] args) {
		Receptionist recept1 = new Receptionist();
		
		boolean status = recept1.checkRoomAvailability(3);
		double bill = recept1.generatebill();
		

	}

}
