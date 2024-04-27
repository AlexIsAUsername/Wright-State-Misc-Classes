import java.util.ArrayList;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {
    // constructor
    public Chromosome(ArrayList<Item> items) {
        this.addAll(items);
    }
    
    // converts chromosome to item array list
    public ArrayList<Item> toItemsArray() {
        ArrayList<Item> items = this;
        return items;
    }

    // calculates the fitness for a chromosome
    public int getFitness() {
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
