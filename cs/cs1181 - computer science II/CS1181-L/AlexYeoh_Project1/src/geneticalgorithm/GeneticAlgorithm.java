/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GeneticAlgorithm {

    //takes the input file and converts it into items
    public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        File item = new File(filename);
        Scanner itemsData = new Scanner(item);
        while (itemsData.hasNext()) {
            String[] splittingItems = itemsData.nextLine().split(",");
            items.add(new Item(splittingItems[0], Double.parseDouble(splittingItems[1]), Integer.parseInt(splittingItems[2].trim())));
        }
        itemsData.close();
        return items;
    }

    //makes an arraylist of type chromosome and populates it with randomly included/excluded items
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(items));
        }
        return population;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Random rng = new Random();

        //reading in the items
        ArrayList<Item> items = readData("items.txt");
        ArrayList<Chromosome> currentPopulation = initializePopulation(items, 100);
        ArrayList<Chromosome> nextPopulation = new ArrayList<>();

        for (int iterations = 1; iterations <= 1000; iterations++) {
            //adds current population into next population
            for (int i = 0; i < 10; i++) {
                nextPopulation.add(currentPopulation.get(i));
            }

            //random pairing (removes them as it goes to prevent individuals from pairing twice)
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
                }
                else {
                    currentPopulation.remove(pairTwo);
                    currentPopulation.remove(pairOne);

                }

            }

            //mutation of 10% (integer division) individuals
            int numberMutated = nextPopulation.size() / 10;
            for (int i = 0; i < numberMutated; i++) {
                int mutateRNG = rng.nextInt(nextPopulation.size());
                nextPopulation.get(mutateRNG).mutate();
            }

            //sorting by fitness and adds them into the current population then clears next population
            Collections.sort(nextPopulation);
            for (int i = 0; i < 10; i++) {
                currentPopulation.add(nextPopulation.get(i));
            }
            //nextPopulation.clear();

        }
        Collections.sort(currentPopulation);
        System.out.print(currentPopulation.get(0).getFitness());

    }
}
