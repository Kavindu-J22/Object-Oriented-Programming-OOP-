import java.util.Scanner;

public class Menu {
	
	public void displayMainMenu() {
		
		int ch;
		
		System.out.println("Main Menu\n");
		System.out.println("1.Conversions"
				+ "\n"
				+ "2.Calculations");
		
		Scanner sc = new Scanner(System.in);
		
		ch = sc.nextInt();
		
		if (ch==1) {
			displayConversionSubMenu();			
		} 
		else if(ch==2){
			displayCalculationSubMenu();
		}
	}  
	
	public void displayConversionSubMenu() {
		
		int ch; 
		
		System.out.println("Conversion Sub Menu\n");
		System.out.println("1.Conversion of Length"
				+ "\n"
				+ "2.Conversion of Weight"
				+ "\n"
				+ "3.Conversion of Temperature"
				+ "\n"
				+ "0.Exit");
		
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		
		if (ch==1) {
			displayConversionLengthSubmenu();			
		} 
		else if(ch==2){
			displayConversionWeightSubmenu();
		}
		else if(ch==3){
			displayConversionTemperatureSubmenu();
		}
		else if(ch==0){
			displayMainMenu();
		}
		
	}
	
	public void displayCalculationSubMenu() {
		System.out.println("Calculation Sub Menu\n");
		System.out.println("1.Sum of Series"
				+ "\n"
				+ "2.Sum of Array"
				+ "\n"
				+ "3.Product of Series"
				+ "\n"
				+ "4.Product of Array"
				+ "\n"
				+ "0.Exit");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		Calculation c = new Calculation();
		
		if (ch==1) {
			System.out.println("Sum of Series");
			
			System.out.print("Enter Starting Number : ");
			int sNum = sc.nextInt();
			
			System.out.print("Enter Ending Number : ");
			int eNum = sc.nextInt();
			
			System.out.print("Enter Different : ");
			int dif = sc.nextInt();
			
			System.out.println("\nSum of the Series is " + c.SumOfSeries(sNum, eNum, dif));
			displayMainMenu();
		} 
		else if(ch==2){
			System.out.println("Sum of Array");
			
			System.out.print("Enter Array Size : ");
			int size = sc.nextInt();
			
			int[] arr = new int[size];
			
			for(int i=0;i<size;++i) {
				System.out.print("Enter Number " + i+1 + " : ");
				arr[i] = sc.nextInt();
			}
						
			System.out.println("\nSum of the Array is " + c.SumOfArray(arr, size));
			displayMainMenu();
		}
		else if(ch==3){
			System.out.println("Product of Series");
			
			System.out.print("Enter Starting Number : ");
			int sNum = sc.nextInt();
			
			System.out.print("Enter Ending Number : ");
			int eNum = sc.nextInt();
			
			System.out.print("Enter Different : ");
			int dif = sc.nextInt();
			
			System.out.println("\nProduct of the Series is " + c.ProductOfSeries(sNum, eNum, dif));
			displayMainMenu();
		}
		else if(ch==4){
			System.out.println("Product of Array");
			
			System.out.print("Enter Array Size : ");
			int size = sc.nextInt();
			
			int[] arr = new int[size];
			
			for(int i=0;i<size;++i) {
				System.out.print("Enter Number " + i+1 + " : ");
				arr[i] = sc.nextInt();
			}
						
			System.out.println("\nProduct of the Array is " + c.ProductOfArray(arr, size));
			displayMainMenu();
		}
		else if(ch==0) {
			displayMainMenu();
		}
	}
	
	public void displayConversionLengthSubmenu() {
		System.out.println("Conversion Length Sub Menu\n");
		System.out.println("1.Kilometers to Miles"
				+ "\n"
				+ "2.Miles to Kilometers"
				+ "\n"
				+ "3.Feet to Meters"
				+ "\n"
				+ "4.Meters to Feet"
				+ "\n"
				+ "0.Exit");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		Conversion c = new Conversion();
		
		if(ch==1) {
			System.out.println("Convert Kilometers to Miles");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " km = " + c.KMToMiles(km) + " miles");
			displayMainMenu();
		}
		else if(ch==2) {
			System.out.println("Convert Miles to Kilometers");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " miles = " + c.MilesToKM(km) + " km");
			displayMainMenu();
		}
		else if(ch==3) {
			System.out.println("Convert Feet to Meters");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " Feet = " + c.FeetToMetres(km) + " meters");
			displayMainMenu();
		}
		else if(ch==4) {
			System.out.println("Convert Meters to Feet");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " meters = " + c.FeetToMetres(km) + " Feets");
			displayMainMenu();
		}
		else if(ch==0) {
			displayConversionSubMenu();
		}
	}
	
	public void displayConversionWeightSubmenu() {
		System.out.println("Conversion Weight Sub Menu\n");
		System.out.println("1.Kilograms to pounds"
				+ "\n"
				+ "2.Pounds to Kilograms"
				+ "\n"
				+ "0.Exit");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		Conversion c = new Conversion();
		
		if(ch==1) {
			System.out.println("Convert Kilograms to pounds");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " kg = " + c.KgToPounds(km) + " pounds");
			displayMainMenu();
		}
		else if(ch==2) {
			System.out.println("Convert pounds to Kilograms");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " pounds = " + c.PoundsToKg(km) + " kg");
			displayMainMenu();
		}
		else if(ch==0) {
			displayConversionSubMenu();
		}
		
	}
	
	public void displayConversionTemperatureSubmenu() {
		System.out.println("Conversion Temperature Sub Menu\n");
		System.out.println("1.Celcius to Fahrenheit"
				+ "\n"
				+ "2.Fahrenheits to Celcius"
				+ "\n"
				+ "0.Exit");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		Conversion c = new Conversion();
		
		if(ch==1) {
			System.out.println("Convert Celcius to Fahrenheit");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " C = " + c.CelciusToFahrenheit(km) + " F");
			displayMainMenu();
		}
		else if(ch==2) {
			System.out.println("Convert Fahrenheits to Celcius");
			System.out.print("Enter Value : ");
			int km = sc.nextInt();
			System.out.println(km + " F = " + c.FahrenheightToCelcius(km) + " C");
			displayMainMenu();
		}
		else if(ch==0) {
			displayConversionSubMenu();
		}
	}
	
}
