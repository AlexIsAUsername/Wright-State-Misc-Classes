/**
 * @author Alex Yeoh
 * CS1180, Summer 2021
 * Project 3 */
package yeoh_project3;

/**
 * This program will provide practice using arrays and to introduce you to
 * methods.
 */
public class Yeoh_project3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array1 = new int[15];
        int[] array2 = new int[20];

        System.out.println("After calling fillArray, the arrays contain these elements:");
        fillArray(array1);
        fillArray(array2);

        printArray(array1);
        printArray(array2);
        System.out.println();

        System.out.println("\nTesting the swapFirstAndLast method");
        swapFirstAndLast(array1);
        swapFirstAndLast(array2);
        printArray(array1);
        printArray(array2);
        System.out.println();

        System.out.println("\nTesting the returnSecondLargest method");
        System.out.println("Second largest item in array 1 is: "
                + returnSecondLargest(array1));
        System.out.println("Second largest item in array 2 is: "
                + returnSecondLargest(array2));
        System.out.println();

        System.out.println("\nTesting the containsAdjacentDuplicates method");
        System.out.println("Array1 contains adjacent duplicate elements: "
                + containsAdjacentDuplicates(array1));
        System.out.println("Array2 contains adjacent duplicate elements: "
                + containsAdjacentDuplicates(array2));
        System.out.println();
        System.out.println("\nTesting the containsDuplicates method");
        System.out.println("Array1 contains duplicate elements: "
                + containsDuplicates(array1));
        System.out.println("Array2 contains duplicate elements: "
                + containsDuplicates(array2));
        System.out.println();

        System.out.println("\nTesting the shiftElements method");
        shiftElements(array1);
        shiftElements(array2);
        printArray(array1);
        printArray(array2);
        System.out.println();

        System.out.println("\nTesting the replaceEvens method");
        replaceEvens(array1);
        replaceEvens(array2);
        printArray(array1);
        printArray(array2);
        System.out.println();

        System.out.println("\nEnd of program\n");

    }

    //fills the array with random numbers between 1 and 50, inclusive
    public static void fillArray(int[] array) {
        for (int fill = 0; fill < array.length; fill++) {
            array[fill] = (int) (1 + Math.random() * 50);
        }
    }

    //prints all items in the array on a single line, with a blank line at the end
    public static void printArray(int[] array) {
        for (int counter = 0; counter < array.length; counter++) {
            System.out.print(array[counter] + "  ");
        }
        System.out.println();
    }

    //swaps the first item with the last item
    public static void swapFirstAndLast(int[] array) {
        int temp;
        temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

    //returns the second largest element in the array 
    public static int returnSecondLargest(int[] array) {
        int largest = 0, secondLargest = 0;
        for (int position = 0; position < array.length; position++) {
            if (array[position] > largest) {
                secondLargest = largest;
                largest = array[position];
            } else if (array[position] > secondLargest && array[position] != largest) {
                secondLargest = array[position];
            }
        }
        return secondLargest;
    }

    //returns true if the array contains duplicate adjacent elements, else false 
    public static boolean containsAdjacentDuplicates(int[] array) {
        for (int position = 0; position < array.length - 1; position++) {
            if (array[position] == array[position + 1]) {
                return true;
            }
        }
        return false;
    }

    //returns true if the array contains duplicate elements, else false
    public static boolean containsDuplicates(int[] array) {
        for (int position1 = 0; position1 < array.length - 1; position1++) {
            for (int position2 = position1 + 1; position2 < array.length; position2++) {
                if (array[position1] == array[position2]) {
                    return true;
                }
            }
        }
        return false;
    }

    //shifts all elements one position to the right and moves the last element 
    //into the first position
    public static void shiftElements(int[] array) {
        int currentNum, nextNum;
        currentNum = array[0];
        for (int position = 0; position < array.length - 1; position++) {
            nextNum = array[position + 1];
            array[position + 1] = currentNum;
            currentNum = nextNum;
        }
        array[0] = currentNum;
    }

    //replaces all even elements in the array with 0
    public static void replaceEvens(int[] array) {
        for (int position = 0; position < array.length; position++) {
            if (array[position] % 2 == 0) {
                array[position] = 0;
            }
        }
    }

}
