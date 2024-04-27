/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group8_lab10;

import java.util.Scanner;

/**
 *
 * @author alexyeoh
 */
public class Group8_lab10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //empty argument for phone1
        Phone phone1 = new Phone();
        //displaying phone1 information using accessors
        System.out.println("The manufacturer of the phone is " + phone1.getManufacturer() + ".");
        System.out.println("The model of the phone is " + phone1.getModel() + ".");
        System.out.printf("The cost of the phone is $%.2f", phone1.getCost());
        System.out.println("\n");
        
        //replacing phone1
        Scanner keyboard = new Scanner(System.in);
        String manufacturer;
        String model;
        double cost;
        //getting user input for new phone1 details
        System.out.print("Enter the manufacturer of the phone: ");
        manufacturer = keyboard.nextLine();
        System.out.print("Enter the model of the phone: ");
        model = keyboard.nextLine();
        System.out.print("Enter the cost of the phone: ");
        cost = keyboard.nextDouble();
        //setting the new information for phone1
        phone1.setManufacturer(manufacturer);
        phone1.setModel(model);
        phone1.setCost(cost);
        //displaying new phone1 information
        System.out.println(phone1);
        System.out.println();
        
        //eating the whitespace after entering the new cost of phone1
        keyboard.nextLine();
        
        //phone2 stuff
        //getting user input for phone details
        System.out.print("Enter the manufacturer of the phone: ");
        manufacturer = keyboard.nextLine();
        System.out.print("Enter the model of the phone: ");
        model = keyboard.nextLine();
        System.out.print("Enter the cost of the phone: ");
        cost = keyboard.nextDouble();
        //using a constructor to set the information for phone2
        Phone phone2 = new Phone(manufacturer, model, cost);
        //displaying phone2 information
        System.out.println(phone2);
        System.out.println();
        
        
    }
    
}
