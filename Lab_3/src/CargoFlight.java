class CargoFlight extends Flight {
    private double cargoWeight;
    private boolean isFragile;
    private boolean isValuable;

    public CargoFlight(String flightNumber, String destination, String aircraftModel, double flightDuration, double fuelAmount,
                       double cargoWeight, boolean isFragile, boolean isValuable) {
        super(flightNumber, destination, aircraftModel, flightDuration, fuelAmount);
        this.cargoWeight = cargoWeight;
        this.isFragile = isFragile;
        this.isValuable = isValuable;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public boolean isValuable() {
        return isValuable;
    }

    @Override
    public void load() {
        setStatus("loading");
        System.out.println("Loading cargo flight. Cargo weight: " + cargoWeight + " kg.");
    }

    @Override
    public void unload() {
        setStatus("unloading");
        System.out.println("Unloading cargo flight.");
    }
}