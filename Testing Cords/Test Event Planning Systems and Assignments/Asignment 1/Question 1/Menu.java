import java.util.Scanner;

public class Menu{
    Scanner input = new Scanner(System.in);

    public static void main(String []args){
        Menu me = new Menu();
        me.displayMainMenu();
        
    }

    void displayMainMenu(){
        int index;
        
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("--- Main Menu ---");
        System.out.println("1. Conversion Menu");
        System.out.println("2. Calculation Menu");
        System.out.println("0. Exit");
        System.out.print("Your Choice :");

        index = input.nextInt();

        switch(index){
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
                System.out.println("Invalid Input");
                displayMainMenu();
        }

    }
    void displayConversionSubMenu(){

        int index;
        System.out.println("");
        System.out.println("--- Conversion Sub Menu ---");
        System.out.println("1 . Conversion Length");
        System.out.println("2 . Conversion Weight");
        System.out.println("3 . Conversion Temperature");
        System.out.println("0. Exit");

        System.out.print("Your Choice :");
        index = input.nextInt();

        switch(index){
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
                System.out.println("Invalid Input");
                displayConversionSubMenu();
        }
    } 
    void displayCalculationSubMenu(){

        int index;

        System.out.println("");
        System.out.println("--- Calculation Sub Menu ---");
        System.out.println("1. Sum of Series");
        System.out.println("2. Sum of Array");
        System.out.println("3. Product of Series");
        System.out.println("4. Product of Array"); 
        System.out.println("0. Exit");

        System.out.print("Your Choice :");
        index = input.nextInt();

        Calculation cal = new Calculation();

        int start_val,end_val,incr_val,result,size;
        int[] arr;

        switch(index){
            case 1:
                System.out.print("Stating Value :");
                start_val = input.nextInt();
                System.out.print("End Value Value :");
                end_val = input.nextInt();
                System.out.print("Increment Value :");
                incr_val = input.nextInt();
                result = cal.SumOfSeries(start_val,end_val,incr_val);
                System.out.println("Result : " + result);
                displayCalculationSubMenu();
                break;
            case 2:
                System.out.print("Size of array :");
                size = input.nextInt();

                arr = new int[size];

                for(int i = 0; i < size;i++){
                    System.out.print("Enter value for index " + i + " :");
                    arr[i] = input.nextInt();
                }
                result = cal.SumOfArray(arr,size);
                System.out.println("Result : " + result);
                displayCalculationSubMenu();
                break;
            case 3 :
                System.out.print("Stating Value :");
                start_val = input.nextInt();
                System.out.print("End Value Value :");
                end_val = input.nextInt();
                System.out.print("Increment Value :");
                incr_val = input.nextInt();
                result = cal.ProductOfSeries(start_val,end_val,incr_val);
                System.out.println("Result : " + result);
                displayCalculationSubMenu();
                break;
            case 4 :
                System.out.print("Size of array :");
                size = input.nextInt();

                arr = new int[size];

                for(int i = 0; i < size;i++){
                    System.out.print("Enter value for index " + i + " :");
                    arr[i] = input.nextInt();
                }
                result = cal.SumOfArray(arr,size);
                System.out.println("Result : " + result);
                displayCalculationSubMenu();
                break;
            case 0 :
                displayMainMenu();
                break;
            default :
                System.out.println("Invalid Input");
                displayCalculationSubMenu();
        }
    }
    void displayConversionLengthSubmenu(){
        double distance,result;
        int index;

        System.out.println("");
        System.out.println("--- Conversion Length Menu ---");
        System.out.println("1 . KM to Miles");
        System.out.println("2 . Miles to KM");
        System.out.println("3 . Feet to Metres");
        System.out.println("4 . Metres to Feet");
        System.out.println("0. Exit");

        System.out.print("Your Choice :");
        index = input.nextInt();

        Conversion con = new Conversion();

        switch(index){
            case 1:
                System.out.print("Enter the distance(KM) :");
                distance = input.nextDouble();
                result = con.KMToMiles(distance);
                System.out.println("Result : " + result + "Miles");
                displayConversionLengthSubmenu();
                break;
            case 2:
                System.out.print("Enter the distance(Miles) :");
                distance = input.nextDouble();
                result = con.MilesToKM(distance);
                System.out.println("Result : " + result + " km");
                displayConversionLengthSubmenu();
                break;
            case 3 :
                System.out.print("Enter the distance(Feet) :");
                distance = input.nextDouble();
                result = con.FeetToMetres(distance);
                System.out.println("Result : " + result + " m");
                displayConversionLengthSubmenu();
                break;
            case 4 :
                System.out.print("Enter the distance(m) :");
                distance = input.nextDouble();
                result = con.MetresToFeet(distance);
                System.out.println("Result : " + result + " feet");
                displayConversionLengthSubmenu();
                break;
            case 0 :
                displayConversionSubMenu();
                break;
            default :
                System.out.println("Invalid Input");
                displayConversionLengthSubmenu();
        }
    } 
    void displayConversionWeightSubmenu(){
        double weight,result;
        int index;

        System.out.println("");
        System.out.println("--- Conversion Weight Menu ---");
        System.out.println("1 . KG to Pounds");
        System.out.println("2 . Pounds to KG");
        System.out.println("0. Exit");

        System.out.print("Your Choice :");
        index = input.nextInt();

        Conversion con = new Conversion();

        switch(index){
            case 1:
                System.out.print("Enter the weight(Kg) :");
                weight = input.nextDouble();
                result = con.KgToPounds(weight);
                System.out.println("Result : " + result + " pounds");
                displayConversionWeightSubmenu();
                break;
            case 2:
                System.out.print("Enter the weight(Pounds) :");
                weight = input.nextDouble();
                result = con.PoundsToKg(weight);
                System.out.println("Result : " + result + " km");
                displayConversionWeightSubmenu();
                break;
            case 0 :
                displayConversionSubMenu();
                break;
            default :
                System.out.println("Invalid Input");
                displayConversionWeightSubmenu();
        }


    }
    void displayConversionTemperatureSubmenu(){
        double temp,result;
        int index;

        System.out.println("");
        System.out.println("--- Conversion Temperature Menu ---");
        System.out.println("1 . Celcius to Fahrenheit");
        System.out.println("2 . Fahrenheit to Celcius");
        System.out.println("0. Exit");

        System.out.print("Your Choice :");
        index = input.nextInt();

        Conversion con = new Conversion();

        switch(index){
            case 1:
                System.out.print("Enter the tempreture(C) :");
                temp = input.nextDouble();
                result = con.CelciusToFahrenheit(temp);
                System.out.println("Result : " + result + " F");
                displayConversionTemperatureSubmenu();
                break;
            case 2:
                System.out.print("Enter the tempreture(F) :");
                temp = input.nextDouble();
                result = con.FahrenheightToCelcius(temp);
                System.out.println("Result : " + result + " C");
                displayConversionTemperatureSubmenu();
                break;
            case 0 :
                displayConversionSubMenu();
                break;
            default :
                System.out.println("Invalid Input");
                displayConversionTemperatureSubmenu();
        }
    }

}