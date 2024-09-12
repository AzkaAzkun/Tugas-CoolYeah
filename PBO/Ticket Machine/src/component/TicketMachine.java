package component;

public class TicketMachine {
    private final int ticketPrice;
    private int balance;

    public TicketMachine(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.balance = 0;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getBalance() {
        return balance;
    }

    public int totalPrice(int tickets) {
        if (tickets <= 0) {
            System.out.println("You can't buy negative tickets.");
            return -1;
        }

        return tickets * this.ticketPrice;
    }

    public void transaction(Users customer, int price) {
        int statusCustomer = customer.Pay(price);
        if (statusCustomer == 1) {
            this.balance += price;
        } else {
            System.out.println("Transaction Failed!!");
        }
    }

    public void buyTicket(Users customer, int tickets) {
        int totalPrice = this.totalPrice(tickets);
        if (totalPrice < 0) return;

        this.transaction(customer, totalPrice);
    }
}
