import java.util.*;

public class ShoppingCart {

    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Double> cartOrder = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        cartOrder.put(product, price);
    }

    public void displayCartOrder() {
        System.out.println("\nItems in Cart (Insertion Order):");
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " : ₹" + entry.getValue());
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            sortedByPrice
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }

        System.out.println("\nItems Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " : ₹" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 75000);
        cart.addProduct("Mouse", 1200);
        cart.addProduct("Keyboard", 2500);
        cart.addProduct("Headphones", 3500);

        cart.displayCartOrder();
        cart.displaySortedByPrice();
    }
}
