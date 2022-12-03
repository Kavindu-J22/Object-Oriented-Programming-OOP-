public class Conversion{
	
	
	public double KMToMiles(double distance){
		
		return distance / 1.609;
		
	}
	
	public double MilesToKM(double distance){
		
		return distance * 1.609;
		
	} 
	
	public double FeetToMetres(double distance){
		
		return distance/3.281;
		
	}	
	
	public double MetresToFeet(double distance){
		
		return distance*3.281;
		
	}
	
	public double KgToPounds(double weight){
		
		return weight *2.205;
		
	} 
	
	public double PoundsToKg(double weight){
		
		return weight / 2.205;
		
	} 
	
	public double CelciusToFahrenheit(double temperature){
		
		return (temperature * 9/5) + 32;
		
	} 
	
	public double FahrenheightToCelcius(double temperature){
		
		return (temperature-32) * 5/9;
		
	}
}