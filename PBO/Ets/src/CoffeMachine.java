import java.util.ArrayList;

public class CoffeMachine {
    private final ArrayList<Coffee> coffee;

    CoffeMachine(){
        this.coffee = new ArrayList<>();
    }

    public void getList(){
        System.out.println("List of Coffe");
        for (Coffee value : coffee) {
            System.out.println("-----------------");
            value.getDetail();
        }
        System.out.println();
    }

    public void addCoffe(String name, int price){
        Coffee item = new Coffee(name,price);
        coffee.add(item);
    }

}
