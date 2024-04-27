import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] Args) throws InterruptedException{
        Scanner keyboard = new Scanner(System.in);
        int numThreads;
        int maxNum;
        int numPrimes = 0;

        System.out.print("Number of threads to use: ");
        numThreads = keyboard.nextInt();
        System.out.println();
        System.out.print("Final number (exclusive): ");
        maxNum = keyboard.nextInt();
        long startTime = System.currentTimeMillis();
        keyboard.close();

        int sections = maxNum/numThreads;
        int leftover = maxNum%numThreads;

        ArrayList<PrimeThread> threads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++){
            if (i == numThreads - 1){
                threads.add(new PrimeThread(i * sections, (i + 1) * sections + leftover));
            }
            threads.add(new PrimeThread(i * sections, (i + 1) * sections));
            threads.get(i).start();
        }

        for (int i = 0; i < numThreads; i++){
            threads.get(i).join();
            numPrimes += threads.get(i).getPrimeCount();
        }
        long endTime = System.currentTimeMillis();

        System.out.print(numPrimes + ": " + Long.valueOf(endTime-startTime) + "\n");
    }
    // 4 threads is the fastest with a total time of 1017 miliseconds
}
