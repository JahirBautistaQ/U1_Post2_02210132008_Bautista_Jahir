package model;

public class Clothing extends Product {

    private String size;

    public Clothing(String name,
                    double price,
                    String size) {

        super(name, price, "Clothing");
        this.size = size;
    }

    @Override
    public double calculateShipping() {
        return basePrice * 0.02; // envío barato
    }

    @Override
    public String getDescription() {
        return name +
                " [Ropa] - Talla: " +
                size;
    }
}