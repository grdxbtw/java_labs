import java.util.*;

class HotelManagementSystem {
    private HashMap<Integer, Room> rooms = new HashMap<>();
    private TreeMap<Date, Booking> bookings = new TreeMap<>();
    private Queue<ServiceRequest> serviceQueue = new LinkedList<>();
    private List<Payment> payments = new ArrayList<>();

    public void addRoom(int roomNumber, Room.RoomCategory category) {
        rooms.put(roomNumber, new Room(roomNumber, category));
    }

    public void bookRoom(Date date, int roomNumber, Guest guest) {
        Room room = rooms.get(roomNumber);
        if (room != null && !room.isOccupied()) {
            Booking booking = new Booking(date, room, guest);
            bookings.put(date, booking);
            room.setOccupied(true);
            System.out.println("Room " + roomNumber + " booked for " + guest.getName());
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void addServiceRequest(String serviceType, Guest guest) {
        ServiceRequest request = new ServiceRequest(serviceType, guest);
        serviceQueue.add(request);
        System.out.println("Service request for " + serviceType + " added for " + guest.getName());
    }

    public void processServiceRequest() {
        ServiceRequest request = serviceQueue.poll();
        if (request != null) {
            System.out.println("Processing service request: " + request.getServiceType() + " for " + request.getGuest().getName());
        } else {
            System.out.println("No pending service requests.");
        }
    }

    public void addPayment(double amount, String details) {
        payments.add(new Payment(amount, details));
        System.out.println("Payment added: " + amount + " for " + details);
    }

    public void displayBookings() {
        System.out.println("Bookings:");
        for (Map.Entry<Date, Booking> entry : bookings.entrySet()) {
            Booking booking = entry.getValue();
            System.out.println("Date: " + booking.getDate() + ", Room: " + booking.getRoom().getRoomNumber() + ", Guest: " + booking.getGuest().getName());
        }
    }
}
