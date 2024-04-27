import java.util.ArrayList;

public class Lane extends ArrayList<Customer> implements Comparable<Lane>{
    private Double waitTime = 0.0;
    private Integer laneNumber;
    private Integer itemLimit = 0;

    Lane(int laneNumber){
        waitTime = 0.0;
        this.laneNumber = laneNumber;
    }

    Lane(Customer person){
        this.add(person);
    }

    public void setWaitTime(Double waitTime) {
        this.waitTime = waitTime;
    }

    public void changeWaitTime() {
        double waitTime = 0;
        for (int i = 0; i < this.size(); i++){
            waitTime += this.get(i).getItems() * 0.05 + 2;
        }
        this.setWaitTime(waitTime);
    }

    public double getWaitTime() {
        this.changeWaitTime();
        return waitTime;
    }

    public Integer getLaneNumber() {
        return laneNumber;
    }

    public Integer getItemLimit() {
        return itemLimit;
    }

    public Integer getPriority() {
        return 100;
    }

    @Override
    public int compareTo(Lane o) {
        if (this.size() == o.size()){
            return this.getPriority().compareTo(o.getPriority()); // https://stackoverflow.com/questions/32284470/java-priority-queue-with-2-priority-parameters
        }
        return Integer.valueOf(this.size()).compareTo(Integer.valueOf(o.size()));
    }
}