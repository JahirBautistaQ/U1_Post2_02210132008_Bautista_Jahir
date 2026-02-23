import observer.*;

import java.util.ArrayList;
import java.util.List;

public class TestObserver {

    public static void main(String[] args) {

        List<OrderObserver> observers = new ArrayList<>();

        observers.add(new EmailNotifier());
        observers.add(new SMSNotifier());
        observers.add(new LogNotifier());

        for (OrderObserver obs : observers) {
            obs.update("ORD-001", "CREATED", "PROCESSING");
        }
    }
}