package strategy;

public class BulkPricing implements PricingStrategy {

    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.85; // 15% descuento
    }

    @Override
    public String getDescription() {
        return "Descuento por volumen 15%";
    }
}