public class DeluxeRoom extends Room {

    private String viewType;

    public DeluxeRoom(String roomId, String roomName,
                      double pricePerNight, String viewType) {

        super(roomId, roomName, pricePerNight);
        this.viewType = viewType;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    @Override
    public String toString() {
        return "Deluxe Room | "
                + super.toString()
                + ", View Type: "
                + viewType;
    }
}