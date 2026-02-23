import factory.ProductFactory;
import model.Product;

public class TestFactory {

    public static void main(String[] args) {

        Product p1 = ProductFactory.createProduct(
                "electronics", "Laptop", 1200);

        Product p2 = ProductFactory.createProduct(
                "clothing", "Camisa", 80);

        Product p3 = ProductFactory.createProduct(
                "food", "Chocolate", 20);

        System.out.println(p1.getDescription());
        System.out.println(p2.getDescription());
        System.out.println(p3.getDescription());
    }
}