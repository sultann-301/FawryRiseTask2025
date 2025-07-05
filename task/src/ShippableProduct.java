public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity, false);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}