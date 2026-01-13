import java.util.HashMap;
import java.util.Map;

class Inventory {
    private Map<Integer, Product> products = new HashMap<>();
    private AlertService alertService;
    private static final int LOW_STOCK_LIMIT = 5;

    public Inventory(AlertService alertService) {
        this.alertService = alertService;
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void updateStock(int productId, int soldQty) throws OutOfStockException {
        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        if (product.getQuantity() < soldQty) {
            throw new OutOfStockException("Not enough stock for " + product.getName());
        }

        product.setQuantity(product.getQuantity() - soldQty);

        if (product.getQuantity() <= LOW_STOCK_LIMIT) {
            alertService.sendAlert(product);
        }
    }
}
