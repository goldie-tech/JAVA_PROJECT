public class StandardRoom extends Room {

    private boolean hasBalcony;

    public StandardRoom(String roomId, String roomName,
                        double pricePerNight, boolean hasBalcony) {

        super(roomId, roomName, pricePerNight);
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    @Override
    public String toString() {
        return "Standard Room | "
                + super.toString()
                + ", Balcony: "
                + (hasBalcony ? "Yes" : "No");
    }
}