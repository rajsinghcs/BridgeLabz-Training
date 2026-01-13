class HotelService {

    public Reservation bookRoom(
            Guest guest,
            Room room,
            int nights,
            PricingStrategy pricing
    ) throws RoomNotAvailableException {

        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room not available!");
        }

        room.book();
        return new Reservation(guest, room, nights, pricing);
    }

    public void checkout(Reservation reservation) {
        reservation.getRoom().release();
        System.out.println("Invoice Amount: Rs- " + reservation.getTotalAmount());
    }
}
