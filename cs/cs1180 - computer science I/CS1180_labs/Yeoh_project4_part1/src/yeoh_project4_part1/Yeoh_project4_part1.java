/**
 * @author Alex Yeoh
 * CS1180, Summer 2021
 * Project 4 part 1 */
package yeoh_project4_part1;

import java.util.Scanner;

/**
 * This program determines if a credit card number is valid. It will give you
 * experience manipulating strings, writing methods and, in part 2, using text
 * files
 */
public class Yeoh_project4_part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String cardNumberString, cardType;
        boolean checkNumbers, validityOfCard, checkSum;

        //user inputs credit card number
        System.out.println("Please enter the credit card number:");
        cardNumberString = keyboard.nextLine();
        cardNumberString = cardNumberString.replace(" ", ""); //replace spaces with nothing

        //ensures that the string only contains digits
        checkNumbers = onlyDigitsCheck(cardNumberString);
        while (!checkNumbers) {
            System.out.println("The credit card number must contain only the digits 0-9; please re-enter:");
            cardNumberString = keyboard.nextLine().replace(" ", "");
            checkNumbers = onlyDigitsCheck(cardNumberString);
        }

        //determining information about the card
        cardType = determineCardType(cardNumberString);
        validityOfCard = validityOfCard(cardNumberString, cardType);
        checkSum = checkSum(cardNumberString);

        //displaying information about the card
        System.out.println("The card number is " + cardNumberString);
        System.out.println("The card type is " + cardType);
        if (validityOfCard == true && checkSum == true) {
            System.out.println("The card number is valid");
        }
        else if (!"unknown".equals(cardType)) {
            System.out.println("The card number is not valid.");
        }
    }

    public static boolean onlyDigitsCheck(String creditCardNumbers) {
        for (int i = 0; i < creditCardNumbers.length(); i++) {
            if (!Character.isDigit(creditCardNumbers.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String determineCardType(String creditCardNumbers) {
        if (creditCardNumbers.charAt(0) == '4') {
            return "Visa card";
        } else if (creditCardNumbers.startsWith("51") || creditCardNumbers.startsWith("52")
                || creditCardNumbers.startsWith("53") || creditCardNumbers.startsWith("54")
                || creditCardNumbers.startsWith("55")) {
            return "MasterCard";
        } else if (creditCardNumbers.startsWith("34") || creditCardNumbers.startsWith("37")) {
            return "American Express";
        } else if (creditCardNumbers.startsWith("6011")) {
            return "Discover card";
        }
        return "unknown";

    }

    public static boolean validityOfCard(String creditCardNumbers, String cardType) {
        if (cardType.equals("Visa card")) {
            if (creditCardNumbers.length() == 13 || creditCardNumbers.length() == 16) {
                return true;
            }
        } else if (cardType.equals("MasterCard")) {
            if (creditCardNumbers.length() == 16) {
                return true;
            }
        } else if (cardType.equals("American Express")) {
            if (creditCardNumbers.length() == 15) {
                return true;
            }
        } else if (cardType.equals("Discover card")) {
            if (creditCardNumbers.length() == 16) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSum(String creditCardNumbers) {
        int doubledValue, sum = 0;
        if (creditCardNumbers.length() % 2 == 0) {
            for (int i = 0; i < creditCardNumbers.length(); i++) {

                if (i % 2 == 0) {
                    doubledValue = Character.getNumericValue(creditCardNumbers.charAt(i)) * 2;
                    if (doubledValue >= 10) {
                        doubledValue = doubledValue - 9;
                    }
                    sum = sum + doubledValue;
                } else {
                    sum = sum + Character.getNumericValue(creditCardNumbers.charAt(i));
                }
            }
        } else {
            for (int i = 0; i < creditCardNumbers.length(); i++) {

                if (i % 2 == 0) {
                    sum = sum + Character.getNumericValue(creditCardNumbers.charAt(i));
                } else {
                    doubledValue = Character.getNumericValue(creditCardNumbers.charAt(i)) * 2;
                    if (doubledValue >= 10) {
                        doubledValue = doubledValue - 9;
                    }
                    sum = sum + doubledValue;
                }
            }
        }
        return sum % 10 == 0;

    }

}
