public class Customer implements Comparable<Customer>{
    private Double entryTime;
    private Integer items;
    private Double timePerItem;
    private Integer customerNumber;
    private Double timeUntilNextEvent;
    private Double waitTime;
    private Integer peopleAhead;
    private Integer laneNumber = null;

    Customer(double entryTime, int items, double timePerItem, int customerNumber){
        this.entryTime = entryTime;
        this.items = items;
        this.timePerItem = timePerItem;
        this.customerNumber = customerNumber;
        timeUntilNextEvent = entryTime;
    }

    public double getEntryTime() {
        return entryTime;
    }

    public Integer getItems() {
        return items;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public double getToCheckoutTime() {
        return items * timePerItem;
    }

    public Double getTimeUntilNextEvent() {
        return timeUntilNextEvent;
    }
    
    public Double getWaitTime() {
        return waitTime;
    }

    public Integer getPeopleAhead() {
        return peopleAhead;
    }

    public Integer getLaneNumber() {
        return laneNumber;
    }

    public void setLaneNumber(Integer laneNumber) {
        this.laneNumber = laneNumber;
    }

    public void setPeopleAhead(Integer peopleAhead) {
        this.peopleAhead = peopleAhead;
    }

    public void setWaitTime(Double waitTime) {
        this.waitTime = waitTime;
    }

    public void setTimeUntilNextEvent() {
        timeUntilNextEvent += this.getToCheckoutTime();
    }

    public void setTimeUntilNextEvent(double waitTime){
        timeUntilNextEvent += waitTime;
    }

    @Override
    public int compareTo(Customer o) {
        return timeUntilNextEvent.compareTo(o.timeUntilNextEvent);
    }
}
