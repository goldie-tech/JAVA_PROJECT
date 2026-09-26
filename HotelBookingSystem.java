import java.util.Scanner;

public class HotelBookingSystem {

    static Scanner scanner = new Scanner(System.in);

    static Room[] rooms = new Room[20];
    static ReceptionStaff[] staffMembers = new ReceptionStaff[10];
    static Booking[] bookings = new Booking[30];

    static int roomCount = 0;
    static int staffCount = 0;
    static int bookingCount = 0;

    static String studentId;

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("     HOTEL ROOM BOOKING MANAGEMENT");
        System.out.println("==========================================");

        System.out.print("Enter your Student ID: ");
        studentId = scanner.nextLine();

        int choice = 0;

        while (choice != 7) {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addRoom();
                    break;

                case 2:
                    viewAllRooms();
                    break;

                case 3:
                    addReceptionStaff();
                    break;

                case 4:
                    placeBooking();
                    break;

                case 5:
                    assignBookingToStaff();
                    break;

                case 6:
                    displayReports();
                    break;

                case 7:
                    System.out.println("\nThank you for using the Hotel Booking System.");
                    break;

                default:
                    System.out.println("Invalid menu choice. Please select 1-7.");
            }
        }

        scanner.close();
    }

    // ==========================
    // MENU
    // ==========================

    public static void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println("Student ID: " + studentId);
        System.out.println("              MAIN MENU");
        System.out.println("==========================================");

        System.out.println("1. Add room");
        System.out.println("2. View all rooms");
        System.out.println("3. Add reception staff");
        System.out.println("4. Place booking");
        System.out.println("5. Assign booking to reception staff");
        System.out.println("6. Display all bookings / reports");
        System.out.println("7. Exit");

        System.out.println("==========================================");
    }

    // ==========================
    // ADD ROOM
    // ==========================

    public static void addRoom() {

        System.out.println("\n------------------------------------------");
        System.out.println("ADD ROOM");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        if (roomCount >= rooms.length) {
            System.out.println("Room storage is full.");
            return;
        }

        System.out.print("Enter Room ID: ");
        String roomId = scanner.nextLine();

        if (roomId.trim().isEmpty()) {
            System.out.println("Room ID cannot be empty.");
            return;
        }

        System.out.print("Enter Room Name: ");
        String roomName = scanner.nextLine();

        if (roomName.trim().isEmpty()) {
            System.out.println("Room name cannot be empty.");
            return;
        }

        double price = readDouble("Enter Price Per Night: ");

        if (price <= 0) {
            System.out.println("Price must be greater than zero.");
            return;
        }

        System.out.println("\nSelect Room Type:");
        System.out.println("1. Standard Room");
        System.out.println("2. Deluxe Room");

        int type = readInt("Enter room type: ");

        if (type == 1) {

            System.out.print("Does it have a balcony? (yes/no): ");
            String balcony = scanner.nextLine();

            boolean hasBalcony =
                    balcony.equalsIgnoreCase("yes");

            rooms[roomCount] =
                    new StandardRoom(
                            roomId,
                            roomName,
                            price,
                            hasBalcony
                    );

            roomCount++;

            System.out.println("Standard room added successfully.");

        } else if (type == 2) {

            System.out.print("Enter View Type: ");
            String viewType = scanner.nextLine();

            if (viewType.trim().isEmpty()) {
                System.out.println("View type cannot be empty.");
                return;
            }

            rooms[roomCount] =
                    new DeluxeRoom(
                            roomId,
                            roomName,
                            price,
                            viewType
                    );

            roomCount++;

            System.out.println("Deluxe room added successfully.");

        } else {

            System.out.println("Invalid room type.");
        }
    }

    // ==========================
    // VIEW ROOMS
    // ==========================

    public static void viewAllRooms() {

        System.out.println("\n------------------------------------------");
        System.out.println("ALL ROOMS");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        if (roomCount == 0) {
            System.out.println("No rooms have been added.");
            return;
        }

        for (int i = 0; i < roomCount; i++) {

            System.out.println((i + 1) + ". " + rooms[i]);
        }
    }

    // ==========================
    // SEARCH ROOM
    // ==========================

    public static void searchRoomByName() {

        System.out.println("\n------------------------------------------");
        System.out.println("SEARCH ROOM");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        System.out.print("Enter room name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < roomCount; i++) {

            if (rooms[i].getRoomName()
                    .equalsIgnoreCase(searchName)) {

                System.out.println("Room found:");
                System.out.println(rooms[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No room found with that name.");
        }
    }

    // ==========================
    // ADD STAFF
    // ==========================

    public static void addReceptionStaff() {

        System.out.println("\n------------------------------------------");
        System.out.println("ADD RECEPTION STAFF");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        if (staffCount >= staffMembers.length) {
            System.out.println("Staff storage is full.");
            return;
        }

        int staffId = readInt("Enter Staff ID: ");

        System.out.print("Enter Staff Name: ");
        String staffName = scanner.nextLine();

        if (staffName.trim().isEmpty()) {
            System.out.println("Staff name cannot be empty.");
            return;
        }

        staffMembers[staffCount] =
                new ReceptionStaff(staffId, staffName);

        staffCount++;

        System.out.println("Reception staff added successfully.");
    }

    // ==========================
    // PLACE BOOKING
    // ==========================

    public static void placeBooking() {

        System.out.println("\n------------------------------------------");
        System.out.println("PLACE BOOKING");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        if (bookingCount >= bookings.length) {
            System.out.println("Booking storage is full.");
            return;
        }

        if (roomCount == 0) {
            System.out.println("No rooms are available.");
            return;
        }

        int bookingId = bookingCount + 1;

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        if (guestName.trim().isEmpty()) {
            System.out.println("Guest name cannot be empty.");
            return;
        }

        viewAllRooms();

        int roomNumber =
                readInt("Select room number: ");

        if (roomNumber < 1 ||
                roomNumber > roomCount) {

            System.out.println("Invalid room selection.");
            return;
        }

        int nights =
                readInt("Enter number of nights: ");

        if (nights <= 0) {
            System.out.println("Number of nights must be greater than zero.");
            return;
        }

        Room selectedRoom =
                rooms[roomNumber - 1];

        bookings[bookingCount] =
                new Booking(
                        bookingId,
                        guestName,
                        selectedRoom,
                        nights
                );

        bookingCount++;

        System.out.println("\nBooking placed successfully.");
        System.out.println(bookings[bookingCount - 1]);
    }

    // ==========================
    // ASSIGN BOOKING
    // ==========================

    public static void assignBookingToStaff() {

        System.out.println("\n------------------------------------------");
        System.out.println("ASSIGN BOOKING TO STAFF");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        if (bookingCount == 0) {
            System.out.println("No bookings available.");
            return;
        }

        if (staffCount == 0) {
            System.out.println("No reception staff available.");
            return;
        }

        displayAllBookings();

        int bookingId =
                readInt("Enter Booking ID: ");

        Booking selectedBooking = null;

        for (int i = 0; i < bookingCount; i++) {

            if (bookings[i].getBookingId() == bookingId) {
                selectedBooking = bookings[i];
                break;
            }
        }

        if (selectedBooking == null) {
            System.out.println("Booking not found.");
            return;
        }

        System.out.println("\nReception Staff:");

        for (int i = 0; i < staffCount; i++) {

            System.out.println(
                    (i + 1) + ". "
                    + staffMembers[i].getStaffName()
                    + " | Assigned: "
                    + staffMembers[i].countAssignedBookings()
                    + "/3"
            );
        }

        int staffNumber =
                readInt("Select staff member: ");

        if (staffNumber < 1 ||
                staffNumber > staffCount) {

            System.out.println("Invalid staff selection.");
            return;
        }

        ReceptionStaff selectedStaff =
                staffMembers[staffNumber - 1];

        selectedStaff.assignBooking(selectedBooking);
    }

    // ==========================
    // DISPLAY BOOKINGS
    // ==========================

    public static void displayAllBookings() {

        System.out.println("\n------------------------------------------");
        System.out.println("ALL BOOKINGS");
        System.out.println("Student ID: " + studentId);
        System.out.println("------------------------------------------");

        if (bookingCount == 0) {
            System.out.println("No bookings have been placed.");
            return;
        }

        for (int i = 0; i < bookingCount; i++) {

            System.out.println(bookings[i]);
        }
    }

    // ==========================
    // REPORTS
    // ==========================

    public static void displayReports() {

        System.out.println("\n==========================================");
        System.out.println("REPORTS");
        System.out.println("Student ID: " + studentId);
        System.out.println("==========================================");

        displayAllBookings();

        System.out.println("\nTotal number of bookings: "
                + bookingCount);

        System.out.println("\nReception Staff Assignments:");

        if (staffCount == 0) {

            System.out.println("No reception staff added.");

        } else {

            for (int i = 0; i < staffCount; i++) {

                staffMembers[i].displayAssignedBookings();
            }
        }

        System.out.println();
        searchRoomByName();
    }

    // ==========================
    // INTEGER INPUT
    // ==========================

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a whole number."
                );
            }
        }
    }

    // ==========================
    // DOUBLE INPUT
    // ==========================

    public static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }
}