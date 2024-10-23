public class Coffee {
    private String name;
    private int price;

    Coffee(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public void getDetail(){
        System.out.println("name: " + name);
        System.out.println("price: " + name);
    }
}
