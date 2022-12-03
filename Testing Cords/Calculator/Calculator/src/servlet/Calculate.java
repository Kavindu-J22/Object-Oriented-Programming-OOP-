package servlet;

public class Calculate {

	private double no1 = 0;

	private double no2 = 0;

	public double add(String n1, String n2) {
		
		double output = 0.0;
		try {
			no1 = Double.parseDouble(n1);
			no2 = Double.parseDouble(n2);
			output = (no1 + no2);
		} catch (NumberFormatException e) {
		}
		return output;
	}

	public double sub(String n1, String n2) {
		double output = 0.0;
		try {
			no1 = Double.parseDouble(n1);
			no2 = Double.parseDouble(n2);
			output = (no1 - no2);
		} catch (NumberFormatException e) {
		}
		return output;
	}

	public double multiply(String n1, String n2) {
		double output = 0.0;
		try {
			no1 = Double.parseDouble(n1);
			no2 = Double.parseDouble(n2);
			output = (no1 * no2);
		} catch (NumberFormatException e) {
		}
		return output;
	}

	public double div(String n1, String n2) {
		double output = 0.0;
		try {
			no1 = Double.parseDouble(n1);
			no2 = Double.parseDouble(n2);
			output = no1 / no2;
		}catch (NumberFormatException | ArithmeticException e) {
		}
		return output;
	}
}
