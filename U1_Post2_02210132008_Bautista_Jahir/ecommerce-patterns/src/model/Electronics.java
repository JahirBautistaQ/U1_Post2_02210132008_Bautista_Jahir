package model;

public class Electronics extends Product {

    private int warrantyMonths;

    public Electronics(String name,
                       double price,
                       int warrantyMonths) {

        super(name, price, "Electronics");
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateShipping() {
        return basePrice * 0.05; // 5% por fragilidad
    }

    @Override
    public String getDescription() {
        return name +
                " [Electrónica] - Garantía: " +
                warrantyMonths + " meses";
    }
}