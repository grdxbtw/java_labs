abstract class Flight implements IFlight {
    private String flightNumber;
    private String destination;
    private String aircraftModel;
    private String status;
    private double flightDuration;
    private double fuelAmount;

    public Flight(String flightNumber, String destination, String aircraftModel, double flightDuration, double fuelAmount) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.aircraftModel = aircraftModel;
        this.flightDuration = flightDuration;
        this.fuelAmount = fuelAmount;
        this.status = "ready for departure";
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getFlightDuration() {
        return flightDuration;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    @Override
    public void refuel(double amount) {
        fuelAmount += amount;
        System.out.println("Added " + amount + " liters of fuel. Total fuel: " + fuelAmount);
    }

    @Override
    public void repair() {
        status = "under maintenance";
        System.out.println("Flight is under maintenance.");
    }

    @Override
    public void startFlight() {
        if (status.equals("ready for departure")) {
            status = "in-flight";
            System.out.println("Flight is on its way to the destination.");
        } else {
            System.out.println("Flight is not ready for departure.");
        }
    }

    @Override
    public abstract void load();

    @Override
    public abstract void unload();
}