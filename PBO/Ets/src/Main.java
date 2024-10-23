public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.addDeposit(50000);
        customer.withdraw(10000);
        customer.withdraw(50000);

        customer.deposit();
    }
}