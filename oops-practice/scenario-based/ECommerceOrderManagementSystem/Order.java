class Order{
    Customer customer;
    Product product;
    String status ;
    int orderId;

    Order(Customer customer, Product product, int orderId) {
        this.customer = customer;
        this.product = product;
        this.status = "Pending";
        this.orderId = orderId;
    }

    void updateStatus(String status) {
        this.status = status;
    }
    void cancelOrder() {
        this.status = "Cancelled";
    }
    void trackOrder() {
        System.out.println("Order ID: " + orderId + ", Status: " + status);
    }
    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName() + " (ID: " + customer.getCustomerID() + ")");
        System.out.println("Product: " + product.getProductName() + " (Price: $" + product.getPrice() + ")");
        System.out.println("Status: " + status);
    }
    void placeOrder() {
        System.out.println("Order placed successfully for " + product.getProductName() + " by " + customer.getName());
    }

    void browseProducts() {
        System.out.println("Browsing products...");
    }

    void makePayment(Payment payment) {
        try {
            payment.pay(product.getPrice());
            status= "CONFIRMED";
        } catch (Exception e) {
            status = "PAYMENT FAILED";
            System.out.println("Payment failed: " + e.getMessage());
        }
    }
}