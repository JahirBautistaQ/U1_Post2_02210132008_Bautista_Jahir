package strategy;

public class MemberPricing implements PricingStrategy {

    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.90;
    }

    @Override
    public String getDescription() {
        return "Descuento miembro 10%";
    }
}