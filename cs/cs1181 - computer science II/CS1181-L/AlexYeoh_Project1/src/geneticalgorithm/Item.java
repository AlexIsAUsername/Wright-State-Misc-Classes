/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithm;

/**
 *
 * @author alexyeoh
 */
class Item {

    private final String name;
    private final double weight;
    private final int value;
    private boolean included;

    // constructors
    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        included = false;
    }

    public Item(Item other) {
        this.name = other.name;
        this.weight = other.getWeight();
        this.value = other.getValue();
        this.included = other.isIncluded();
    }

    // getters
    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public boolean isIncluded() {
        return included;
    }

    // setter for included
    public void setIncluded(boolean included) {
        this.included = included;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " lbs, $" + value + ")";
    }
}
