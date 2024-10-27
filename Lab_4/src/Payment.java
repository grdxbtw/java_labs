class Payment {
    private double amount;
    private String details;

    public Payment(double amount, String details) {
        this.amount = amount;
        this.details = details;
    }

    public double getAmount() {
        return amount;
    }

    public String getDetails() {
        return details;
    }
}