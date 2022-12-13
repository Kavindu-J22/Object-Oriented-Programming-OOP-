import java.util.Scanner;

public class Menu{
	Scanner prosses = new Scanner(System.in);
	
	public static void main(String args[]){
		Menu men1 = new Menu();
		men1.displayMainMenu();
		
	}
	
	void displayMainMenu(){
        int num;

        System.out.println("*_______________________*");
        System.out.println("#---- Main Menu ----#");
        System.out.println("$. Conversion Menu---_(1)_");
        System.out.println("$. Calculation Menu---_(2)_");
        System.out.println("$. Exit---_(0)_");
        System.out.print("Enter the number do you want :");

        num = prosses.nextInt();

        switch(num){
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
                System.out.println("Sorry!!Invalid Input.Please try again.!");
				System.out.println();
                displayMainMenu();
				
        }
		
	}
	
	void displayConversionSubMenu(){
        int num2;
		System.out.println();
        System.out.println("*_______________________*");
        System.out.println("#---- Conversion Sub Menu ----#");
        System.out.println("$. Conversion Length---_(1)_");
        System.out.println("$. Conversion Weight---_(2)_");
        System.out.println("$. Conversion Temperature---_(3)_");
        System.out.println("$. Exit---_0_");

        System.out.print("Enter the number do you want :");
        num2 = prosses.nextInt();

        switch(num2){
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
                System.out.println("Sorry!!Invalid Input.Please try again.!");
				
				System.out.println();
                displayConversionSubMenu();
				
        }
		
	}
	
	void displayCalculationSubMenu(){
		
        int num3;

        System.out.println("*_______________________*");
        System.out.println("*---- Calculation Sub Menu ----*");
        System.out.println("$. Sum of Series---_(1)_");
        System.out.println("$. Sum of Array---_(2)_");
        System.out.println("$. Product of Series---_(3)_");
        System.out.println("$. Product of Array---_(4)_"); 
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want :");
        num3 = prosses.nextInt();

        Calculation cal = new Calculation();

        int startv,endv,incrv,result,size;
        int[] ary;

        switch(num3){
            case 1:
                System.out.print("Starting Value :");
                startv = prosses.nextInt();
				
                System.out.print("Ending Value Value :");
                endv = prosses.nextInt();
				
                System.out.print("Increment Value :");
                incrv = prosses.nextInt();
				
                result = cal.SumOfSeries(startv,endv,incrv);
                System.out.println("Result is : " + result);
				
				System.out.println();
                displayCalculationSubMenu();
				
                break;
				
            case 2:
                System.out.print("Size of array :");
                size = prosses.nextInt();

                ary = new int[size];

                for(int i = 0; i < size;i++){
					
                    System.out.print("Enter the value " + i + " :");
                    ary[i] = prosses.nextInt();
                }
                result = cal.SumOfArray(ary,size);
                System.out.println("Result is : " + result);
				
				System.out.println();
                displayCalculationSubMenu();
				
                break;
				
            case 3 :
                System.out.print("Starting Value :");
                startv = prosses.nextInt();
				
                System.out.print("Ending Value Value :");
                endv = prosses.nextInt();
				
                System.out.print("Increment Value :");
                incrv = prosses.nextInt();
				
                result = cal.ProductOfSeries(startv,endv,incrv);
                System.out.println("Result is : " + result);
				
				System.out.println();
                displayCalculationSubMenu();
				
                break;
				
            case 4 :
                System.out.print("Size of array :");
                size = prosses.nextInt();

                ary = new int[size];

                for(int i = 0; i < size;i++){
                    System.out.print("Enter the value " + i + " :");
                    ary[i] = prosses.nextInt();
                }
                result = cal.SumOfArray(ary,size);
                System.out.println("Result is : " + result);
				
				System.out.println();
                displayCalculationSubMenu();
				
                break;
				
            case 0 :
			
                displayMainMenu();
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again.!");
				
				System.out.println();
                displayCalculationSubMenu();
				
        }
		
	}
	
