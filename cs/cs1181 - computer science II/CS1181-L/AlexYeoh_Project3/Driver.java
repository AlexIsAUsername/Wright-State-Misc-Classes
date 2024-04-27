import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver {
    public static void main(String[] Args) throws FileNotFoundException{
        // variables changed to test the simulation for different lane combinations
        int regularLane = 4;
        int expressLane = 2;

        double simClock = 0.0;
        double totalWaitTime = 0;
        File arrival = new File("arrival medium.txt");
        Scanner fileReader = new Scanner(arrival);
        int customerNumber = 0;
        PriorityQueue<Customer> eventQueue = new PriorityQueue<>();
        
        // reading in customer data and putting them into a queue
        while (fileReader.hasNext()){
            String[] customers = fileReader.nextLine().split("\\s");
            eventQueue.offer(new Customer(Double.parseDouble(customers[0]), Integer.parseInt(customers[1]), Double.parseDouble(customers[2]), customerNumber));
            customerNumber++;
        }// Priority queue for customer entry is working, they are sorted by entry time
        fileReader.close();

        // makes lanes
        PriorityQueue<Lane> laneQueue = new PriorityQueue<>();
        for (int i = 0; i < regularLane; i++){
            laneQueue.offer(new Lane(laneQueue.size()));
        }
        for (int i = 1; i <= expressLane; i++){
            laneQueue.offer(new ExpressLane(laneQueue.size()));
        }

        // main logic for the events
        while (eventQueue.size() > 0){
            Customer currentEvent = eventQueue.poll(); // pulls the customer who's event is next
        // logic for when the customer is entering the store
        if (currentEvent.getTimeUntilNextEvent() == currentEvent.getEntryTime()){
            simClock = currentEvent.getTimeUntilNextEvent();
            System.out.printf("%.2f: Arrival Customer %d\n", simClock, currentEvent.getCustomerNumber());
            currentEvent.setTimeUntilNextEvent();
            eventQueue.offer(currentEvent);
        }
        // logic for when the customer is entering the checkout lane
        else if (currentEvent.getTimeUntilNextEvent() == currentEvent.getToCheckoutTime() + currentEvent.getEntryTime() && currentEvent.getLaneNumber() == null){
            simClock = currentEvent.getTimeUntilNextEvent();
                System.out.printf("%.2f: Finished Shopping Customer %d\n", simClock, currentEvent.getCustomerNumber());
                Lane currentLane;
                if (currentEvent.getItems() > 12){
                    PriorityQueue<Lane> tempLanes = new PriorityQueue<>();
                    while (laneQueue.peek().getItemLimit() > 0){
                        tempLanes.offer(laneQueue.poll());
                    }
                    currentLane = laneQueue.poll();
                    System.out.println("More than 12, chose Lane " + currentLane.getLaneNumber() + " (" + currentLane.size() + ")");
                    currentEvent.setPeopleAhead(currentLane.size());
                    currentEvent.setLaneNumber(currentLane.getLaneNumber());
                    currentEvent.setWaitTime(currentLane.getWaitTime());
                    currentLane.add(currentEvent);
                    currentEvent.setTimeUntilNextEvent(currentLane.getWaitTime());
                    laneQueue.offer(currentLane);
                    while (tempLanes.size() > 0){
                        laneQueue.offer(tempLanes.poll());
                    }
                }
                else{
                    currentLane = laneQueue.poll();
                    System.out.println("12 or fewer, chose Lane " + currentLane.getLaneNumber() + " (" + currentLane.size() + ")");
                    currentEvent.setPeopleAhead(currentLane.size());
                    currentEvent.setLaneNumber(currentLane.getLaneNumber());
                    currentEvent.setWaitTime(currentLane.getWaitTime());
                    currentLane.add(currentEvent);
                    currentEvent.setTimeUntilNextEvent(currentLane.getWaitTime());
                    laneQueue.offer(currentLane);
                }
                totalWaitTime += currentEvent.getWaitTime();
                eventQueue.offer(currentEvent);
        }
        // logic for when the customer is leaving the checkout lane
        else {
            simClock = currentEvent.getTimeUntilNextEvent();
            PriorityQueue<Lane> tempLanes = new PriorityQueue<>();
            Lane currentLane = null;
            while (currentLane == null){
                if (currentEvent.getLaneNumber() == laneQueue.peek().getLaneNumber()){
                    currentLane = laneQueue.peek();
                    currentLane.remove(0);
                    while (tempLanes.size() > 0){
                        laneQueue.offer(tempLanes.poll());
                    }
                }
                else{
                    tempLanes.offer(laneQueue.poll());
                }
            }
            laneQueue.offer(currentLane);
            System.out.printf("%.2f: Finished Checkout Customer %d on Lane %d (%d) (%.2f minute wait, %d people in line -- finished shopping at %.2f, got to the front of the line at %.2f)\n", simClock, currentEvent.getCustomerNumber(), currentEvent.getLaneNumber(), currentLane.size(), currentEvent.getWaitTime(), currentEvent.getPeopleAhead(), currentEvent.getToCheckoutTime()+currentEvent.getEntryTime(), currentEvent.getToCheckoutTime()+currentEvent.getEntryTime()+currentEvent.getWaitTime());
        }
    }
    System.out.printf("Average wait time: %.2f\nTotal customers: %d\n", totalWaitTime/(customerNumber), customerNumber);
}
}