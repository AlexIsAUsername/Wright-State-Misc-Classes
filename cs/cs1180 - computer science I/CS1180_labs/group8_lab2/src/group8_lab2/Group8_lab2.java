/**
* @author Alex Yeoh
* CS1180, Summer 2021
* Lab 2 */
package group8_lab2;

import java.util.Scanner;

/**
 *
 * @author alexyeoh
 */
public class Group8_lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int COOKIES_PER_BATCH = 48;
        final double CUPS_PER_BATCH = 2.5;
        final int CUPS_PER_POUND_FLOUR = 4;
        double poundsAvaliable;
        double totalCups;
        int batchesMade;
        int cookiesMade;
        double leftoverCups;
        double leftoverPounds;
        
        //calculating the values
        System.out.print("How many pounds of flour are available? ");
        poundsAvaliable = keyboard.nextDouble();
        totalCups = poundsAvaliable * CUPS_PER_POUND_FLOUR;
        batchesMade = (int)(totalCups / CUPS_PER_BATCH);
        cookiesMade = batchesMade * COOKIES_PER_BATCH;
        leftoverCups = totalCups % CUPS_PER_BATCH;
        leftoverPounds = leftoverCups / CUPS_PER_POUND_FLOUR;
        
        //displaying the calculated information
        System.out.println();
        System.out.println("Number of cups of flour available: " + totalCups);
        System.out.println("Number of batches of cookies that can be baked: " + batchesMade);
        System.out.println("Total number of cookies that can be baked: " + cookiesMade);
        System.out.println("Cups of flour leftover: " + leftoverCups);
        System.out.println("Pounds of flour leftover: " + leftoverPounds);
    }
    
}