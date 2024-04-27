package AlexYeoh_PracticeProblem2;
public class LuxuryProduct extends Product {
    
    LuxuryProduct(String name, Double price){
        super(name, price);
    }

    @Override
    public double getTotalPrice() {
        return super.getPrice() * 1.0575;
    }
}
