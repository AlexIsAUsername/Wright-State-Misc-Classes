import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneticThread extends Thread {
    private static Random rng = new Random();
    private int numIterations;
    private ArrayList<Chromosome> currentPopulation = new ArrayList<>();
    private int numThreads;
    ArrayList<Chromosome> returnedPopulation = new ArrayList<>();
    
    public GeneticThread(int numIterations, ArrayList<Chromosome> currentPopulation, int numThreads){
        this.numIterations = numIterations;
        this.currentPopulation = currentPopulation;
        this.numThreads = numThreads;
    }

    public void run() {
        int populationSize = currentPopulation.size();
        ArrayList<Chromosome> nextPopulation = new ArrayList<>();
        
        // basically the the entierty of geneticalgorithm.java
        for (int iterations = 0; iterations <= numIterations; iterations++) {
            // adds current population into next population
            nextPopulation.addAll(currentPopulation);

            // random pairing (removes them as it goes to prevent individuals from pairing
            // twice)
            for (int i = currentPopulation.size(); i > 0; i = i - 2) {
                int pairOne = rng.nextInt(i);
                int pairTwo = rng.nextInt(i);
                while (pairTwo == pairOne) {
                    pairTwo = rng.nextInt(i);
                }
                nextPopulation.add(currentPopulation.get(pairOne).crossover(currentPopulation.get(pairTwo)));
                if (pairOne > pairTwo) {
                    currentPopulation.remove(pairOne);
                    currentPopulation.remove(pairTwo);
                } else {
                    currentPopulation.remove(pairTwo);
                    currentPopulation.remove(pairOne);

                }

            }

            // mutation of 10% (integer division) individuals
            int numberMutated = nextPopulation.size() / 10;
            for (int i = 0; i < numberMutated; i++) {
                int mutateRNG = rng.nextInt(nextPopulation.size());
                nextPopulation.get(mutateRNG).mutate();
            }

            // sorting by fitness and adds them into the current population
            Collections.sort(nextPopulation);
            for (int i = 0; i < 10; i++) {
                currentPopulation.add(nextPopulation.get(i));
            }

        }

        // makes an arraylist with the best from the thread to pass back to main
        Collections.sort(nextPopulation);
        for (int i = 0; i < populationSize/numThreads; i++){
            returnedPopulation.add(nextPopulation.get(i));
        }
    }

    public ArrayList<Chromosome> getReturnedPopulation() {
        return returnedPopulation;
    }
}
