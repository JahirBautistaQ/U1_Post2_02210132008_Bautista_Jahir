package observer;

import java.time.LocalDateTime;

public class LogNotifier implements OrderObserver {

    @Override
    public void update(String orderId,
                       String oldStatus,
                       String newStatus) {

        System.out.println(
            "[LOG " + LocalDateTime.now() + "] " +
            "Pedido " + orderId +
            ": " + oldStatus +
            " -> " + newStatus
        );
    }
}