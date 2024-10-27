import java.util.Date;

public class Main {
    public static void main(String[] args) {
        HotelManagementSystem hotel = new HotelManagementSystem();

        hotel.addRoom(101, Room.RoomCategory.STANDARD);
        hotel.addRoom(102, Room.RoomCategory.DELUXE);
        hotel.addRoom(103, Room.RoomCategory.SUITE);

        Guest guest1 = new Guest("Guest 1", "1234567890");
        Guest guest2 = new Guest("Guest 2", "0987654321");

        hotel.bookRoom(new Date(), 101, guest1);
        hotel.bookRoom(new Date(), 102, guest2);

        hotel.addServiceRequest("Room Cleaning", guest1);
        hotel.addServiceRequest("Breakfast", guest2);
        hotel.processServiceRequest();
        hotel.processServiceRequest();
        hotel.processServiceRequest();

        hotel.addPayment(150.0, "Room 101 booking");
        hotel.addPayment(75.0, "Breakfast for Jane");

        hotel.displayBookings();
    }
}