package AlexYeoh_PracticeProblem3;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionalDivision {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int numerator = 0;
        int denominator = 0;
        int answer = 0;
        boolean done = false;

        //numerator input and check
        do{
            try{
                done = false;
                System.out.print("What is the numerator? ");
                numerator = userInput.nextInt();
                done = true;
            }
            catch(InputMismatchException e){
                System.out.println("Error: you must enter a whole number");
            }
            finally{
                userInput.nextLine();
            }
        }while (done == false);

        //denominator input and check
        do{
            try{
                done = false;
                System.out.print("What is the denominator? ");
                denominator = userInput.nextInt();
                answer = numerator / denominator;
                done = true;
            }
            catch(InputMismatchException e){
                System.out.println("Error: you must enter a whole number");
            }
            catch(ArithmeticException f){
                System.out.println("Error: the denominator can't be zero");
            }
            finally{
                userInput.nextLine();
            }
        }while (done == false);

        System.out.println(numerator + " / " + denominator + " = " + answer);
        userInput.close();

    }
    
}
