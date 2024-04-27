package AlexYeoh_PracticeProblem1;

public class BasketballPlayer implements Comparable<BasketballPlayer>{
    private String firstName;
    private String lastName;
    private double ppg; //points per game

    //constructors
    public BasketballPlayer(String firstName, String lastName, double ppg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ppg = ppg;
    }

    @Override
    public String toString(){
        return lastName + ", " + firstName + " (" + ppg + ")";
    }

    @Override
    public int compareTo(BasketballPlayer o) {
        if (this.ppg == o.ppg) {
            if (this.lastName.equals(lastName)) {
                return this.firstName.compareToIgnoreCase(o.firstName);
            }
            else {
                return this.lastName.compareToIgnoreCase(o.lastName);
            }
        }
        else if (this.ppg > o.ppg) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
