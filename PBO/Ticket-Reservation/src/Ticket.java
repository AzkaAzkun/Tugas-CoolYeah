public abstract class Ticket {
    protected String passengerName;
    protected String flightNumber;
    protected double baseFare;

    public Ticket(String passengerName, String flightNumber, double baseFare) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.baseFare = baseFare;
    }

    public abstract double calculateFare();

    public void showTicketDetails() {
        System.out.println("Passenger: " + passengerName);
        System.out.println("Flight: " + flightNumber);
        System.out.println("Base Fare: $" + baseFare);
        System.out.println("Total Fare: $" + calculateFare());
    }
}
