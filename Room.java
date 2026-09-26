public class Room {

    private String roomId;
    private String roomName;
    private double pricePerNight;

    public Room(String roomId, String roomName, double pricePerNight) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomId
                + ", Room Name: " + roomName
                + ", Price Per Night: $" + pricePerNight;
    }
}