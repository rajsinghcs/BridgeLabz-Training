class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String date) {
        this.orderId = orderId;
        this.orderDate = date;
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String date, String trackingNumber) {
        super(orderId, date);
        this.trackingNumber = trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String date, String trackingNumber, String deliveryDate) {
        super(orderId, date, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    void getOrderStatus() {
        System.out.println("Order ID: " + orderId + ", Delivered on: " + deliveryDate);
    }
}

public class OnlineRetailOrderManagementMultilevel {
    public static void main(String[] args) {
        DeliveredOrder d = new DeliveredOrder(1, "2021-01-01", "12345", "2021-01-02");
        d.getOrderStatus();
    }
}
