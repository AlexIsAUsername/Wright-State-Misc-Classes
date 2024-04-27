/**
* @author Alex Yeoh
* CS1180, Summer 2021
* Project 1 */

package yeoh_project1;

import java.util.Scanner;

/**
* This program will provide experience using input and output statements and performing calculations.
*/
public class Yeoh_project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declare constants
        final double SOCIAL_SECURITY_TAX = 0.062;
        final double FEDERAL_INCOME_TAX = 0.14;
        final double STATE_INCOME_TAX = 0.05;
        final double LOCAL_INCOME_TAX = 0.0175;
        
        //declare variables
        double grossPay, netPay, socialSecurityDeduction, federalIncomeTaxDeduction, 
                stateIncomeTaxDeduction, localIncomeTaxDeduction;
        String name;
        double hoursWorked, hourlyRate;
                
        //getting user input
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your full name: ");
        name = keyboard.nextLine();
        System.out.print("Please enter your hourly pay rate: ");
        hourlyRate = keyboard.nextDouble();
        System.out.print("Please enter the hours worked this pay period: ");
        hoursWorked = keyboard.nextDouble();
        System.out.println("");
        
        //calculating gross pay
        grossPay = hoursWorked * hourlyRate;
        
        //caculating deductions
        socialSecurityDeduction = grossPay * SOCIAL_SECURITY_TAX;
        federalIncomeTaxDeduction = grossPay * FEDERAL_INCOME_TAX;
        stateIncomeTaxDeduction = grossPay * STATE_INCOME_TAX;
        localIncomeTaxDeduction=grossPay * LOCAL_INCOME_TAX;
        
        //calculationg net pay
        netPay = grossPay - socialSecurityDeduction - federalIncomeTaxDeduction - 
                stateIncomeTaxDeduction - localIncomeTaxDeduction;
        
        //displaying results
        System.out.print("Employee Name: " + name);
        System.out.println("");
        System.out.printf("Pay rate: $%.2f", hourlyRate);
        System.out.println("");
        System.out.print("Hours worked: " + hoursWorked);
        System.out.println("\n");
        
        System.out.println("Gross pay: $" + grossPay);
        System.out.println("");
        
        System.out.println("Deductions:");
        System.out.printf("\tSocial Security: $%.2f", socialSecurityDeduction);
        System.out.println("");
        System.out.printf("\tFederal income tax: $%.2f", federalIncomeTaxDeduction);
        System.out.println("");
        System.out.printf("\tState income tax: $%.2f", stateIncomeTaxDeduction);
        System.out.println("");
        System.out.printf("\tLocal income tax: $%.2f", localIncomeTaxDeduction);
        System.out.println("\n");
        
        System.out.printf("Net pay: $%.2f", netPay);
        System.out.println("\n");
        
        
    }
    
}
