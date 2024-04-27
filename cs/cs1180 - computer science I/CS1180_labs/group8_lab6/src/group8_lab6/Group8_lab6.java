/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group8_lab6;

import java.util.Arrays;

/**
 *
 * @author alexyeoh
 */
public class Group8_lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double average;
        int sum = 0, lower = 0, higher = 0;
        int arraySize = (int)(2 + Math.random() * 19);
        int[] array;
        int[] lowerArray;
        int[] higherArray;
        
        //making the array and populating it
        array = new int[arraySize];
        for (int count = 0; count < array.length; count++){
            array[count] = (int)(10 + Math.random() * 41);
        }
        
        //getting the average of the array
        for (int count = 0; count < array.length; count++){
            sum = sum + array[count];
        }
        average = (double)sum / array.length;
        
        //making two new arrays for less than array and greater than array
        for (int count = 0; count < array.length; count++){
            if (array[count] < average)
                lower++;
            else if (array[count] > average)
                higher++;
        }
        lowerArray = new int[lower];
        higherArray = new int[higher];
        int lowerCount = 0, higherCount = 0;
        for (int count = 0; count < array.length; count++){
            if (array[count] < average){
                lowerArray[lowerCount] = array[count];
                lowerCount++;
            }
            else if (array[count] > average){
                higherArray[higherCount] = array[count];
                higherCount++;
            }
        }
        
        //displaying results
        System.out.println("The original array contains these elements: " + Arrays.toString(array));
        System.out.printf("The average of the values in the array is %.2f.", average);
        System.out.println();
        System.out.println("The array with values higher than the average is: " + Arrays.toString(higherArray));
        System.out.println("The array with values lower than the average is: " + Arrays.toString(lowerArray));
    }
    
}
