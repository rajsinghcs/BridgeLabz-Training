class LowStockAlertService implements AlertService {
    @Override
    public void sendAlert(Product product) {
        System.out.println("ALERT: Low stock for " + product.getName());
    }
}
