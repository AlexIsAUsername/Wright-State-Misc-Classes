/**
* Alex Yeoh
* CS1180, Summer 2021
* Lab 1
*/


/**
 * This program uses the NetBeans IDE to create a java program and    
 * demonstrates input and output statements, and the use of variables.
*/
public class practice_io {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int num1, num2, sum;
        double value1, value2, product;
        
        System.out.println("Hello from Alex");
        System.out.println();
        
        // assigning values to addition variables
        num1 = 3;
        num2 = 10;
        sum = num1 + num2;
        
        // outputting the result from adding followed by a blank line
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum + ".");
        System.out.println();
        
        // assigning values to product variables
        value1 = 32.4;
        value2 = 17;
        product = value1 * value2;
        
        // outputting the result from products followed by a blank line
        System.out.printf("The product of %.1f and %.1f is %.2f\n", value1, value2, product);
        System.out.println();
        
        // outputting "End of program" followed by a blank line
        System.out.println("End of program");
        System.out.println();
    }
    
}
