package threadspractice;

import java.util.ArrayDeque;
import java.util.Queue;

class OrderQueue {
    
    private Queue<Task> orders;
    private boolean moreOrdersComing;
    
    public OrderQueue() {
        orders = new ArrayDeque<>();
        moreOrdersComing = true;
    }
    
    public synchronized void createTask(String label, int timeToComplete) {
        if (orders.size() == 5){
            try {
		wait();	
            } catch (Exception e) {
            }
        }
        orders.offer(new Task(label, timeToComplete));
        notifyAll();
    }
    
    public synchronized Task acceptTask() {
        while (orders.isEmpty()) {
            // looping until there is a task in the queue to accept
            System.out.println("Waiting...");
            try {
		wait();	
            } catch (Exception e) {
            }
        }
        notifyAll();
        return orders.poll();
    }
    
    public void setNoMoreOrders() {
        moreOrdersComing = false;
    }
    
    public boolean weAreDone() {
        return orders.isEmpty() && !moreOrdersComing;
    }
}