public class Main {
    public static void main(String[] args) {
        Ticket economyTicket = new EconomyTicket("John Doe", "FL123", 100.0);
        Ticket businessTicket = new BusinessTicket("Jane Smith", "FL456", 100.0);
        Ticket firstClassTicket = new FirstClassTicket("Alice Johnson", "FL789", 100.0);

        System.out.println("=== Ticket Details ===");
        economyTicket.showTicketDetails();
        System.out.println();

        businessTicket.showTicketDetails();
        System.out.println();

        firstClassTicket.showTicketDetails();
    }
}
