public class Booking {

    private int bookingId;
    private String guestName;
    private Room room;
    private int nights;

    public Booking(int bookingId, String guestName,
                   Room room, int nights) {

        this.bookingId = bookingId;
        this.guestName = guestName;
        this.room = room;
        this.nights = nights;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public double calculateTotal() {
        return room.getPricePerNight() * nights;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId
                + ", Guest: " + guestName
                + ", Room: " + room.getRoomName()
                + ", Nights: " + nights
                + ", Total: $" + calculateTotal();
    }
}