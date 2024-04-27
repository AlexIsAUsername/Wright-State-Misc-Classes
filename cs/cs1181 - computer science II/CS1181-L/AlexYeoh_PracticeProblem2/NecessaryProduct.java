package AlexYeoh_PracticeProblem2;
public class NecessaryProduct extends Product {

    NecessaryProduct(String name, Double price){
        super(name, price);
    }

    @Override
    public double getTotalPrice() {
        return super.getPrice();
    }
}