	void displayConversionLengthSubmenu(){
        double distance,anw;
        int num4;

        System.out.println("*_______________________*");
        System.out.println("*---- Conversion Length Menu ----*");
        System.out.println("$. KM to Miles---_(1)_");
        System.out.println("$. Miles to KM---_(2)_");
        System.out.println("$. Feet to Metres---_(3)_");
        System.out.println("$. Metres to Feet---_(4)_");
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want :");
        num4 = prosses.nextInt();

        Conversion con = new Conversion();

        switch(num4){
            case 1:
                System.out.print("Enter distance(KM) :");
                distance= prosses.nextDouble();
				
                anw = con.KMToMiles(distance);
                System.out.println("Result : " + anw + " Miles");
				
				System.out.println();
                displayConversionLengthSubmenu();
				
                break;
				
            case 2:
                System.out.print("Enter the distance(Miles) :");
                distance = prosses.nextDouble();
				
                anw = con.MilesToKM(distance);
                System.out.println("Result is : " + anw + " km");
				
				System.out.println();
                displayConversionLengthSubmenu();
				
                break;
				
            case 3 :
                System.out.print("Enter the distance(Feet) :");
                distance = prosses.nextDouble();
				
                anw = con.FeetToMetres(distance);
                System.out.println("Result : " + anw + " m");
				
				System.out.println();
                displayConversionLengthSubmenu();
				
                break;
				
            case 4 :
                System.out.print("Enter the distance(m) :");
                distance = prosses.nextDouble();
				
                anw = con.MetresToFeet(distance);
                System.out.println("Result is : " + anw + " feet");
				
				System.out.println();
                displayConversionLengthSubmenu();
				
                break;
				
            case 0 :
			
                displayConversionSubMenu();
				
                break;
				
            default :
                System.out.println("Sorry!!Invalid Input.Please try again.!");
				
				System.out.println();
                displayConversionLengthSubmenu();
				
        }		
		
	}
	
	void displayConversionWeightSubmenu(){
		
        double weight,anw;
        int num5;

        System.out.println("*_______________________*");
        System.out.println("#---- Conversion Weight Menu ----#");
        System.out.println("$. KG to Pounds---_(1)_");
        System.out.println("$. Pounds to KG---_(2)_");
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want : ");
        num5 = prosses.nextInt();

        Conversion con = new Conversion();

        switch(num5){
            case 1:
			
                System.out.print("Enter weight(Kg) :");
                weight = prosses.nextDouble();
                anw = con.KgToPounds(weight);
                System.out.println("Result is: " + anw + " pounds");
				
				System.out.println();
                displayConversionWeightSubmenu();
				
                break;
				
            case 2:
			
                System.out.print("Enter the weight(Pounds) :");
                weight = prosses.nextDouble();
                anw = con.PoundsToKg(weight);
                System.out.println("Result : " + anw + " kg");
				
				System.out.println();
                displayConversionWeightSubmenu();
				
                break;
				
            case 0 :
			
				System.out.println();
                displayConversionSubMenu();
				
                break;
				
            default :
			
                System.out.println("Sorry!!Invalid Input.Please try again.!");
				
				System.out.println();
                displayConversionWeightSubmenu();
				
        }
		
	}
	
	void displayConversionTemperatureSubmenu(){
        double temp,anw;
        int num6;

        System.out.println("*_______________________*");
        System.out.println("#---- Conversion Temperature Menu ----#");
        System.out.println("$. Celcius to Fahrenheit---_(1)_");
        System.out.println("$. Fahrenheit to Celcius---_(2)_");
        System.out.println("$. Exit---_(0)_");

        System.out.print("Enter the number do you want :");
        num6 = prosses.nextInt();

        Conversion con = new Conversion();

        switch(num6){
            case 1:
			
                System.out.print("Enter tempreture(C) : ");
                temp = prosses.nextDouble();
				
                anw = con.CelciusToFahrenheit(temp);
                System.out.println("Result : " + anw + " F");
				
				System.out.println();
                displayConversionTemperatureSubmenu();
				
                break;
				
            case 2:
			
                System.out.print("Enter tempreture(F) :");
                temp = prosses.nextDouble();
				
                anw = con.FahrenheightToCelcius(temp);
                System.out.println("Result : " + anw + " C");
				
				System.out.println();
                displayConversionTemperatureSubmenu();
				
                break;
				
            case 0 :
			
                displayConversionSubMenu();
				
                break;
				
            default :
			
				System.out.println();
                System.out.println("Sorry!!Invalid Input.Please try again.!");
                displayConversionTemperatureSubmenu();
				
        }		
		
	}

}