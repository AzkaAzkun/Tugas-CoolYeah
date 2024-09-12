package component;

import java.util.Scanner;

public class Setting extends TicketMachine{
    private boolean running;

    public Setting(int ticketMachine) {
        super(ticketMachine);
        this.running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void PrintMenu() {
        System.out.println("#################");
        System.out.println("Ticket Sale With Price " + this.getTicketPrice());
        System.out.println("1.\tBuy");
        System.out.println("2.\tGet Balance");
        System.out.println("3.\texit");
        System.out.println("#################");
        System.out.println("Choose an Option:");
    }

    public void exit() {
        this.running = false;
    }

    public void Run(Users customer){
        Scanner scanner = new Scanner(System.in);

        while(isRunning()){
            PrintMenu();

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter number of tickets:");
                    int tickets = scanner.nextInt();
                    buyTicket(customer, tickets);
                    break;
                case 2:
                    int balance = customer.getMoney();
                    System.out.println("Your Balance Is: " + balance);
                    break;
                case 3:
                    exit();
                    System.out.println("Exiting the program...");
                    System.out.println("System balance is " + this.getBalance());
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}
