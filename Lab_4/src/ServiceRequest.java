class ServiceRequest {
    private String serviceType;
    private Guest guest;

    public ServiceRequest(String serviceType, Guest guest) {
        this.serviceType = serviceType;
        this.guest = guest;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Guest getGuest() {
        return guest;
    }
}