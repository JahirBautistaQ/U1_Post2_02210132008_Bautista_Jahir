import observer.*;
import service.OrderService;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== SISTEMA E-COMMERCE =====");

        // ===== CREAR PEDIDO =====

        OrderService order =
                new OrderService("ORD-001");

        // ===== OBSERVERS =====

        order.subscribe(new EmailNotifier());
        order.subscribe(new SMSNotifier());
        order.subscribe(new LogNotifier());

        // ===== STRATEGIES =====

        PricingStrategy regular =
                new RegularPricing();

        PricingStrategy member =
                new MemberPricing();

        PricingStrategy blackFriday =
                new BlackFridayPricing();

        // ===== FACTORY + STRATEGY =====

        double total = 0;

        // Electrónica con precio regular
        total += order.addProduct(
                "electronics",
                "Laptop Gamer",
                1500,
                regular
        );

        // Ropa con descuento miembro
        total += order.addProduct(
                "clothing",
                "Chaqueta",
                120,
                member
        );

        // Alimento con Black Friday
        total += order.addProduct(
                "food",
                "Caja de Chocolates",
                40,
                blackFriday
        );

        // ===== CAMBIOS DE ESTADO (Observer) =====

        System.out.println("\n=== Cambios de estado del pedido ===");

        order.changeStatus("PROCESSING");
        order.changeStatus("SHIPPED");
        order.changeStatus("DELIVERED");

        // ===== RESUMEN FINAL =====

        System.out.println("\n===== RESUMEN FINAL =====");
        System.out.println("Total del pedido: $" + total);
        System.out.println("Estado final: DELIVERED");
        System.out.println("Gracias por su compra.");
    }
}