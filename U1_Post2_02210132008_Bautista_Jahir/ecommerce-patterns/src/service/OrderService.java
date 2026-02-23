package service;

import factory.ProductFactory;
import model.Product;
import observer.*;
import strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements OrderSubject {

    // ===== OBSERVER =====

    private final List<OrderObserver> observers = new ArrayList<>();

    private String orderId;
    private String status = "CREATED";

    public OrderService(String orderId) {
        this.orderId = orderId;
    }

    // ===== FACTORY + STRATEGY =====

    public double addProduct(String type,
                             String name,
                             double price,
                             PricingStrategy strategy) {

        // Factory Method
        Product product =
                ProductFactory.createProduct(type, name, price);

        // Strategy
        double discountedPrice =
                strategy.calculateFinalPrice(price);

        double shipping = product.calculateShipping();

        double finalPrice = discountedPrice + shipping;

        // Mostrar info
        System.out.println("\nProducto agregado:");
        System.out.println(product.getDescription());
        System.out.println("Precio base: " + price);
        System.out.println("Estrategia: " +
                strategy.getDescription());
        System.out.println("Precio con descuento: " +
                discountedPrice);
        System.out.println("Costo envío: " + shipping);
        System.out.println("Precio final: " + finalPrice);

        return finalPrice;
    }

    // ===== CAMBIO DE ESTADO (Observer) =====

    public void changeStatus(String newStatus) {

        String oldStatus = this.status;
        this.status = newStatus;

        notifyObservers(orderId, oldStatus, newStatus);
    }

    // ===== IMPLEMENTACIÓN OrderSubject =====

    @Override
    public void subscribe(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String orderId,
                                String oldStatus,
                                String newStatus) {

        for (OrderObserver obs : observers) {
            obs.update(orderId, oldStatus, newStatus);
        }
    }
}