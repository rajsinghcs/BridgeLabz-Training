class Reservation {
    private Guest guest;
    private Room room;
    private int nights;
    private double totalAmount;

    public Reservation(Guest guest, Room room, int nights, PricingStrategy pricing) {
        this.guest = guest;
        this.room = room;
        this.nights = nights;
        this.totalAmount = room.calculatePrice(pricing) * nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Room getRoom() {
        return room;
    }
}
