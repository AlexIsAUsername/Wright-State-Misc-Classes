package AlexYeoh_PracticeProblem1;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {
        BasketballPlayer p1 = new BasketballPlayer ("Jay", "Smith", 12.7);
        BasketballPlayer p2 = new BasketballPlayer ("DeShaun", "Smith", 12.7);
        BasketballPlayer p3 = new BasketballPlayer ("DeShaun", "Taylor", 18.1);

        ArrayList <BasketballPlayer> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        
        System.out.println(players);
        Collections.sort(players);
        System.out.println(players);
    }
    

}
