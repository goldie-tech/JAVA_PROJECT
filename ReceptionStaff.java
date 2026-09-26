public class ReceptionStaff {

    private int staffId;
    private String staffName;
    private Booking[] assignedBookings;

    public ReceptionStaff(int staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.assignedBookings = new Booking[3];
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public boolean assignBooking(Booking booking) {

        if (countAssignedBookings() >= 3) {
            System.out.println("Staff member " + staffName
                    + " has reached the maximum of 3 bookings.");
            return false;
        }

        for (int i = 0; i < assignedBookings.length; i++) {

            if (assignedBookings[i] == null) {
                assignedBookings[i] = booking;

                System.out.println("Booking " + booking.getBookingId()
                        + " assigned to " + staffName + ".");

                return true;
            }
        }

        return false;
    }

    public void displayAssignedBookings() {

        System.out.println("\nStaff ID: " + staffId);
        System.out.println("Staff Name: " + staffName);

        if (countAssignedBookings() == 0) {
            System.out.println("No bookings assigned.");
            return;
        }

        System.out.println("Assigned Bookings:");

        for (Booking booking : assignedBookings) {

            if (booking != null) {
                System.out.println(booking);
            }
        }
    }

    public int countAssignedBookings() {

        int count = 0;

        for (Booking booking : assignedBookings) {

            if (booking != null) {
                count++;
            }
        }

        return count;
    }
}