public class ExpiringProduct extends Product {
    private boolean expired;

    public ExpiringProduct(String name, double price, int quantity, boolean expired) {
        super(name, price, quantity, true);
        this.expired = expired;
    }

    public boolean isExpired() {
        return expired;
    }
}