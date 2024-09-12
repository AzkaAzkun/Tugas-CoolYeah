import component.Setting;
import component.Users;

public class Main {
    public static void main(String[] args) {
        Users customer = new Users();
        customer.InsertMoney(150000);
        Setting programs = new Setting(15000);

        programs.Run(customer);
    }
}