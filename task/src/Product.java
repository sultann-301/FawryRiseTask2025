public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean isExpiring;

    public Product(String name, double price, int quantity, boolean isExpiring) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpiring = isExpiring;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isExpiring() { return isExpiring; }

    public void reduceQuantity(int amount) {
        if (amount > quantity) throw new IllegalArgumentException("Insufficient quantity.");
        quantity -= amount;
    }
}