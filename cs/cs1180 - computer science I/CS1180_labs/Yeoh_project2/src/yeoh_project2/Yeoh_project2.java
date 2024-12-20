/**
* @author Alex Yeoh
* CS1180, Summer 2021
* Project 2 */

package yeoh_project2;

import java.util.Scanner;

/**
* This program will provide experience using decision statements and loops.
*/

public class Yeoh_project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare variables
        String band1, band2, band3;
        char rerun;
        int valueBand1, valueBand2, valueBand3;
        int ohms, multiplier;
        double kiloOhms;
        Scanner keyboard = new Scanner(System.in);
        
        //getting the entire project to run again (figure out how to get it to work)
        do{
            //getting user input
            System.out.print("Enter the color of band 1: ");
            band1 = keyboard.nextLine();
            while (!(band1.equalsIgnoreCase("black") || band1.equalsIgnoreCase("brown") || 
                    band1.equalsIgnoreCase("red") || band1.equalsIgnoreCase("orange") || 
                    band1.equalsIgnoreCase("yellow") || band1.equalsIgnoreCase("green") || 
                    band1.equalsIgnoreCase("blue") || band1.equalsIgnoreCase("violet") || 
                    band1.equalsIgnoreCase("grey") || band1.equalsIgnoreCase("white"))){
                System.out.print("That is not a valid color. Re-enter the color of band 1: ");
                band1 = keyboard.nextLine();
            }
            System.out.print("Enter the color of band 2: ");
            band2 = keyboard.nextLine();
            while (!(band2.equalsIgnoreCase("black") || band2.equalsIgnoreCase("brown") || 
                    band2.equalsIgnoreCase("red") || band2.equalsIgnoreCase("orange") || 
                    band2.equalsIgnoreCase("yellow") || band2.equalsIgnoreCase("green") || 
                    band2.equalsIgnoreCase("blue") || band2.equalsIgnoreCase("violet") || 
                    band2.equalsIgnoreCase("grey") || band2.equalsIgnoreCase("white"))){
                System.out.print("That is not a valid color. Re-enter the color of band 2: ");
                band2 = keyboard.nextLine();
            }
            System.out.print("Enter the color of band 3: ");
            band3 = keyboard.nextLine();
            while (!(band3.equalsIgnoreCase("black") || band3.equalsIgnoreCase("brown") || 
                    band3.equalsIgnoreCase("red") || band3.equalsIgnoreCase("orange") || 
                    band3.equalsIgnoreCase("yellow") || band3.equalsIgnoreCase("green") || 
                    band3.equalsIgnoreCase("blue") || band3.equalsIgnoreCase("violet") || 
                    band3.equalsIgnoreCase("grey") || band3.equalsIgnoreCase("white"))){
                System.out.print("That is not a valid color. Re-enter the color of band 3: ");
                band3 = keyboard.nextLine();
            }

            //converting from color to number
            if (band1.equalsIgnoreCase("black"))
                valueBand1 = 0;
            else if (band1.equalsIgnoreCase("brown"))
                valueBand1 = 1;
            else if (band1.equalsIgnoreCase("red"))
                valueBand1 = 2;
            else if (band1.equalsIgnoreCase("orange"))
                valueBand1 = 3;
            else if (band1.equalsIgnoreCase("yellow"))
                valueBand1 = 4;
            else if (band1.equalsIgnoreCase("green"))
                valueBand1 = 5;
            else if (band1.equalsIgnoreCase("blue"))
                valueBand1 = 6;
            else if (band1.equalsIgnoreCase("violet"))
                valueBand1 = 7;
            else if (band1.equalsIgnoreCase("grey"))
                valueBand1 = 8;
            else
                valueBand1 = 9;

            if (band2.equalsIgnoreCase("black"))
                valueBand2 = 0;
            else if (band2.equalsIgnoreCase("brown"))
                valueBand2 = 1;
            else if (band2.equalsIgnoreCase("red"))
                valueBand2 = 2;
            else if (band2.equalsIgnoreCase("orange"))
                valueBand2 = 3;
            else if (band2.equalsIgnoreCase("yellow"))
                valueBand2 = 4;
            else if (band2.equalsIgnoreCase("green"))
                valueBand2 = 5;
            else if (band2.equalsIgnoreCase("blue"))
                valueBand2 = 6;
            else if (band2.equalsIgnoreCase("violet"))
                valueBand2 = 7;
            else if (band2.equalsIgnoreCase("grey"))
                valueBand2 = 8;
            else
                valueBand2 = 9;

            if (band3.equalsIgnoreCase("black"))
                valueBand3 = 0;
            else if (band3.equalsIgnoreCase("brown"))
                valueBand3 = 1;
            else if (band3.equalsIgnoreCase("red"))
                valueBand3 = 2;
            else if (band3.equalsIgnoreCase("orange"))
                valueBand3 = 3;
            else if (band3.equalsIgnoreCase("yellow"))
                valueBand3 = 4;
            else if (band3.equalsIgnoreCase("green"))
                valueBand3 = 5;
            else if (band3.equalsIgnoreCase("blue"))
                valueBand3 = 6;
            else if (band3.equalsIgnoreCase("violet"))
                valueBand3 = 7;
            else if (band3.equalsIgnoreCase("grey"))
                valueBand3 = 8;
            else
                valueBand3 = 9;

            //calculating resistance
            multiplier = 1;
            for (int rounds = 0; rounds < valueBand3; rounds++)
                multiplier = multiplier * 10;
            ohms = (valueBand1 * 10 + valueBand2) * multiplier;
            kiloOhms = ohms / 1000.0;

            //displaying results
            System.out.printf("The resistance index is %,d ohms or %,.3f kilo-ohms.", ohms, kiloOhms);
            System.out.println("");


            System.out.println("Do you want to decode another resistor (y/n)?");
            rerun = keyboard.nextLine().charAt(0);
            
        }
        while (rerun == 'y');
        
        
    }
    
}
