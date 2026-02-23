import strategy.*;

public class TestStrategy {

    public static void main(String[] args) {

        double price = 100;

        PricingStrategy regular = new RegularPricing();
        PricingStrategy member = new MemberPricing();
        PricingStrategy blackFriday = new BlackFridayPricing();
        PricingStrategy bulk = new BulkPricing();

        System.out.println(regular.getDescription() +
                ": " + regular.calculateFinalPrice(price));

        System.out.println(member.getDescription() +
                ": " + member.calculateFinalPrice(price));

        System.out.println(blackFriday.getDescription() +
                ": " + blackFriday.calculateFinalPrice(price));

        System.out.println(bulk.getDescription() +
                ": " + bulk.calculateFinalPrice(price));
    }
}