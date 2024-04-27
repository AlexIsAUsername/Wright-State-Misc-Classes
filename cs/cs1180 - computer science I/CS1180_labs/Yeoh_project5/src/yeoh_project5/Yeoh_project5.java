/**
 * @author Alex Yeoh
 * CS1180, Summer 2021
 * Project 5 */
package yeoh_project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This program manages a list of items. It uses classes, text files, and an
 * ArrayList.
 */
public class Yeoh_project5 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int menuChoice;
        Scanner keyboard = new Scanner(System.in);
        //making the array list and opening the file
        ArrayList<CharacterFramework> blankCharacters = new ArrayList();
        File characterData = new File("characters.txt");
        Scanner inputFile = new Scanner(characterData);
//        PrintWriter outputFile = new PrintWriter("characters.txt");

        //putting all character data from from characters.txt into the array list
        dataInput(inputFile, blankCharacters);

        //sorting list by character name
        Collections.sort(blankCharacters);

        //main menu interaction
        do {
            String name, race, theClass;
            int str, dex, con, inte, wis, cha;
            menuChoice = mainMenu(keyboard);
            keyboard.nextLine();
            //displaying the entire list of characters
            if (menuChoice == 1) {
                for (int i = 0; i < blankCharacters.size(); i++) {
                    System.out.println(blankCharacters.get(i));
                    System.out.println();
                }
            }
            //adding a character then resorting the list
            else if (menuChoice == 2) {
                System.out.print("Enter the Name: ");
                name = keyboard.nextLine();
                System.out.print("Enter the race: ");
                race = keyboard.nextLine();
                System.out.print("Enter the class: ");
                theClass = keyboard.nextLine();
                System.out.print("Enter the strength: ");
                str = keyboard.nextInt();
                System.out.print("Enter the dexterity: ");
                dex = keyboard.nextInt();
                System.out.print("Enter the constitution: ");
                con = keyboard.nextInt();
                System.out.print("Enter the intelligence: ");
                inte = keyboard.nextInt();
                System.out.print("Enter the wisdom: ");
                wis = keyboard.nextInt();
                System.out.print("Enter the charisma: ");
                cha = keyboard.nextInt();
                blankCharacters.add(new CharacterFramework(name, race, theClass, str, dex, con, inte, wis, cha));
                Collections.sort(blankCharacters);
                System.out.println();
            }
            //removing a character (no sorting necessary because the list is already sorted)
            else if (menuChoice == 3) {
                String characterRemoved;
                System.out.print("Enter the name of the character you'd like to remove: ");
                characterRemoved = keyboard.nextLine();
                for (int i = 0; i < blankCharacters.size(); i++) {
                    if (blankCharacters.get(i).getName().equalsIgnoreCase(characterRemoved)) {
                        blankCharacters.remove(i);
                        System.out.println(characterRemoved + " was successfully removed from the list.");
                        i = blankCharacters.size();
                        System.out.println();
                    }
                    else if (i == blankCharacters.size() - 1) {
                        System.out.println(characterRemoved + " was not found, action could not be completed.");
                        System.out.println();
                    }
                }
            }
            //modifying a stat on a given character
            else if (menuChoice == 4) {
                String characterModified;
                int statModified;
                System.out.print("Enter the name of the character you'd like to modify: ");
                characterModified = keyboard.nextLine();
                for (int i = 0; i < blankCharacters.size(); i++) {
                    if (blankCharacters.get(i).getName().equalsIgnoreCase(characterModified)) {
                        int anotherStat;
                        do {
                            statModified = modifyMenu(keyboard);
                            if (statModified == 1) {
                                System.out.print("New strength value: ");
                                blankCharacters.get(i).setStrength(keyboard.nextInt());
                            }
                            else if (statModified == 2) {
                                System.out.print("New dexterity value: ");
                                blankCharacters.get(i).setDexterity(keyboard.nextInt());
                            }
                            else if (statModified == 3) {
                                System.out.print("New constitution value: ");
                                blankCharacters.get(i).setConstitution(keyboard.nextInt());
                            }
                            else if (statModified == 4) {
                                System.out.print("New intelligence value: ");
                                blankCharacters.get(i).setIntelligence(keyboard.nextInt());
                            }
                            else if (statModified == 5) {
                                System.out.print("New wisdom value: ");
                                blankCharacters.get(i).setWisdom(keyboard.nextInt());
                            }
                            else {
                                System.out.print("New charisma value: ");
                                blankCharacters.get(i).setCharisma(keyboard.nextInt());
                            }
                            System.out.println("Would you like to edit another stat?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            anotherStat = keyboard.nextInt();
                        }
                        while (anotherStat == 1);
                        i = blankCharacters.size();
                        System.out.println();
                    }
                    else if (i == blankCharacters.size() - 1) {
                        System.out.println(characterModified + " was not found, action could not be completed.");
                        System.out.println();
                    }
                }
            }
            //displaying a random character
            else if (menuChoice == 5) {
                int characterViewed = (int) (Math.random() * blankCharacters.size());
                System.out.println(blankCharacters.get(characterViewed));
            }

        }
        //closing the main menu
        while (menuChoice != 6);

        //replacing the original file and closing the reader and writer
        PrintWriter outputFile = new PrintWriter("characters.txt");
        for (int i = 0; i < blankCharacters.size(); i++) {
            outputFile.println(blankCharacters.get(i).getName());
            outputFile.println(blankCharacters.get(i).getRace());
            outputFile.println(blankCharacters.get(i).getTheClass());
            outputFile.println(blankCharacters.get(i).getStrength());
            outputFile.println(blankCharacters.get(i).getDexterity());
            outputFile.println(blankCharacters.get(i).getConstitution());
            outputFile.println(blankCharacters.get(i).getIntelligence());
            outputFile.println(blankCharacters.get(i).getWisdom());
            outputFile.println(blankCharacters.get(i).getCharisma());
        }
        inputFile.close();
        outputFile.close();

    }

    /**
     * Inputs all the text file data into the array list
     *
     * @param inputFile - how the method reads the text file
     * @param blankCharacters - the array list where all the character
     * frameworks are saved to
     */
    public static void dataInput(Scanner inputFile, ArrayList blankCharacters) {
        while (inputFile.hasNext()) {
            blankCharacters.add(new CharacterFramework(inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine(), inputFile.nextInt(), inputFile.nextInt(), inputFile.nextInt(), inputFile.nextInt(), inputFile.nextInt(), inputFile.nextInt()));
            inputFile.nextLine();
        }
    }

    /**
     * Displays the main menu and asks the user to enter a valid input until the
     * user inputs a valid input
     *
     * @param keyboard - allows the method to read user input
     * @return the value entered by the user after ensuring it is a valid input.
     */
    public static int mainMenu(Scanner keyboard) {
        int userInput;
        System.out.println("Main Menu");
        System.out.println("1. Print the entire list");
        System.out.println("2. Add a character");
        System.out.println("3. Remove a character");
        System.out.println("4. Modify a character");
        System.out.println("5. View a random character");
        System.out.println("6. Exit the program");
        userInput = keyboard.nextInt();
        while (userInput < 1 || userInput > 6) {
            System.out.println(userInput + " is not a valid choice");
            System.out.print("Please enter a number between 1 and 6: ");
            userInput = keyboard.nextInt();
        }
        return userInput;
    }

    /**
     * Displays the modify character menu and asks the user to enter a valid
     * input until the user inputs a valid input provides valid input
     *
     * @param keyboard - allows the method to read user input
     * @return the value entered by the user after ensuring it is a valid input.
     */
    public static int modifyMenu(Scanner keyboard) {
        int menuChoice;
        System.out.println("Which stat would you like to change?");
        System.out.println("1. Strength");
        System.out.println("2. Dexterity");
        System.out.println("3. Constitution");
        System.out.println("4. Intelligence");
        System.out.println("5. Wisdom");
        System.out.println("6. Charisma");
        menuChoice = keyboard.nextInt();
        while (menuChoice < 1 || menuChoice > 6) {
            System.out.println(menuChoice + " is not a valid choice");
            System.out.print("Please enter a number between 1 and 6: ");
            menuChoice = keyboard.nextInt();
        }
        return menuChoice;
    }

}
