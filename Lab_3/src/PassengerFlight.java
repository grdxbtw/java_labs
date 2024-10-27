class PassengerFlight extends Flight {
    private int passengerCount;
    private int maxPassengerCapacity;

    public PassengerFlight(String flightNumber, String destination, String aircraftModel, double flightDuration, double fuelAmount,
                           int passengerCount, int maxPassengerCapacity) {
        super(flightNumber, destination, aircraftModel, flightDuration, fuelAmount);
        this.passengerCount = passengerCount;
        this.maxPassengerCapacity = maxPassengerCapacity;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        if (passengerCount <= maxPassengerCapacity) {
            this.passengerCount = passengerCount;
        } else {
            System.out.println("Passenger count exceeds maximum capacity.");
        }
    }

    @Override
    public void load() {
        setStatus("loading");
        System.out.println("Boarding passengers. Passengers on board: " + passengerCount);
    }

    @Override
    public void unload() {
        setStatus("unloading");
        System.out.println("Unboarding passengers.");
    }
}