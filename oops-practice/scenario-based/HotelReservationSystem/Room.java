abstract class Room {
    protected int roomNumber;
    protected double basePrice;
    protected boolean available = true;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
    }

    public void release() {
        available = true;
    }

    public abstract double calculatePrice(PricingStrategy strategy);
}
