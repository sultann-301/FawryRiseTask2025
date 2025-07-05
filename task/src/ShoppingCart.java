import java.util.*;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return items; }

    public boolean isEmpty() { return items.isEmpty(); }

    public double getSubtotal() {
        double sum = 0;
        for (CartItem item : items) {
            sum += item.getProduct().getPrice() * item.getQuantity();
        }
        return sum;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable) {
                shippables.add((Shippable) item.getProduct());
            }
        }
        return shippables;
    }
}