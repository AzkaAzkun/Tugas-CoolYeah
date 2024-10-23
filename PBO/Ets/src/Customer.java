public class Customer {
    private final BankAccount account;

    Customer(){
        this.account = new BankAccount();
    }

    public int deposit(){
        return account.getDeposit();
    }

    public void addDeposit(int money){
        if(money < 0){
            System.out.println("invalid money value");
        }else {
            account.addDeposit(money);
            System.out.println("deposit add money: " + money);
            System.out.println("your deposit now: " + account.getDeposit());
        }
    }

    public void withdraw(int money){
        int myDeposit = account.getDeposit();
        if(myDeposit < money){
            System.out.println("not enough money");
            System.out.println("your deposit now: " + account.getDeposit());
        }else {
            account.withdraw(money);
            System.out.println("you get money: " + money);
            System.out.println("your deposit now: " + account.getDeposit());
        }
    }
}
