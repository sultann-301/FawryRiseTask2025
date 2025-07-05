import java.util.List;

public class CheckoutProcessor {
    private ShoppingCart cart;
    private double customerBalance;

    public CheckoutProcessor(ShoppingCart cart) {
        this(cart, 2000.0); // Default balance for demo
    }

    public CheckoutProcessor(ShoppingCart cart, double customerBalance) {
        this.cart = cart;
        this.customerBalance = customerBalance;
    }

    public void processCheckout() {
        if (cart.isEmpty()) {
            System.out.println("ERROR: Cart is empty.");
            return;
        }
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            if (item.getQuantity() > p.getQuantity()) {
                System.out.println("ERROR: Out of stock: " + p.getName());
                return;
            }
            if (p instanceof ExpiringProduct && ((ExpiringProduct) p).isExpired()) {
                System.out.println("ERROR: Expired: " + p.getName());
                return;
            }
        }
        double subtotal = cart.getSubtotal();
        List<Shippable> shippables = cart.getShippableItems();
        double shipping = ShippingService.calculateShipping(shippables);
        double total = subtotal + shipping;
        if (total > customerBalance) {
            System.out.println("ERROR: Insufficient balance.");
            return;
        }
        // Reduce product quantities
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        customerBalance -= total;
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Total paid: " + total);
        System.out.println("Balance after payment: " + customerBalance);
        if (!shippables.isEmpty()) {
            ShippingService.shipItems(shippables);
        }
    }
}