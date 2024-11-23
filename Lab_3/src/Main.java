
public class Main {
    public static void main(String[] args) {
        CargoFlight cargoFlight = new CargoFlight("C123", "Tokyo", "Boeing 747", 12.5, 5000, 1000, true, true);
        System.out.println("Flight Number: " + cargoFlight.getFlightNumber());
        cargoFlight.load();
        cargoFlight.startFlight();
        cargoFlight.unload();

        PassengerFlight passengerFlight = new PassengerFlight("P456", "London", "Airbus A320", 2.5, 3000, 150, 180);
        System.out.println("Flight Number: " + passengerFlight.getFlightNumber());
        passengerFlight.load();
        passengerFlight.startFlight();
        passengerFlight.unload();
    }
}