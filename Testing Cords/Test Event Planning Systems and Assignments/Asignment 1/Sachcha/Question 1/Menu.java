import java.util.Scanner;

public class Menu{
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]){
		Menu menu1 = new Menu();
		menu1.displayMainMenu();
		
	}
	
	void displayMainMenu(){
        int no1;
        
        Scanner inp = new Scanner(System.in);

        System.out.println("*_______________________*");
        System.out.println("#---- Main Menu ----#");
        System.out.println("$. Conversion Menu---_(1)_");
        System.out.println("$. Calculation Menu---_(2)_");
        System.out.println("$. Exit---_(0)_");
        System.out.print("Enter the number do you want :");

        no1 = inp.nextInt();

        switch(no1){
            case 1:
			
                displayConversionSubMenu();
				
                break;
				
            case 2:
			
                displayCalculationSubMenu();
				
                break;
				
            case 0 :
			
                System.exit(0);
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again latter!");
				
                displayMainMenu();
        }
		
	}
	
	void displayConversionSubMenu(){
		
        int no2;
		
        System.out.println("*_______________________*");
        System.out.println("#---- Conversion Sub Menu ----#");
        System.out.println("$. Conversion Length---_(1)_");
        System.out.println("$. Conversion Weight---_(2)_");
        System.out.println("$. Conversion Temperature---_(3)_");
        System.out.println("$. Exit---_0_");

        System.out.print("Enter the number do you want :");
		
        no2 = sc.nextInt();

        switch(no2){
			
            case 1:
			
                displayConversionLengthSubmenu();
				
                break;
				
            case 2:
			
                displayConversionWeightSubmenu();
				
                break;
				
            case 3:
			
                displayConversionTemperatureSubmenu();
				
                break;
				
            case 0 :
			
                displayMainMenu();
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again latter!");
                displayConversionSubMenu();
        }
		
	}
	
	void displayCalculationSubMenu(){
		
        int no3;

        System.out.println("*_______________________*");
        System.out.println("*---- Calculation Sub Menu ----*");
        System.out.println("$. Sum of Series---_(1)_");
        System.out.println("$. Sum of Array---_(2)_");
        System.out.println("$. Product of Series---_(3)_");
        System.out.println("$. Product of Array---_(4)_"); 
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want :");
        no3 = sc.nextInt();

        Calculation cal = new Calculation();

        int startva,endva,incrva,result,size;
        int[] array;

        switch(no3){
            case 1:
                System.out.print("Starting Value :");
				
                startva = sc.nextInt();
				
                System.out.print("Ending Value Value :");
				
                endva = sc.nextInt();
				
                System.out.print("Increment Value :");
				
                incrva = sc.nextInt();
				
                result = cal.SumOfSeries(startva,endva,incrva);
				
                System.out.println("Result is : " + result);
				
                displayCalculationSubMenu();
				
                break;
				
            case 2:
                System.out.print("Size of array :");
				
                size = sc.nextInt();

                array = new int[size];

                for(int i = 0; i < size;i++){
					
                    System.out.print("Enter the value " + i + " :");
					
                    array[i] = sc.nextInt();
                }
                result = cal.SumOfArray(array,size);
				
                System.out.println("Result is : " + result);
				
                displayCalculationSubMenu();
				
                break;
				
            case 3 :
                System.out.print("Starting Value :");
				
                startva = sc.nextInt();
				
                System.out.print("Ending Value Value :");
				
                endva = sc.nextInt();
				
                System.out.print("Increment Value :");
				
                incrva = sc.nextInt();
				
                result = cal.ProductOfSeries(startva,endva,incrva);
				
                System.out.println("Result is : " + result);
				
                displayCalculationSubMenu();
				
                break;
				
            case 4 :
                System.out.print("Size of array :");
				
                size = sc.nextInt();

                array = new int[size];

                for(int i = 0; i < size;i++){
					
                    System.out.print("Enter the value " + i + " :");
                    array[i] = sc.nextInt();
					
                }
                result = cal.SumOfArray(array,size);
				
                System.out.println("Result is : " + result);
				
                displayCalculationSubMenu();
				
                break;
				
            case 0 :
			
                displayMainMenu();
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again latter!");
				
                displayCalculationSubMenu();
        }
		
	}
	
	void displayConversionLengthSubmenu(){
		
        double distance,ans;
        int no4;

        System.out.println("*_______________________*");
        System.out.println("*---- Conversion Length Menu ----*");
        System.out.println("$. KM to Miles---_(1)_");
        System.out.println("$. Miles to KM---_(2)_");
        System.out.println("$. Feet to Metres---_(3)_");
        System.out.println("$. Metres to Feet---_(4)_");
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want :");
		
        no4 = sc.nextInt();

        Conversion con = new Conversion();

        switch(no4){
            case 1:
                System.out.print("Enter distance(KM) :");
				
                distance= sc.nextDouble();
				
                ans = con.KMToMiles(distance);
				
                System.out.println("Result : " + ans + " Miles");
				
                displayConversionLengthSubmenu();
				
                break;
				
            case 2:
                System.out.print("Enter the distance(Miles) :");
				
                distance = sc.nextDouble();
				
                ans = con.MilesToKM(distance);
				
                System.out.println("Result is : " + ans + " km");
				
                displayConversionLengthSubmenu();
				
                break;
				
            case 3 :
                System.out.print("Enter the distance(Feet) :");
				
                distance = sc.nextDouble();
				
                ans = con.FeetToMetres(distance);
				
                System.out.println("Result : " + ans + " m");
				
                displayConversionLengthSubmenu();
				
                break;
				
            case 4 :
                System.out.print("Enter the distance(m) :");
				
                distance = sc.nextDouble();
				
                ans = con.MetresToFeet(distance);
				
                System.out.println("Result is : " + ans + " feet");
				
                displayConversionLengthSubmenu();
				
                break;
				
            case 0 :
			
                displayConversionSubMenu();
				
                break;
				
            default :
                System.out.println("Sorry!!Invalid Input.Please try again latter!");
				
                displayConversionLengthSubmenu();
        }		
		
	}
	
	void displayConversionWeightSubmenu(){
		
        double weight,ans;
        int no5;

        System.out.println("*_______________________*");
        System.out.println("#---- Conversion Weight Menu ----#");
        System.out.println("$. KG to Pounds---_(1)_");
        System.out.println("$. Pounds to KG---_(2)_");
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want : ");
        no5 = sc.nextInt();

        Conversion con = new Conversion();

        switch(no5){
            case 1:
			
                System.out.print("Enter weight(Kg) :");
				
                weight = sc.nextDouble();
				
                ans = con.KgToPounds(weight);
				
                System.out.println("Result is: " + ans + " pounds");
				
                displayConversionWeightSubmenu();
				
                break;
				
            case 2:
			
                System.out.print("Enter the weight(Pounds) :");
				
                weight = sc.nextDouble();
				
                ans = con.PoundsToKg(weight);
				
                System.out.println("Result : " + ans + " kg");
				
                displayConversionWeightSubmenu();
				
                break;
				
            case 0 :
			
                displayConversionSubMenu();
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again latter!");
				
                displayConversionWeightSubmenu();
        }
		
	}
	
	void displayConversionTemperatureSubmenu(){
        double temp,ans;
        int no6;

        System.out.println("*_______________________*");
        System.out.println("#---- Conversion Temperature Menu ----#");
        System.out.println("$. Celcius to Fahrenheit---_(1)_");
        System.out.println("$. Fahrenheit to Celcius---_(2)_");
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want :");
        no6 = sc.nextInt();

        Conversion con = new Conversion();

        switch(no6){
            case 1:
			
                System.out.print("Enter tempreture(C) : ");
				
                temp = sc.nextDouble();
				
                ans = con.CelciusToFahrenheit(temp);
				
                System.out.println("Result : " + ans + " F");
				
                displayConversionTemperatureSubmenu();
				
                break;
				
            case 2:
			
                System.out.print("Enter tempreture(F) :");
				
                temp = sc.nextDouble();
				
                ans = con.FahrenheightToCelcius(temp);
				
                System.out.println("Result : " + ans + " C");
				
                displayConversionTemperatureSubmenu();
				
                break;
				
            case 0 :
			
                displayConversionSubMenu();
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again latter!");
				
                displayConversionTemperatureSubmenu();
        }		
		
	}

}