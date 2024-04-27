/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group8_lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author alexyeoh
 */
public class Group8_lab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String filename;
        filename = createFile();
        System.out.println();
        outputFileContents(filename);
    }
    
    //comment
    public static String createFile() throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        String filename, text;
        PrintWriter newFile;
        System.out.print("Please enter the name for the file to be created: ");
        filename = keyboard.nextLine();
        newFile = new PrintWriter(filename);
        System.out.println("Please enter a few sentences:");
        text = keyboard.nextLine();
        newFile.println(text);
        newFile.close();
        return filename;
    }
    
    //comment
    public static void outputFileContents(String filename) throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        int wordToCapitalize, counter = 0;
        String word;
        File previousFile;
        System.out.print("Enter an integer value to determine which words will be capitalized: ");
        wordToCapitalize = keyboard.nextInt();
        previousFile = new File(filename);
        Scanner inputFile = new Scanner(previousFile);
        while (inputFile.hasNext()){
            word = inputFile.next();
            counter++;
            if (counter % wordToCapitalize == 0)
                word = word.toUpperCase();
            System.out.print(word + " ");
        }
        inputFile.close();
    }
}
