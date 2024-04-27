import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GeneticAlgorithm {

    /*
    Data for items.txt at a population size of 10 and 100 iterations
    Number of threads: 1
        Run 1: 3400: 1295ms
        Run 2: 3400: 1351ms
        Run 3: 3400: 1116ms
        Run 4: 3400: 1149ms
        Average fitness: 3400
    
    Number of threads: 2
        Run 1: 3400: 401ms
        Run 2: 3400: 371ms
        Run 3: 3400: 385ms
        Run 4: 3400: 366ms
        Average fitness: 3400

    Number of threads: 3
        Run 1: 3400: 411ms
        Run 2: 3400: 213ms
        Run 3: 3400: 223ms
        Run 4: 3400: 212ms
        Average fitness: 3400

    Number of threads: 4
        Run 1: 3400: 333ms
        Run 2: 3400: 188ms
        Run 3: 3400: 185ms
        Run 4: 3400: 179ms
        Average fitness: 3400
    
    */

    // takes the input file and converts it into items
    public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        File item = new File(filename);
        Scanner itemsData = new Scanner(item);
        while (itemsData.hasNext()) {
            String[] splittingItems = itemsData.nextLine().split(",");
            items.add(new Item(splittingItems[0], Double.parseDouble(splittingItems[1]),
                    Integer.parseInt(splittingItems[2].trim())));
        }
        itemsData.close();
        return items;
    }

    // makes an arraylist of type chromosome and populates it with randomly
    // included/excluded items
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(items));
        }
        return population;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int populationSize = 10;
        int numThreads = 10;
        int numIterations = 100;
        int blockSize = numIterations/numThreads;
        int leftOvers = numIterations%numThreads;
        long startTime = System.currentTimeMillis();

        // reading in the items
        ArrayList<Item> items = readData("items.txt");
        ArrayList<Chromosome> currentPopulation = initializePopulation(items, populationSize);
        
        // making the threads
        ArrayList<Chromosome> finalPopulation = new ArrayList<>();
        ArrayList<GeneticThread> allThreads = new ArrayList<>();
        for (int i = 0; i < numThreads; i++){
            if (i == numThreads - 1){
                allThreads.add(new GeneticThread(blockSize + leftOvers, currentPopulation, numThreads));
            }
            allThreads.add(new GeneticThread(blockSize, currentPopulation, numThreads));
            allThreads.get(i).start();
        }

        // joining the threads
        try{
            for (int i = 0; i < numThreads; i++){
                allThreads.get(i).join();
                finalPopulation.addAll(allThreads.get(i).getReturnedPopulation());
            }
        }
        catch (InterruptedException e){
            System.out.println("There was an InterruptedException");
        }
        
        Collections.sort(finalPopulation);
        long endTime = System.currentTimeMillis();
        System.out.print(finalPopulation.get(0).getFitness() + ": " + Long.valueOf(endTime-startTime) + "ms" + "\n");
    }
}
