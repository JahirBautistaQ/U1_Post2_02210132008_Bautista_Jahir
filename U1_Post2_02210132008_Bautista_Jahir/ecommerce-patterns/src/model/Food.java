package model;

public class Food extends Product {

    private int expirationDays;

    public Food(String name,
                double price,
                int expirationDays) {

        super(name, price, "Food");
        this.expirationDays = expirationDays;
    }

    @Override
    public double calculateShipping() {
        return basePrice * 0.01; // envío mínimo
    }

    @Override
    public String getDescription() {
        return name +
                " [Alimento] - Expira en " +
                expirationDays + " días";
    }
}