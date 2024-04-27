import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BruteForce {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> items = readData("items.txt");
        System.out.println(getOptimalSet(getAllSets(items)));
    }

    // sorts the array list of all combinations and returns the best
    public static ArrayList<Item> getOptimalSet(ArrayList<Chromosome> chromosomes){
        ArrayList<Chromosome> allSets = chromosomes;
        Collections.sort(allSets);
        return allSets.get(0);
    }

    public static ArrayList<Chromosome> getAllSets(ArrayList<Item> items){
        ArrayList<Chromosome> allSets = new ArrayList<>();

        if (items.size() > 10){
            throw new IllegalArgumentException();
        }

        if (items.size() == 0) {
            return allSets;
        }

        // makes two chromosomes for when there is only one item (once for item being included and once otherwise) 
        if (items.size() == 1) {
            allSets.add(new Chromosome(items));
            ArrayList<Item> temp = new ArrayList<>();
            temp.add(new Item(items.get(0)));
            temp.get(0).setIncluded(true);
            allSets.add(new Chromosome(temp));
            return allSets;
        }

        for (int i=0; i<items.size(); i++) {
            ArrayList<Item> aSet = new ArrayList<>();
            Item item = new Item(items.get(i));
            // makes the array list that gets passed in for recursion
            for (int j = i+1; j < items.size(); j++){
                aSet.add(items.get(j));
            }
            ArrayList<Chromosome> temp = getAllSets(aSet);
            // takes every element in temp and adds back in item (once for item being included and once otherwise) 
            for (Chromosome t: temp) {
                t.add(item);
                allSets.add(new Chromosome(t.toItemsArray()));
            }
            item.setIncluded(true);
            for (Chromosome t: temp) {
                allSets.add(new Chromosome(t.toItemsArray()));
            }
        }

        return allSets;
    }

    // reading in the items
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
}
