public class App {
    public static void main(String[] args) throws Exception {
        ShoppingCart cart = new ShoppingCart();
        

        //here milk is expired, order wont go through!
        Product apple = new Product("Apple", 0.99, 10, false);
        ExpiringProduct milk = new ExpiringProduct("Milk", 1.49, 5, true);
        ShippableProduct laptop = new ShippableProduct("Laptop", 999.99, 2, 2.5);

        cart.addProduct(apple, 3);
        cart.addProduct(milk, 1);
        cart.addProduct(laptop, 1);

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart contents:");
            for (CartItem item : cart.getItems()) {
                System.out.println("- " + item.getProduct().getName() + " x" + item.getQuantity());
            }
        }

        System.out.println("--------OTHER CART SEQUENCE----------");
        //happy scenario
        ShippableProduct laptop1 = new ShippableProduct("Laptop 1", 300.99, 2, 2.5);
        ShippableProduct laptop2 = new ShippableProduct("Laptop 2", 500.99, 2, 2.5);
        ShippableProduct laptop3 = new ShippableProduct("Laptop 3", 100.99, 2, 2.5);
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addProduct(laptop3, 1);
        cart2.addProduct(laptop2, 1);
        cart2.addProduct(laptop1, 1);
        CheckoutProcessor checkout = new CheckoutProcessor(cart2);
        checkout.processCheckout();


        System.out.println("--------OTHER CART SEQUENCE----------");
        //insufficient quantity ordered

        ShippableProduct laptopInsufficient = new ShippableProduct("Laptop Test 5", 300.99, 2, 2.5);
        ShoppingCart cart3 = new ShoppingCart();
        cart3.addProduct(laptopInsufficient, 3);
        CheckoutProcessor checkout2 = new CheckoutProcessor(cart3);
        checkout2.processCheckout();

    }   
}
