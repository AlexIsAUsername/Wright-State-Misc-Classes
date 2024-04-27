/**
 *  @author V. Starkey
 *  CS1180, Summer 2020
 *  Lab 8
 */
package lab8;

import java.util.Scanner;

/**
 * Uses methods to perform various conversions on user-entered values
 */
public class Lab8 {

     public static void main(String[] args) {

        double initValue, convertedValue;
        int choice;

        Scanner keyboard = new Scanner(System.in);

        choice = displayMenuAndGetChoice();
        while (choice != 5)
        {
           //process choice
           if (choice == 1)
           {
               System.out.print("\nEnter feet to be converted: ");
               initValue = keyboard.nextDouble();
               convertedValue = convertFeetToMeters(initValue);
               outputResults(initValue, convertedValue, "feet", "meters");
           }
           else if (choice == 2)
           {
               System.out.print("\nEnter pounds to be converted: ");
               initValue = keyboard.nextDouble();
               convertedValue = convertPoundsToKilograms(initValue);
               outputResults(initValue, convertedValue, "pounds", "kilograms");
           }
           else if (choice == 3)
           {
               System.out.print("\nEnter meters to be converted: ");
               initValue = keyboard.nextDouble();
               convertedValue = convertMetersToFeet(initValue);
               outputResults(initValue, convertedValue, "meters", "feet");
           }
           else if (choice == 4)
           {
               System.out.print("\nEnter kilograms to be converted: ");
               initValue = keyboard.nextDouble();
               convertedValue = convertKilogramsToPounds(initValue);
               outputResults(initValue, convertedValue, "kilograms", "pounds");
           }
           
           System.out.println();

           //get next conversion choice
           choice = displayMenuAndGetChoice();
        }
        System.out.println("End of program.");
    }

    public static int displayMenuAndGetChoice()
    {
        Scanner keyboard = new Scanner(System.in);
        int choice;

        System.out.println("Please choose from the following menu:");
        System.out.println("1. Convert feet to meters");
        System.out.println("2. Convert pounds to kilograms");
        System.out.println("3. Convert meters to feet");
        System.out.println("4. Convert kilograms to pounds");
        System.out.println("5. Quit the program");

        choice = keyboard.nextInt();
        while (choice < 1 || choice > 5)
        {
            System.out.print("Valid choices are 1-5. Please re-enter: ");
            choice = keyboard.nextInt();
        }
        return choice;
    }

    //this method should return the number of meters equivalent to the parameter feet
    public static double convertFeetToMeters(double feet)
    {
        double meter;
        meter = feet * 0.3048;
        return meter;
    }

    //this method should return the number of kilograms equivalent to the parameter pounds
    public static double convertPoundsToKilograms(double pounds)
    {
        double kilograms;
        kilograms = pounds / 2.205;
        return kilograms;
    }

    
    //write the full implementation of the convertMetersToFeet method
    public static double convertMetersToFeet(double meter)
    {
        double feet;
        feet = meter / 0.3048;
        return meter;
    }
    
    //write the full implementation of the convertKilogramsToPounds method
    public static double convertKilogramsToPounds(double kilograms)
    {
        double pounds;
        pounds = kilograms * 2.205;
        return pounds;
    }

    /*this method should output a statement in the following form:
             3.3 feet is equivalent to 1.00584 meters.
         (3.3 feet would be the original value and units; 1.00584 meters is the converted value and units)
        */
    public static void outputResults(double originalValue, double convertedValue,
                String originalUnits, String convertedUnits)
    {
	System.out.printf("%f %s is equivalent to %.5f %s", originalValue, originalUnits, convertedValue, convertedUnits);
        System.out.println();
    }

//2.5 pounds is equivalent to 1.13398 kilograms.

}
