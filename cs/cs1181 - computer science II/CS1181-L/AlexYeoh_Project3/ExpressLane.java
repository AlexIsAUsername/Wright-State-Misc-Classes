public class ExpressLane extends Lane{

    ExpressLane(int laneNumber){
        super(laneNumber);
    }

    ExpressLane(Customer person){
        super(person);
    }

    @Override
    public Integer getItemLimit() {
        return 12;
    }

    @Override
    public Integer getPriority() {
        return 0;
    }

    @Override
    public void changeWaitTime() {
        double waitTime = 0;
        for (int i = 0; i < this.size(); i++){
            waitTime += this.get(i).getItems() * 0.1 + 1;
        }
        super.setWaitTime(waitTime);
    }
}
