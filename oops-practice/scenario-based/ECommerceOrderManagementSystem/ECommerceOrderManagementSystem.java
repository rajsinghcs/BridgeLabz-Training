public class ECommerceOrderManagementSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Nivedita", 101);
        Customer customer2 = new Customer("Rohita", 102);
        Customer customer3 = new Customer("Nived", 103);
        Customer customer4 = new Customer("Rohit", 104);

        Product product1 = new Product("Smartphone", 30000);
        Product product2 = new Product("Laptop", 60000);
        Product product3 = new Product("Headphones", 8000);
        Product product4 = new Product("Smartwatch", 12000);

        Order order1 = new Order(customer1, product1, 1);
        order1.placeOrder();
        order1.makePayment(new CardPayment());
        order1.trackOrder();

        Order order2 = new Order(customer2, product2, 2);
        order2.placeOrder();
        order2.makePayment(new UPIPayment());
        order2.trackOrder();

        Order order3 = new Order(customer3, product3, 3);
        order3.placeOrder();
        order3.makePayment(new WalletPayment());    
        order3.trackOrder();

        Order order4 = new Order(customer4, product4, 4);
        order4.placeOrder();
        order4.makePayment(new WalletPayment());    
        order4.trackOrder();

        order3.cancelOrder();
        order3.trackOrder();

    }
}
