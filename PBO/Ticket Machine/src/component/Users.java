package component;

public class Users {
    private int money;

    public Users() {
        this.money = 0;
    }

    public int getMoney(){
        return money;
    }

    public void InsertMoney(int amount){
        if(amount > 0){
            this.money += amount;
            System.out.println("Inserted Money: " + amount);
        }else{
            System.out.println("Insert a positive amount of money!");
        }
    }

    public int Pay(int price){
        if(price<0){
            System.out.println("Price have to be greater than 0!");
            return 0;
        }else if(price>this.money){
            System.out.println("Not Enough Money!");
            System.out.printf("Your Money Now: %d\n",this.money);
            System.out.printf("Your Money Need: %d\n",price);
            return 0;
        }else{
            this.money -= price;
            return 1;
        }
    }
}
