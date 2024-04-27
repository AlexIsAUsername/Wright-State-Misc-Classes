/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Group8_lab7;

import java.util.Scanner;

/**
 *
 * @author alexyeoh
 */
public class Group8_lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int numStudents, numTests;
        int aboveAverage = 0, belowAverage = 0;
        double sum;
        double totalAverage = 0;
        String[] studentNames;
        double[][] tests;
        double[] averages;

        //getting number of students and tests
        System.out.print("Enter the number of students for which scores will be averaged: ");
        numStudents = keyboard.nextInt();
        while (numStudents <= 1) {
            System.out.print("Number of students must be greater than 1; please re-enter: ");
            numStudents = keyboard.nextInt();
        }
        System.out.print("Enter the number of test scores to be averaged: ");
        numTests = keyboard.nextInt();
        while (numTests <= 1) {
            System.out.print("Number of test scores to be averaged must be greater than 1; please re-enter: ");
            numTests = keyboard.nextInt();
        }
        System.out.println();

        //initilizing arrays
        studentNames = new String[numStudents];
        tests = new double[numTests][numStudents];
        averages = new double[numStudents];

        //getting user inputs
        for (int a = 0; a < numStudents; a++) {
            keyboard.nextLine();
            System.out.print("Enter the student's name: ");
            studentNames[a] = keyboard.nextLine();
            System.out.print("Enter " + numTests + " test scores for " + studentNames[a] + ": ");
            for (int b = 0; b < numTests; b++) {
                tests[b][a] = keyboard.nextFloat();
            }
        }

        //calculating averages
        for (int a = 0; a < numStudents; a++) {
            sum = 0;
            for (int b = 0; b < numTests; b++) {
                sum += tests[b][a];
            }
            averages[a] = sum / numTests;
        }
        for (int a = 0; a < numStudents; a++) {
            totalAverage += averages[a];
        }
        totalAverage = totalAverage / numStudents;

        //counting above and below average
        for (int a = 0; a < numStudents; a++) {
            if (averages[a] > totalAverage) {
                aboveAverage += 1;
            } else if (averages[a] < totalAverage) {
                belowAverage += 1;
            }
        }

        //outputting data
        for (int a = 0; a < numStudents; a++) {
            System.out.println("Name: " + studentNames[a]);
            System.out.print("Test scores: ");
            for (int b = 0; b < numTests; b++) {
                System.out.printf("%.1f ", tests[b][a]);
            }
            System.out.println();
            System.out.printf("Average: %.1f", averages[a]);
            System.out.println("\n");
        }
        System.out.printf("The average test score for all students is %.1f.", totalAverage);
        System.out.println();
        System.out.println(aboveAverage + " students had an average above the class average.");
        System.out.println(belowAverage + " students had an average below the class average.");
    }
}
