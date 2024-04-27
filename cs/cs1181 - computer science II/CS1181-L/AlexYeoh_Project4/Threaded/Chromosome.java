import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {

    private static Random rng = new Random();

    // constructors
    public Chromosome() {
    }

    public Chromosome(ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item itemCopy = new Item(items.get(i));
            int includedRNG = rng.nextInt(10) + 1;
            if (includedRNG > 0 && includedRNG < 6) {
                itemCopy.setIncluded(true);
            } else {
                itemCopy.setIncluded(false);
            }
            this.add(itemCopy);
        }
    }

    // randomizes which parent's version of Item the child will get
    public Chromosome crossover(Chromosome other) {
        Chromosome child = new Chromosome();
        for (int i = 0; i < this.size(); i++) {
            int crossoverRNG = rng.nextInt(10) + 1;
            if (crossoverRNG > 0 && crossoverRNG < 6) {
                child.add(new Item(this.get(i)));
            } else {
                child.add(new Item(other.get(i)));
            }
        }
        return child;

    }

    // mutates 10% of the 10% of chromosomes passed in
    public void mutate() {
        for (int i = 0; i < this.size(); i++) {
            int mutateRNG = rng.nextInt(10) + 1;
            if (mutateRNG == 1) {
                if (this.get(i).isIncluded() == true) {
                    this.get(i).setIncluded(false);
                } else {
                    this.get(i).setIncluded(true);
                }

            }

        }
    }

    // calculates the fitness for a chromosome
    public int getFitness() {

        int dummy = 0;
        for (int i=0; i<this.size()*1000; i++) {
            dummy += i;
        }// the rest of the method is the same as before

        double totalWeight = 0;
        int totalScore = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).isIncluded()) {
                totalWeight += this.get(i).getWeight();
                totalScore += this.get(i).getValue();
            }
        }
        if (totalWeight > 10) {
            return 0;
        } else {
            return totalScore;
        }
    }

    @Override
    public int compareTo(Chromosome other) {
        return other.getFitness() - this.getFitness(); 
    }

    @Override
    public String toString() {
        String fullString = "";
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).isIncluded()) {
                fullString += this.get(i).toString();
                fullString += "\n";
            }
        }
        fullString += "The fitness is ";
        fullString += Integer.toString(this.getFitness());
        fullString += "\n";
        return fullString;
    }

}
