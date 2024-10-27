import java.util.Date;

class Booking implements Comparable<Booking> {
    private Date date;
    private Room room;
    private Guest guest;

    public Booking(Date date, Room room, Guest guest) {
        this.date = date;
        this.room = room;
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    @Override
    public int compareTo(Booking other) {
        return this.date.compareTo(other.date);
    }
}
