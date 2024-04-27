/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexyeoh_exam1;

import java.util.Scanner;

/**
 *
 * @author alexyeoh
 */
public class AlexYeoh_Exam1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declarations and name
        int n = 0, upperA = 0, upperB = 0, notUpperAB = 0;
        char firstLetter;
        System.out.println("Alex Yeoh");
        
        //getting user input
        Scanner keyboard = new Scanner(System.in);
        while (n < 1 || n > 100){
            System.out.print("Enter a number between 1 and 100: ");
            n = keyboard.nextInt();
        }
        
        System.out.println("Enter " + n + " words:");
        for(int counter = 0; counter < n; counter++){
            firstLetter = keyboard.next().charAt(0);
            if (firstLetter == 'A')
                upperA += 1;
            else if (firstLetter == 'B')
                upperB += 1;
            else
                notUpperAB += 1;
        }
        
        //displaying results
        System.out.println("There are " + upperA + " words starting with a capital A");
        System.out.println("There are " + upperB + " words starting with a capital B");
        System.out.println("There are " + notUpperAB + " words not starting with either a capital A or B");
    }
    
}
