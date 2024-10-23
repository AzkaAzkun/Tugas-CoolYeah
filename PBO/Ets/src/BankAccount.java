public class BankAccount {
    private int deposit;

    BankAccount(){
        this.deposit = 0;
    }

    public int getDeposit(){
        return deposit;
    }

    public void withdraw(int money){
        deposit -= money;
    }

    public void addDeposit(int money){
        deposit += money;
    }
}
