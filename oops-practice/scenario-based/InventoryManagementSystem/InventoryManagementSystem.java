public class InventoryManagementSystem {
    public static void main(String[] args) {
        AlertService alertService = new LowStockAlertService();
        Inventory inventory = new Inventory(alertService);

        Product p1 = new Product(101, "Laptop", 10);
        inventory.addProduct(p1);

        try {
            inventory.updateStock(101, 7);
            inventory.updateStock(101, 5); // Exception
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        Product p2 = new Product(102, "Smartphone", 3);
        inventory.addProduct(p2);

        try {
            inventory.updateStock(102, 1); 
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
