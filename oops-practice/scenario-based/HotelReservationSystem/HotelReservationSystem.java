public class HotelReservationSystem {
    public static void main(String[] args) {
        Guest guest = new Guest(1, "Raj");

        Room room = new DeluxeRoom(101);
        PricingStrategy festivePricing = new SeasonalPricing(1.5);

        HotelService service = new HotelService();

        try {
            Reservation reservation =
                    service.bookRoom(guest, room, 2, festivePricing);

            service.checkout(reservation);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
