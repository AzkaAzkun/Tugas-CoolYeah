public class FirstClassTicket extends Ticket {

    public FirstClassTicket(String passengerName, String flightNumber, double baseFare) {
        super(passengerName, flightNumber, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5; // Tambahan biaya 50%
    }
}
