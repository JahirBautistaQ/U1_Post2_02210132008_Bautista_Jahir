package observer;

public class EmailNotifier implements OrderObserver {

    @Override
    public void update(String orderId,
                       String oldStatus,
                       String newStatus) {

        System.out.println(
            "[EMAIL] Pedido " + orderId +
            " cambió de " + oldStatus +
            " a " + newStatus +
            ". Se ha enviado un correo al cliente."
        );
    }
}