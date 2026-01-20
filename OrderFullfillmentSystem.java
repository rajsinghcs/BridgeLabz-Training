abstract class Order {
    public final void processOrder() {
        validateOrder();
        packOrder();
        deliverOrder();
        generateInvoice();
    }

    protected void validateOrder() {
        System.out.println("Validating order");
    }

    protected void packOrder() {
        System.out.println("Packing order");
    }

    protected abstract void deliverOrder();

    protected void generateInvoice() {
        System.out.println("Generating invoice");
    }
}

class OnlineOrder extends Order {

    @Override
    protected void deliverOrder() {
        System.out.println("Delivering order to home address");
    }
}

class StorePickupOrder extends Order {

    @Override
    protected void deliverOrder() {
        System.out.println("Order ready for store pickup");
    }
}

public class OrderFullfillmentSystem {
    public static void main(String[] args) {

        Order order1 = new OnlineOrder();
        Order order2 = new StorePickupOrder();

        System.out.println("\nOnline Order:");
        order1.processOrder();

        System.out.println("\nStore Pickup Order:");
        order2.processOrder();
    }
}
