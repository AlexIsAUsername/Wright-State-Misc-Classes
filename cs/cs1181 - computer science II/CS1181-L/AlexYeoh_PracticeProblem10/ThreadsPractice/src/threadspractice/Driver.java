package threadspractice;

public class Driver {

    public static void main(String[] args) throws Exception {
        
        OrderQueue orders = new OrderQueue();
        
        Thread tm = new Thread(new TaskMaster(orders));
        Thread w1 = new Thread(new Worker(orders, 1));
        Thread w2 = new Thread(new Worker(orders, 2));
        Thread w3 = new Thread(new Worker(orders, 3));
        
        tm.start();
        w1.start();
        w2.start();
        w3.start();
        
        tm.join();
        w1.join();
        w2.join();
        w3.join();
        System.out.println("Finished!");
    }

}
