class Room {
    enum RoomCategory
    {
        STANDARD,
        DELUXE,
        SUITE
    }
    private int roomNumber;
    private RoomCategory category;
    private boolean isOccupied;

    public Room(int roomNumber, RoomCategory category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isOccupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomCategory getCategory() {
        return category;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}