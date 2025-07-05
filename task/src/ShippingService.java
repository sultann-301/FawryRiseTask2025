import java.util.List;

public class ShippingService {
    public static double calculateShipping(List<Shippable> items) {
        double total = 0;
        for (Shippable s : items) {
            total += s.getWeight() * 1.5; // Example rate
        }
        return total;
    }

    public static void shipItems(List<Shippable> items) {
        System.out.println("Shipping the following items:");
        for (Shippable s : items) {
            System.out.println("- " + s.getName() + " (" + s.getWeight() + "kg)");
        }
    }
}