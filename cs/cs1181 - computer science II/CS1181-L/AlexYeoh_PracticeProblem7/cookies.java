import java.util.*;
public class cookies{
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Scanner keyboard = new Scanner(System.in);
        int numCookies;
        String Cookies;
        String[] cookiesSeperate;
        int minSweetness;
        int newCookie;
        int operations = 0;
        System.out.print("How many cookies are there? ");
        numCookies = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("What are the current sweetness values of these " + numCookies + " cookies? ");
        Cookies = keyboard.nextLine();
        cookiesSeperate = Cookies.split(" ");
        for (int i = 0; i < numCookies; i++){
            queue.offer(Integer.valueOf(cookiesSeperate[i]));
        }
        System.out.print("What is the minimum desired sweetness? ");
        minSweetness = keyboard.nextInt();
        try{
            while (queue.peek() < minSweetness){
            newCookie = queue.poll() + queue.poll() * 2;
            queue.offer(newCookie);
            operations++;
            }
        } catch(Exception e){
            operations = -1;
        }
        
        System.out.println("The number of operations required to achieve this is " + operations + ".");
    }
}