public class BusinessTicket extends Ticket {

    public BusinessTicket(String passengerName, String flightNumber, double baseFare) {
        super(passengerName, flightNumber, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.25; // Tambahan biaya 25%
    }
}
